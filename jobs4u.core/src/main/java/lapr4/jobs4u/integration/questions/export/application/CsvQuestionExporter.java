package lapr4.jobs4u.integration.questions.export.application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import lapr4.jobs4u.questionmanagement.domain.Answer;
import lapr4.jobs4u.questionmanagement.domain.Question;

public class CsvQuestionExporter implements QuestionExporter {
    private PrintWriter stream;

    @Override
    public void begin(final String filename) throws IOException {
        stream = new PrintWriter(new FileWriter(filename));
        stream.println("type;body;possibleAnswers");
    }

    @Override
    public void element(final Question e) {
        stream.print(e.questionType() + ";" + e.questionBody() + ";");
        for (int i = 0; i < e.possibleAnswers().size(); i++) {
            Answer a = e.possibleAnswers().get(i);
            stream.print(a.text());
            if (i < e.possibleAnswers().size() - 1) {
                stream.print(",");
            }
        }
        stream.println();
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
    public void begin(String filename, String plugin) throws IOException {
        throw new UnsupportedOperationException("Unimplemented method 'begin'");
    }
}