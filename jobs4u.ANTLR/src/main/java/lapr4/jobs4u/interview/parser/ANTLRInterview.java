package lapr4.jobs4u.interview.parser;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class ANTLRInterview {

    public void parseFromFile(final String path) throws Exception {
        final InterviewLexer lexer = new InterviewLexer(CharStreams.fromFileName(path));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final InterviewParser parser = new InterviewParser(tokens);
        final ParseTree tree = parser.start();

        if (parser.getNumberOfSyntaxErrors() > 0)
            throw new Exception();

        final String fileContent = Files.readString(Paths.get(path));
    }

    public void parseFromString(final String str) throws Exception {
        final InterviewLexer lexer = new InterviewLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final InterviewParser parser = new InterviewParser(tokens);
        final ParseTree tree = parser.start();

        if (parser.getNumberOfSyntaxErrors() > 0)
            throw new Exception();
    }
}