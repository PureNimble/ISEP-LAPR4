package lapr4.jobs4u.interviewmanagement.application;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.File;
import lapr4.jobs4u.errors.CustomErrorListener;
import lapr4.jobs4u.errors.CustomErrorStrategy;
import lapr4.jobs4u.importer.interview.answer.generated.InterviewAnswersLexer;
import lapr4.jobs4u.importer.interview.answer.generated.InterviewAnswersParser;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;

/**
 * @author 2DI2
 */
public class UploadInterviewService {

    private final InterviewRepository interviewRepository;

    public UploadInterviewService(final InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    public void registerInterview(final Interview interview, final File file) {
        interview.addFile(file);
        interviewRepository.save(interview);
    }

    public boolean isCorrectInterview(final Interview interview, final String file) throws IOException {

        final Path filePath = Paths.get(file);
        final CharStream charStream = CharStreams.fromPath(filePath);
		final InterviewAnswersLexer lexer = new InterviewAnswersLexer(charStream);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final InterviewAnswersParser parser = new InterviewAnswersParser(tokens);
        parser.setErrorHandler(new CustomErrorStrategy());
        parser.removeErrorListeners();
        parser.addErrorListener(CustomErrorListener.INSTANCE);
		final ParseTree tree = parser.start();
        
        if (parser.getNumberOfSyntaxErrors() > 0) {
            throw new IOException("Syntax error in file");
        }
        
        final InterviewAnswersVisitor visitor = new InterviewAnswersVisitor();
        final String email = visitor.visit(tree);
        if (email == null || !email.equals(interview.application().candidate().emailAddress().toString())) {
            return false;
        }

        return true;
    }

    public Optional<Interview> findInterviewByApplication(final Application application) {
        return interviewRepository.findInterviewByApplication(application);
    }
}
