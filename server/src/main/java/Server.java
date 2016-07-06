import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String args[]) throws InterruptedException {

        System.setProperty("java.rmi.server.hostname", "192.168.1.31");
        com.pi4j.wiringpi.Gpio.wiringPiSetupGpio();

        com.pi4j.wiringpi.Gpio.pinMode(12, com.pi4j.wiringpi.Gpio.PWM_OUTPUT);
        com.pi4j.wiringpi.Gpio.pwmSetMode(com.pi4j.wiringpi.Gpio.PWM_MODE_MS);
        com.pi4j.wiringpi.Gpio.pwmSetClock(384);
        com.pi4j.wiringpi.Gpio.pwmSetRange(1000);
        com.pi4j.wiringpi.Gpio.pwmWrite(19, 75);

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
