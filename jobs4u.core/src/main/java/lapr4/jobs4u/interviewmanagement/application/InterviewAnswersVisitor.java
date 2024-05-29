package lapr4.jobs4u.interviewmanagement.application;

import lapr4.jobs4u.importer.interview.answer.generated.InterviewAnswersBaseVisitor;
import lapr4.jobs4u.importer.interview.answer.generated.InterviewAnswersParser;

/**
 * @author 2DI2
 */
public class InterviewAnswersVisitor extends InterviewAnswersBaseVisitor<String> {

    private String email;

    @Override
    public String visitStart(final InterviewAnswersParser.StartContext ctx) {
        visitEmail(ctx.email());
        return email;
    }

    @Override
    public String visitEmail(final InterviewAnswersParser.EmailContext ctx) {
        email = ctx.getText();
        return email;
    }
}
