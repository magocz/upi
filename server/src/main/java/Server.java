import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.impl.PinImpl;

import java.util.EnumSet;


public class Server {
    public static void main(String args[]) throws InterruptedException {

        System.setProperty("java.rmi.server.hostname", "192.168.1.31");
        final GpioController gpio = GpioFactory.getInstance();
        GpioPinPwmOutput pwmOutput = gpio.provisionPwmOutputPin(RaspiPin.GPIO_26);
        pwmOutput.setPwm(25);
        while (true) {


        }
      /*  try {
            int host = 7007;
            UPIControll obj = new UPIControllImpl();
            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(host);
            registry.bind("upi_server", obj);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }*/
    }
}
