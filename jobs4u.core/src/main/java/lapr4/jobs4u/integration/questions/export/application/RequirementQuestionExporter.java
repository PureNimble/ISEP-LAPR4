package lapr4.jobs4u.integration.questions.export.application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import lapr4.jobs4u.questionmanagement.domain.Question;

public class RequirementQuestionExporter implements QuestionExporter {
    private PrintWriter stream;

    @Override
    public void begin(final String filename) throws IOException {
        stream = new PrintWriter(new FileWriter(filename));
        stream.println("REQUIREMENT\nNAME:\n");
    }

    @Override
    public void element(final Question e) {
        stream.printf("QUESTION TYPE: %s\n", e.questionType());
        stream.println("QUESTION: " + e.questionBody());
        stream.println("ANSWER:\n");
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
}
