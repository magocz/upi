import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class App {

    public static void main(String[] args) {
        try {
            int host = 7007;
            Registry registry = LocateRegistry.getRegistry("83.7.213.20", host);
            UPIControll stub = (UPIControll) registry.lookup("upi_server");
            /*for(int i = 500 ; i < 1000 ; i++){
                stub.setValueOnPin_0(i);
                Thread.sleep(500);
            }*/
            stub.setValueOnPin_0(1000);


        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
