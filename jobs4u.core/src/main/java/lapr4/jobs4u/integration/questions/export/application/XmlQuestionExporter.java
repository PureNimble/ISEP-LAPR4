package lapr4.jobs4u.integration.questions.export.application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import lapr4.jobs4u.questionmanagement.domain.Answer;
import lapr4.jobs4u.questionmanagement.domain.Question;

public class XmlQuestionExporter implements QuestionExporter {

    private PrintWriter stream;

    @Override
    public void begin(final String filename) throws IOException {
        stream = new PrintWriter(new FileWriter(filename));
        stream.println("<Questions>");
    }

    @Override
    public void element(final Question e) {
        stream.println("<Question>");
        stream.printf("<type>%s</type>%n", e.questionType());
        stream.printf("<body>%s</body>%n", e.questionBody());
        stream.println("<possibleAnswersList>");
        for (Answer a : e.possibleAnswers()) {
            stream.printf("<possibleAnswers>%s</possibleAnswers>%n", a.text());
        }
        stream.println("</possibleAnswersList>");
        stream.println("</Question>");
    }

    @Override
    public void elementSeparator() {
        // nothing to do
    }

    @Override
    public void end() {
        stream.println("</Questions>");
        stream.close();
    }

    @Override
    public void cleanup() {
        if (stream != null) {
            stream.close();
        }
    }
}
