package lapr4.jobs4u.interviewmanagement.application;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.data.util.Pair;

import lapr4.jobs4u.importer.answer.interview.generated.InterviewAnswersLexer;
import lapr4.jobs4u.importer.answer.interview.generated.InterviewAnswersParser;
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

    public EvaluateInterviewService(final InterviewRepository interviewRepository,
            final JobOpeningInterviewRepository jobOpeningInterviewRepository,
            final InterviewQuestionRepository interviewQuestionRepository) {
        this.interviewRepository = interviewRepository;
        this.jobOpeningInterviewRepository = jobOpeningInterviewRepository;
        this.interviewQuestionRepository = interviewQuestionRepository;
    }

    public void evaluateInterview(final JobOpening jobOpening) throws Exception {

        final Optional<JobOpeningInterview> jobOpeningInterview = jobOpeningInterviewRepository
                .findJobOpeningInterviewsByJobOpening(jobOpening);

        if (!jobOpeningInterview.isPresent()) {
            throw new Exception("Job Opening Interview not found");
        }

        final JobOpeningInterview theJobOpeningInterview = jobOpeningInterview.get();
        final QuestionImporterPlugin plugin = theJobOpeningInterview.plugin();
        final Iterable<InterviewQuestion> interviewQuestions = interviewQuestionRepository
                .findQuestionsByPlugin(plugin.identity().toString());
        Map<QuestionBody, Pair<Cotation, List<InterviewAnswer>>> interviewAnswersForQuestion = new HashMap<>();
        List<InterviewAnswer> interviewAnswers = new ArrayList<>();
        for (final InterviewQuestion interviewQuestion : interviewQuestions) {
            interviewAnswers.addAll(interviewQuestion.possibleAnswers());
            final Pair<Cotation, List<InterviewAnswer>> pair = Pair.of(interviewQuestion.cotation(), interviewAnswers);
            interviewAnswersForQuestion.put(interviewQuestion.questionBody(), pair);
        }

        Iterable<Interview> interview = interviewRepository.findInterviewsByJobOpening(jobOpening);

        if (!interview.iterator().hasNext()) {
            throw new Exception("Interview not found");
        }

        for (final Interview theInterview : interview) {
            final Double finalGrade = calculateGrade(interviewAnswersForQuestion, theInterview.file().toString());
            saveGrade(theInterview, finalGrade);
        }
    }

    private Double calculateGrade(
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

        Double grade = 0.0;
        for (final Map.Entry<QuestionBody, Pair<Cotation, List<InterviewAnswer>>> entry : interviewAnswersForQuestion
                .entrySet()) {
            final QuestionBody questionBody = entry.getKey();
            final Pair<Cotation, List<InterviewAnswer>> pair = entry.getValue();
            final Answer candidateAnswer = candidateAnswers.get(questionBody);
            
            Double answerRating = 0.0;
            for (final InterviewAnswer interviewAnswer : pair.getSecond()) {
                final Answer possibleAnswer = interviewAnswer.answer();
                if (possibleAnswer.equals(candidateAnswer)) {
                    answerRating = interviewAnswer.cotation().value();
                    break;
                }
            }

            final Double questionValue = pair.getFirst().value();

            grade += (answerRating / 100) * questionValue;
        }
        System.out.println("Grade: " + grade);
        return grade;
    }

    private void exportGrade() {
    }

    private void saveGrade(final Interview interview, final Double finalGrade) {
        interview.evaluate(Grade.valueOf(finalGrade.toString()));
        interviewRepository.save(interview);
    }
}