import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class App {

    public static void main(String[] args) {
        try {
            int host = 1234;
            Registry registry = LocateRegistry.getRegistry("192.168.1.31", host);
            UPIControll stub = (UPIControll) registry.lookup("upi_server");
            for (int i = 0; i <= 100; i++) {
                stub.setValueOnPin_0(i);
                Thread.sleep(25);
            }
            // fade LED to fully OFF
            for (int i = 100; i >= 0; i--) {
                stub.setValueOnPin_0(i);
                Thread.sleep(25);
            }

            stub.setValueOnPin_0(100);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
