package lapr4.jobs4u.requirement.parser;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class ANTLRRequirements {

    public void parseFromFile(final String path) throws Exception {
        final RequirementsLexer lexer = new RequirementsLexer(CharStreams.fromFileName(path));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final RequirementsParser parser = new RequirementsParser(tokens);
        final ParseTree tree = parser.start();

        if (parser.getNumberOfSyntaxErrors() > 0)
            throw new Exception();

        final String fileContent = Files.readString(Paths.get(path));
    }
}
