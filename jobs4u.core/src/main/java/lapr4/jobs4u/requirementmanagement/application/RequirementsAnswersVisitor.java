package lapr4.jobs4u.requirementmanagement.application;

import lapr4.jobs4u.importer.answer.requirement.generated.RequirementsAnswersBaseVisitor;
import lapr4.jobs4u.importer.answer.requirement.generated.RequirementsAnswersParser;

/**
 * @author 2DI2
 */
public class RequirementsAnswersVisitor extends RequirementsAnswersBaseVisitor<String> {

    private String email;

    @Override
    public String visitStart(final RequirementsAnswersParser.StartContext ctx) {
        visitEmail(ctx.email());
        return email;
    }

    @Override
    public String visitEmail(final RequirementsAnswersParser.EmailContext ctx) {
        email = ctx.getText();
        return email;
    }
}
