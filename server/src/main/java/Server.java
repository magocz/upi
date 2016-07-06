import com.pi4j.wiringpi.SoftPwm;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String args[]) {
        System.setProperty("java.rmi.server.hostname", "192.168.1.31");
        try {
            int host = 7007;
            UPIControll obj = new UPIControllImpl();
            SoftPwm.softPwmCreate(0, 0, 100);
            SoftPwm.softPwmWrite(0, 100);
            Thread.sleep(2000);
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
