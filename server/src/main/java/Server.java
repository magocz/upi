import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String args[]) throws InterruptedException {

        System.setProperty("java.rmi.server.hostname", "192.168.1.31");

        try {
            int host = 7007;
            UPIControll obj = new UPIControllImpl();
            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(host);
            registry.bind("upi_server", obj);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
