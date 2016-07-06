import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class App {

    public static void main(String[] args) {
        try {
            int host = 7007;
            Registry registry = LocateRegistry.getRegistry("192.168.1.31", host);
            UPIControll stub = (UPIControll) registry.lookup("upi_server");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
