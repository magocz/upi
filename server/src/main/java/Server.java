import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String args[]) {

        try {
            int host = 1234;
            UPIControll obj = new UPIControllImpl();
            UPIControll stub = (UPIControll) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(host);
            registry.bind("upi_server", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
