package android.os;


public class ServiceManager {

    public static IBinder getService(String name) {
        throw new RuntimeException("STUB");
    }

    /**
     * Place a new @a service called @a name into the service
     * manager.
     *
     * @param name the name of the new service
     * @param service the service object
     */
    public static void addService(String name, IBinder service) {
        throw new RuntimeException("STUB");
    }
}
