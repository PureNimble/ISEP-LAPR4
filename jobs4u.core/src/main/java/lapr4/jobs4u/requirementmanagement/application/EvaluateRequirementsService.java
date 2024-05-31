package lapr4.jobs4u.requirementmanagement.application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.data.util.Pair;

import lapr4.jobs4u.applicationmanagement.domain.OutcomeValue;
import lapr4.jobs4u.exporter.requirement.answer.generated.EvaluateRequirementsAnswersLexer;
import lapr4.jobs4u.exporter.requirement.answer.generated.EvaluateRequirementsAnswersParser;
import lapr4.jobs4u.importer.requirement.answer.generated.RequirementsAnswersLexer;
import lapr4.jobs4u.importer.requirement.answer.generated.RequirementsAnswersParser;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningRequirement;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRequirementRepository;
import lapr4.jobs4u.questionmanagement.domain.Answer;
import lapr4.jobs4u.questionmanagement.domain.QuestionBody;
import lapr4.jobs4u.questionmanagement.domain.RequirementsQuestion;
import lapr4.jobs4u.questionmanagement.repositories.RequirementsQuestionRepository;
import lapr4.jobs4u.requirementmanagement.domain.Requirement;
import lapr4.jobs4u.requirementmanagement.repositories.RequirementRepository;

/**
 * @author 2DI2
 */
public class EvaluateRequirementsService {

    private final RequirementRepository requirementRepository;
    private final JobOpeningRequirementRepository jobOpeningRequirementRepository;
    private final RequirementsQuestionRepository requirementsQuestionRepository;
    private static final String PATH = "jobs4u.ANTLR/src/main/resources/output/answer/Evaluated";

    public EvaluateRequirementsService(final RequirementRepository requirementRepository,
            final JobOpeningRequirementRepository jobOpeningRequirementRepository,
            final RequirementsQuestionRepository requirementsQuestionRepository) {
        this.requirementRepository = requirementRepository;
        this.jobOpeningRequirementRepository = jobOpeningRequirementRepository;
        this.requirementsQuestionRepository = requirementsQuestionRepository;
    }

    public void evaluateRequirement(final JobOpening jobOpening) throws Exception {

        final Optional<JobOpeningRequirement> jobOpeningRequirement = jobOpeningRequirementRepository
                .findJobOpeningRequirementsByJobOpening(jobOpening);

        if (!jobOpeningRequirement.isPresent()) {
            throw new Exception("Job Opening Requirement Specification not found");
        }

        final JobOpeningRequirement theJobOpeningRequirement = jobOpeningRequirement.get();
        final QuestionImporterPlugin plugin = theJobOpeningRequirement.plugin();
        final Iterable<RequirementsQuestion> requirementQuestions = requirementsQuestionRepository
                .findQuestionsByPlugin(plugin);
        Map<QuestionBody, List<Answer>> requirementAnswersForQuestion = new LinkedHashMap<>();        
        for (final RequirementsQuestion requirementsQuestions : requirementQuestions) {
            final List<Answer> answers = new ArrayList<>();
            answers.addAll(requirementsQuestions.possibleAnswers());
            requirementAnswersForQuestion.put(requirementsQuestions.questionBody(), answers);
        }

        Iterable<Requirement> requirement = requirementRepository.findRequirementsByJobOpening(jobOpening);

        if (!requirement.iterator().hasNext()) {
            throw new Exception("Requirement Specification not found");
        }

        for (final Requirement theRequirement : requirement) {
            final Pair<String, List<Pair<String, String>>> result = decideResult(requirementAnswersForQuestion,
                    theRequirement.file().toString());
            exportResult(result, theRequirement.file().toString());
            saveResult(theRequirement, result);
        }
    }

    private Pair<String, List<Pair<String, String>>> decideResult(
                final Map<QuestionBody, List<Answer>> requirementAnswersForQuestion,
                final String file) throws IOException {

            final Path filePath = Paths.get(file);
            final CharStream charStream = CharStreams.fromPath(filePath);
            final RequirementsAnswersLexer lexer = new RequirementsAnswersLexer(charStream);
            final CommonTokenStream tokens = new CommonTokenStream(lexer);
            final RequirementsAnswersParser parser = new RequirementsAnswersParser(tokens);
            final ParseTree tree = parser.start();
            int correctAnswers = 0;
            int totalAnswers = 0;

            if (parser.getNumberOfSyntaxErrors() > 0) {
                throw new IOException("Syntax error in file");
            }

            final EvaluateRequirementsAnswersVisitor visitor = new EvaluateRequirementsAnswersVisitor();
            final Map<QuestionBody, Answer> candidateAnswers = visitor.visit(tree);
            totalAnswers = candidateAnswers.size();

            List<Pair<String, String>> individualResults = new ArrayList<>();
            Pair<String, String> individualPair = null;
            Pair<String, List<Pair<String, String>>> resultPair;

            for (final Map.Entry<QuestionBody, List<Answer>> entry : requirementAnswersForQuestion
                    .entrySet()) {
                final QuestionBody questionBody = entry.getKey();
                final List<Answer> answers = entry.getValue();
                final Optional<RequirementsQuestion> question = requirementsQuestionRepository.findQuestionByBody(questionBody);
                final Answer candidateAnswer = candidateAnswers.get(questionBody);
                individualPair = Pair.of("NOT MET", question.get().minimumRequirement().toString());

                for (final Answer answer : answers) {
                    final Answer possibleAnswer = answer.answer();
                    final String possibleAnswerText = possibleAnswer.toString();
                    String[] candidateWords = candidateAnswer.toString().toLowerCase().split(",\\s*");
                    boolean isCorrect = Arrays.stream(candidateWords)
                            .anyMatch(word -> word.equals(possibleAnswerText.toLowerCase()));
                    if (isCorrect) {
                        individualPair = Pair.of("MET", "");
                        correctAnswers++;
                        break;
                    }
                }
                individualResults.add(individualPair);
            }
            if (correctAnswers != totalAnswers) {
                resultPair = Pair.of(OutcomeValue.REJECTED.toString(), individualResults);
            } else {
                resultPair = Pair.of(OutcomeValue.APPROVED.toString(), individualResults);
            }
            return resultPair;
        }

    private void exportResult(final Pair<String, List<Pair<String, String>>> resultPair, final String file) throws IOException {

        StringBuilder content = new StringBuilder();
        int index = 0;
        final List<String> lines = Files.readAllLines(Paths.get(file));
        for (final String line : lines) {
            content.append(line).append("\n");
            if (line.contains("ANSWER:")) {
                String individualResult = resultPair.getSecond().get(index).getFirst();
                if (individualResult.equals("MET")) {
                    content.append(String.format("REQUIREMENT RESULT: %s", individualResult)).append("\n");
                } else {
                    content.append(String.format("REQUIREMENT RESULT: %s", individualResult)).append("\n");
                    content.append(String.format("JUSTIFICATION: %s", resultPair.getSecond().get(index).getSecond())).append("\n");
                }
                
                index++;
                continue;
            }

            if (line.contains("EMAIL:")) {
                final String result = resultPair.getFirst();
                content.append(String.format("RESULT: %s", result)).append("\n");
            }
        }

        final CodePointCharStream charStream = CharStreams.fromString(content.toString());
        final EvaluateRequirementsAnswersLexer lexer = new EvaluateRequirementsAnswersLexer(charStream);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final EvaluateRequirementsAnswersParser parser = new EvaluateRequirementsAnswersParser(tokens);

        parser.start();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            throw new IOException("Syntax error in template file");
        }

        final String newFileName = PATH + Paths.get(file).getFileName().toString();

        final PrintWriter stream = new PrintWriter(new FileWriter(newFileName));
        stream.print(content.toString());
        stream.close();
    }

    private void saveResult(final Requirement requirement, final Pair<String, List<Pair<String, String>>>  result) {
        String outcome = result.getFirst();
        if (outcome == OutcomeValue.REJECTED.toString()) {
            requirement.addResult(outcome, "The minimum requirements are not met");
        } else if (outcome == OutcomeValue.APPROVED.toString()) {
            requirement.addResult(outcome);
        } else {
            throw new IllegalArgumentException("Invalid result");
        }
        requirementRepository.save(requirement);
    }
}