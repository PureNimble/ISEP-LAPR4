package lapr4.jobs4u;

/**
 * A "global" static class with the application registry of well known objects
 *
 *
 * @author 2DI2
 */
public class Application {

    public static final String VERSION = "1.1.0";
    public static final String COPYRIGHT = "(C) 2024, Jobs4U";

    private static final AppSettings SETTINGS = new AppSettings();

    public static AppSettings settings() {
        return SETTINGS;
    }

    private Application() {
        // private visibility to ensure singleton & utility
    }
}
