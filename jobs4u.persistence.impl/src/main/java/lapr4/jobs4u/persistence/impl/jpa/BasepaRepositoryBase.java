package lapr4.jobs4u.persistence.impl.jpa;

import lapr4.jobs4u.Application;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaTransactionalRepository;

/**
 * a base class for all transactional repositories to use the same persistence
 * unit
 *
 * @param <T>
 * @param <K>
 *
 * @author 2DI2
 */
/* package */ class BasepaRepositoryBase<T, K, I>
        extends JpaTransactionalRepository<T, K, I> {

    BasepaRepositoryBase(final String persistenceUnitName, final String identityFieldName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(),
                identityFieldName);
    }

    BasepaRepositoryBase(final String identityFieldName) {
        super(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties(), identityFieldName);
    }
}
