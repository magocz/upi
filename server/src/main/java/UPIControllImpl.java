import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.RaspiPin;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UPIControllImpl extends UnicastRemoteObject implements UPIControll {

    private GpioPinPwmOutput pwmOutput;

    public UPIControllImpl() throws RemoteException {
        final GpioController gpio = GpioFactory.getInstance();
        pwmOutput = gpio.provisionPwmOutputPin(RaspiPin.GPIO_26);

    }

    public void setValueOnPin_0(Integer value) {
        System.out.println("Value: " + value);
        pwmOutput.setPwm(value);
    }
}
