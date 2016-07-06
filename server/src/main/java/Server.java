import com.pi4j.io.gpio.*;


public class Server {
    public static void main(String args[]) throws InterruptedException {

        System.setProperty("java.rmi.server.hostname", "192.168.1.31");
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #01 as an output pin and turn on
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "MyLED", PinState.HIGH);
        while (true) {

            pin.high();
            Thread.sleep(0, 1000);
            pin.low();
            Thread.sleep(19);

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
