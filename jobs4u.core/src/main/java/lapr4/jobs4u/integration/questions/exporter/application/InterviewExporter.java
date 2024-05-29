package lapr4.jobs4u.integration.questions.exporter.application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import lapr4.jobs4u.exporter.interview.generated.InterviewLexer;
import lapr4.jobs4u.exporter.interview.generated.InterviewParser;
import lapr4.jobs4u.integration.questions.importer.domain.QuestionImporterPlugin;
import lapr4.jobs4u.questionmanagement.domain.InterviewQuestion;
import lapr4.jobs4u.questionmanagement.domain.RequirementsQuestion;

/**
 * @author 2DI2
 */
public class InterviewExporter implements QuestionExporter {

    private StringBuilder content;
    private PrintWriter stream;
    private String filename;

    @Override
    public void begin(final String filename, final QuestionImporterPlugin plugin) throws IOException {
        this.filename = filename;
        content = new StringBuilder();
        content.append(String.format("TITLE: %s\nNAME:\nEMAIL:\n", plugin.identity().toString()));
    }

    @Override
    public void element(final InterviewQuestion e) {
        if (e.cotation().value() == Math.floor(e.cotation().value())) {
            content.append(
                    String.format("\nCOTATION: %d%s\n", (int) e.cotation().value().doubleValue(), e.cotationType()));
        } else {
            content.append(String.format("\nCOTATION: %.2f%s\n", e.cotation().value(), e.cotationType()));
        }
        content.append(String.format("QUESTION TYPE: %s\n", e.questionType()));
        if (e.questionType().identity().contains("Choice")) {
            content.append("QUESTION: ");
            String[] parts = e.questionBody().toString().split(" (?=\\[\\d+\\])");
            for (String part : parts) {
                if (!part.isEmpty()) {
                    content.append(part.trim()).append("\n");
                }
            }
        } else
            content.append("QUESTION: ").append(e.questionBody()).append("\n");

        content.append("ANSWER:\n");
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
            } catch (IOException e) {
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
        final InterviewLexer lexer = new InterviewLexer(charStream);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final InterviewParser parser = new InterviewParser(tokens);

        try {
            parser.start();
            if (parser.getNumberOfSyntaxErrors() > 0) {
                try {
                    throw new IOException("Syntax error in template file");
                } catch (final IOException e) {
                    return false;
                }
            }
            return true;
        } catch (final IllegalStateException e) {
            return false;
        }
    }

    @Override
    public void element(final RequirementsQuestion e) {
        // nothing to do
    }
}