package lapr4.jobs4u.integration.questions.export.application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import lapr4.jobs4u.questionmanagement.domain.Question;

public class RequirementQuestionExporter implements QuestionExporter {
    private PrintWriter stream;

    @Override
    public void begin(final String filename, final String plugin) throws IOException {
        stream = new PrintWriter(new FileWriter(filename));
        stream.printf("TITLE: %s\nNAME:\n", plugin);
    }

    @Override
    public void element(final Question e) {
        stream.printf("\nQUESTION TYPE: %s\n", e.questionType());
        stream.println("# " + e.questionBody());
        stream.println("ANSWER:");
    }

    @Override
    public void elementSeparator() {
        // nothing to do
    }

    @Override
    public void end() {
        stream.close();
    }

    @Override
    public void cleanup() {
        if (stream != null) {
            stream.close();
        }
    }

    @Override
    public void begin(String filename) throws IOException {
        throw new UnsupportedOperationException("Unimplemented method 'begin'");
    }
}
