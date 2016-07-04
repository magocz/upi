import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class App {

    public static void main(String[] args) {
        try {
            int host = 1234;
            Registry registry = LocateRegistry.getRegistry("localhost",host);
            UPIControll stub = (UPIControll) registry.lookup("upi_server");
            stub.testMethod("dfgfgfsd sd sd sd sd sd s");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
