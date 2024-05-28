package lapr4.jobs4u.persistence.impl.inmemory;

import lapr4.jobs4u.infrastructure.bootstrapers.Bootstrapper;

/**
 * @author 2DI2
 */
final class InMemoryInitializer {

    private static class LazyHolder {
        private static final InMemoryInitializer INSTANCE = new InMemoryInitializer();

        private LazyHolder() {
        }
    }

    private InMemoryInitializer() {
        // to ensure some default test data is available, specially when using
        // in memory persistence
        new Bootstrapper().execute();
    }

    private void initialize() {
        // nothing to do; data has already been initialized in the singleton
        // constructor.
    }

    public static void init() {
        LazyHolder.INSTANCE.initialize();
    }
}
