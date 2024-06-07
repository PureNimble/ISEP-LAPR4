package lapr4.jobs4u.infrastructure.persistence;

import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lapr4.jobs4u.Application;
import eapli.framework.util.Utility;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * provides easy access to the persistence layer. works as a factory of
 * factories
 *
 * 
 * @author 2DI2
 */
@Utility
public final class PersistenceContext {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceContext.class);

    private static RepositoryFactory theFactory;
    private static EntityManagerFactory entityManagerFactory;

    private PersistenceContext() {
        // ensure utility
    }

    public static RepositoryFactory repositories() {
        if (theFactory == null) {
            final String factoryClassName = Application.settings().getRepositoryFactory();
            try {
                theFactory = (RepositoryFactory) Class.forName(factoryClassName).getDeclaredConstructor().newInstance();
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                    | IllegalArgumentException | InvocationTargetException | ClassNotFoundException ex) {
                LOGGER.error("Unable to dynamically load the Repository Factory", ex);
                throw new IllegalStateException(
                        "Unable to dynamically load the Repository Factory: " + factoryClassName, ex);
            }
        }
        return theFactory;
    }

    public static EntityManagerFactory entityManagerFactory() {
        if (entityManagerFactory == null) {
            final String persistenceUnitName = Application.settings().getPersistenceUnitName();
            entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        }
        return entityManagerFactory;
    }
}
