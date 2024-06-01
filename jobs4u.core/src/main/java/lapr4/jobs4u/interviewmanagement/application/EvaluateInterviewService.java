package lapr4.jobs4u.interviewmanagement.application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.data.util.Pair;

import lapr4.jobs4u.exporter.interview.answer.generated.EvaluateInterviewAnswersLexer;
import lapr4.jobs4u.exporter.interview.answer.generated.EvaluateInterviewAnswersParser;
import lapr4.jobs4u.importer.interview.answer.generated.InterviewAnswersLexer;
import lapr4.jobs4u.importer.interview.answer.generated.InterviewAnswersParser;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.interviewmanagement.domain.Grade;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningInterview;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningInterviewRepository;
import lapr4.jobs4u.questionmanagement.domain.Answer;
import lapr4.jobs4u.questionmanagement.domain.Cotation;
import lapr4.jobs4u.questionmanagement.domain.InterviewAnswer;
import lapr4.jobs4u.questionmanagement.domain.InterviewQuestion;
import lapr4.jobs4u.questionmanagement.domain.QuestionBody;
import lapr4.jobs4u.questionmanagement.repositories.InterviewQuestionRepository;

/**
 * @author 2DI2
 */
public class EvaluateInterviewService {

    private final InterviewRepository interviewRepository;
    private final JobOpeningInterviewRepository jobOpeningInterviewRepository;
    private final InterviewQuestionRepository interviewQuestionRepository;
    private static final String PATH = "jobs4u.ANTLR/src/main/resources/output/answer/Evaluated";

    public EvaluateInterviewService(final InterviewRepository interviewRepository,
            final JobOpeningInterviewRepository jobOpeningInterviewRepository,
            final InterviewQuestionRepository interviewQuestionRepository) {
        this.interviewRepository = interviewRepository;
        this.jobOpeningInterviewRepository = jobOpeningInterviewRepository;
        this.interviewQuestionRepository = interviewQuestionRepository;
    }

    public void evaluateInterview(final JobOpening jobOpening) throws Exception {

        final JobOpeningInterview theJobOpeningInterview = jobOpeningInterviewRepository
                .findJobOpeningInterviewsByJobOpening(jobOpening)
                .orElseThrow(() -> new Exception("Job Opening Interview not found"));

        final QuestionImporterPlugin plugin = theJobOpeningInterview.plugin();
        final Iterable<InterviewQuestion> interviewQuestions = interviewQuestionRepository
                .findQuestionsByPlugin(plugin);

        Map<QuestionBody, Pair<Cotation, List<InterviewAnswer>>> interviewAnswersForQuestion = new HashMap<>();

        for (final InterviewQuestion interviewQuestion : interviewQuestions) {
            final List<InterviewAnswer> interviewAnswers = interviewQuestion.possibleAnswers();
            final Pair<Cotation, List<InterviewAnswer>> pair = Pair.of(interviewQuestion.cotation(), interviewAnswers);
            interviewAnswersForQuestion.put(interviewQuestion.questionBody(), pair);
        }

        final Iterable<Interview> interview = interviewRepository.findNonGradedInterviewsByJobOpening(jobOpening);

        if (!interview.iterator().hasNext()) {
            throw new Exception("There are no Interviews to evaluate");
        }

        for (final Interview theInterview : interview) {
            final Pair<Double, List<Double>> resultPair = calculateGrade(interviewAnswersForQuestion,
                    theInterview.file().toString());
            saveGrade(theInterview, resultPair.getFirst());
            exportGrade(resultPair, theInterview.file().toString());
        }
    }

    private Pair<Double, List<Double>> calculateGrade(
            final Map<QuestionBody, Pair<Cotation, List<InterviewAnswer>>> interviewAnswersForQuestion,
            final String file) throws IOException {

        final Path filePath = Paths.get(file);
        final CharStream charStream = CharStreams.fromPath(filePath);
        final InterviewAnswersLexer lexer = new InterviewAnswersLexer(charStream);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final InterviewAnswersParser parser = new InterviewAnswersParser(tokens);
        final ParseTree tree = parser.start();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            throw new IOException("Syntax error in file");
        }

        final EvaluateInterviewAnswersVisitor visitor = new EvaluateInterviewAnswersVisitor();
        final Map<QuestionBody, Answer> candidateAnswers = visitor.visit(tree);
        List<Double> cotations = new ArrayList<>();

        Double finalGrade = 0.0;
        for (final Map.Entry<QuestionBody, Pair<Cotation, List<InterviewAnswer>>> entry : interviewAnswersForQuestion
                .entrySet()) {
            final QuestionBody questionBody = entry.getKey();
            final Pair<Cotation, List<InterviewAnswer>> pair = entry.getValue();
            final Answer candidateAnswer = candidateAnswers.get(questionBody);

            Double answerCotation = 0.0;
            for (final InterviewAnswer interviewAnswer : pair.getSecond()) {
                final Answer possibleAnswer = interviewAnswer.answer();
                if (possibleAnswer.equals(candidateAnswer)) {
                    answerCotation = interviewAnswer.cotation().value();
                    break;
                }
            }
            cotations.add(answerCotation);

            final Double questionValue = pair.getFirst().value();

            finalGrade += (answerCotation / 100) * questionValue;
        }

        return Pair.of(finalGrade, cotations);
    }

    private void exportGrade(final Pair<Double, List<Double>> resultPair, final String file) throws IOException {

        StringBuilder content = new StringBuilder();
        int index = 0;
        final List<String> lines = Files.readAllLines(Paths.get(file));
        for (final String line : lines) {
            content.append(line).append("\n");
            if (line.contains("ANSWER:")) {
                double grade = resultPair.getSecond().get(index);
                if (grade == Math.floor(grade)) {
                    content.append(String.format("GRADE: %.0f%%", grade)).append("\n");
                } else {
                    content.append(String.format("GRADE: %.2f%%", grade)).append("\n");
                }
                index++;
                continue;
            }

            if (line.contains("EMAIL:")) {
                double grade = resultPair.getSecond().get(index);
                if (grade == Math.floor(grade)) {
                    content.append(String.format("FINAL GRADE: %.0f%%", grade)).append("\n");
                } else {
                    content.append(String.format("FINAL GRADE: %.2f%%", grade)).append("\n");
                }
            }
        }

        final CodePointCharStream charStream = CharStreams.fromString(content.toString());
        final EvaluateInterviewAnswersLexer lexer = new EvaluateInterviewAnswersLexer(charStream);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final EvaluateInterviewAnswersParser parser = new EvaluateInterviewAnswersParser(tokens);

        parser.start();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            throw new IOException("Syntax error in template file");
        }

        final String newFileName = PATH + Paths.get(file).getFileName().toString();

        final PrintWriter stream = new PrintWriter(new FileWriter(newFileName));
        stream.print(content.toString());
        stream.close();
    }

    private void saveGrade(final Interview interview, final Double finalGrade) {
        interview.evaluate(Grade.valueOf(finalGrade.toString()));
        interviewRepository.save(interview);
    }
}