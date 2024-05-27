package lapr4.jobs4u.requirementmanagement.application;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import lapr4.jobs4u.importer.answer.requirement.generated.RequirementsAnswersLexer;
import lapr4.jobs4u.importer.answer.requirement.generated.RequirementsAnswersParser;
import lapr4.jobs4u.requirementmanagement.domain.Requirement;
import lapr4.jobs4u.requirementmanagement.repositories.RequirementRepository;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.File;

/**
 * @author 2DI2
 */
public class UploadRequirementService {

    private final RequirementRepository requirementRepository;

    public UploadRequirementService(final RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }

    public void registerRequirement(final Requirement requirement, final File file) {
        requirement.addFile(file);
        requirementRepository.save(requirement);
    }

    public boolean isCorrectRequirement(final Requirement requirement, final String file) throws IOException {

        final Path filePath = Paths.get(file);
        final CharStream charStream = CharStreams.fromPath(filePath);
		final RequirementsAnswersLexer lexer = new RequirementsAnswersLexer(charStream);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final RequirementsAnswersParser parser = new RequirementsAnswersParser(tokens);
		final ParseTree tree = parser.start();
        
        if (parser.getNumberOfSyntaxErrors() > 0) {
            throw new IOException("Syntax error in file");
        }
        
        final RequirementsAnswersVisitor visitor = new RequirementsAnswersVisitor();
        final String email = visitor.visit(tree);
        if (email == null || !email.equals(requirement.application().candidate().emailAddress().toString())) {
            return false;
        }

        return true;
    }

    public Optional<Requirement> findRequirement(final Application application) {
        return requirementRepository.findRequirement(application);
    }
}
