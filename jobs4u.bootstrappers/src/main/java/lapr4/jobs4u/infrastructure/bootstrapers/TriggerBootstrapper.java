package lapr4.jobs4u.infrastructure.bootstrapers;

import java.util.List;

import org.h2.jdbc.JdbcSQLSyntaxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eapli.framework.actions.Action;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lapr4.jobs4u.infrastructure.persistence.PersistenceContext;

public class TriggerBootstrapper implements Action {

	private EntityManager entityManager;
	private static final Logger LOGGER = LoggerFactory.getLogger(TriggerBootstrapper.class);
	private final List<String> triggersNames = List.of("ANALYSISPHASE_TRIGGER", "APPLICATIONPHASE_TRIGGER",
			"INTERVIEWPHASE_TRIGGER", "RESULTPHASE_TRIGGER", "SCREENINGPHASE_TRIGGER", "APPLICATIONRESULT_TRIGGER",
			"REQUIREMENTRESULT_TRIGGER", "APPLICATIONINSERT_TRIGGER");
	private final List<String> tables = List.of("T_ANALYSIS_PHASE", "T_APPLICATION_PHASE", "T_INTERVIEW_PHASE",
			"T_RESULT_PHASE", "T_SCREENING_PHASE", "T_RESULT", "T_REQUIREMENT", "T_APPLICATION");

	TriggerBootstrapper() {
		this.entityManager = PersistenceContext.entityManagerFactory().createEntityManager();
	}

	@Override
	public boolean execute() {

		EntityTransaction transaction = null;
		boolean success = true;
		String type, sql;

		try {
			// Drop all triggers
			for (String triggerName : triggersNames) {
				sql = dropTrigger(triggerName);
				transaction = entityManager.getTransaction();
				try {
					transaction.begin();
					entityManager.createNativeQuery(sql).executeUpdate();
					transaction.commit();
					LOGGER.debug(triggerName + " trigger dropped");
				} catch (RuntimeException e) {
					transaction.commit();
				}
			}

			// Create all triggers
			for (int i = 0; i < triggersNames.size(); i++) {
				if (i == triggersNames.size() - 1) {
					type = "INSERT";
				} else {
					type = "UPDATE";
				}
				sql = createTrigger(triggersNames.get(i), tables.get(i), type);
				transaction = entityManager.getTransaction();
				try {
					transaction.begin();
					entityManager.createNativeQuery(sql).executeUpdate();
					transaction.commit();
					LOGGER.debug(triggersNames.get(i) + " trigger created");
				} catch (RuntimeException e) {
					if (transaction != null && transaction.isActive()) {
						transaction.rollback();
					}
					LOGGER.error("Error executing SQL trigger", e);
					throw e;
				}
			}

		} catch (RuntimeException e) {
			LOGGER.error("Error reading SQL trigger file or executing SQL trigger", e);
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			success = false;
		} finally {

			if (entityManager != null) {
				entityManager.close();
			}
		}

		return success;

	}

	private String createTrigger(String triggerName, String table, String type) {

		return "CREATE TRIGGER " + triggerName + " AFTER " + type + " ON " + table + " FOR EACH ROW "
				+ "CALL \"lapr4.jobs4u.TriggerDataSender\"; ";
	}

	private String dropTrigger(String triggerName) {

		return "DROP TRIGGER " + triggerName + ";";
	}

}