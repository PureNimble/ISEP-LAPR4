package lapr4.jobs4u.persistence.impl.jpa;

import lapr4.jobs4u.Application;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaTransactionalContext;

/**
 * a base class for all reporting repositories to use the same persistence unit
 *
 * @param <T>
 * @param <K>
 *
 * @author 2DI2
 */
/* package */ class BaseJpaReportingRepositoryBase extends JpaTransactionalContext {

    BaseJpaReportingRepositoryBase() {
        super(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    BaseJpaReportingRepositoryBase(final String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties());
    }
}
