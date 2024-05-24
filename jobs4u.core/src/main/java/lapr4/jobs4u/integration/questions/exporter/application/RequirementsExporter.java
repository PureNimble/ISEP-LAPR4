package lapr4.jobs4u.integration.questions.exporter.application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import lapr4.jobs4u.exporter.requirement.generated.RequirementsLexer;
import lapr4.jobs4u.exporter.requirement.generated.RequirementsParser;
import lapr4.jobs4u.questionmanagement.domain.InterviewQuestion;
import lapr4.jobs4u.questionmanagement.domain.RequirementsQuestion;

public class RequirementsExporter implements QuestionExporter {

    private StringBuilder content;
    private PrintWriter stream;
    private String filename;

    @Override
    public void begin(final String filename, final String plugin) throws IOException {
        this.filename = filename;
        content = new StringBuilder();
        content.append(String.format("TITLE: %s\nNAME:\nEMAIL:\n", plugin));
    }

    @Override
    public void element(final RequirementsQuestion e) {
        content.append(String.format("\n# " + e.questionBody()));
        content.append(String.format("\nANSWER:\n"));
    }

    @Override
    public void elementSeparator() {
        // nothing to do
    }

    @Override
    public void end() {
        if (isValid(content.toString())) {
            try {
                stream = new PrintWriter(new FileWriter(filename));
                stream.print(content.toString());
            } catch (final IOException e) {
                return;
            }
        }
    }

    @Override
    public void cleanup() {
        if (stream != null) {
            stream.close();
        }
    }

    private boolean isValid(final String content) {
        // parse
        final CodePointCharStream charStream = CharStreams.fromString(content);
        final RequirementsLexer lexer = new RequirementsLexer(charStream);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final RequirementsParser parser = new RequirementsParser(tokens);

        try {
            parser.start();
            if (parser.getNumberOfSyntaxErrors() > 0) {
                try {
                    throw new IOException("Syntax error in template file");
                } catch (IOException e) {
                    return false;
                }
            }
            return true;
        } catch (final IllegalStateException e) {
            return false;
        }
    }

    @Override
    public void element(final InterviewQuestion e) {
        // nothing to do
    }
}
