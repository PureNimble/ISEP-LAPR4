package lapr4.jobs4u.infrastructure.bootstrapers.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;
import lapr4.jobs4u.questionmanagement.application.RegisterQuestionTypeController;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class QuestionTypeBootstrapper implements Action {

	private static final Logger LOGGER = LogManager.getLogger(StandardQuestionImporterPluginsBootstrapper.class);

	RegisterQuestionTypeController registerQuestionTypeController = new RegisterQuestionTypeController(
			AuthzRegistry.authorizationService(), PersistenceContext.repositories().questionType());

	@Override
	public boolean execute() {
		
		register("True/False");
		register("Short text answer");
		register("Choice, with single answer");
		register("Choice, with multiple answers");
		register("Integer Number");
		register("Decimal Number");
		register("Date");
		register("Time");
		register("Numeric Scale");

		return true;
	}

	private void register(final String type) {
		try {
			registerQuestionTypeController.registerQuestionType(type);
			LOGGER.info(type);
		} catch (final IntegrityViolationException | ConcurrencyException e) {
			// ignoring exception. assuming it is just a primary key violation
			// due to the tentative of inserting a duplicated plugin during bootstrap
			LOGGER.warn("Assuming {} already exists (activate trace log for details)", type);
			LOGGER.trace("Assuming existing record", e);
		}
	}
}
