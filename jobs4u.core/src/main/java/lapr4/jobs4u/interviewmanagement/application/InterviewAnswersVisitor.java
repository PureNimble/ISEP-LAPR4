package lapr4.jobs4u.interviewmanagement.application;

import lapr4.jobs4u.importer.answer.interview.generated.InterviewAnswersBaseVisitor;
import lapr4.jobs4u.importer.answer.interview.generated.InterviewAnswersParser;

/**
 * @author 2DI2
 */
public class InterviewAnswersVisitor extends InterviewAnswersBaseVisitor<String> {

    private String email;

    @Override
    public String visitStart(InterviewAnswersParser.StartContext ctx) {
        visitEmail(ctx.email());
        return email;
    }

    @Override
    public String visitEmail(InterviewAnswersParser.EmailContext ctx) {
        email = ctx.getText();
        return email;
    }
}
