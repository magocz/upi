import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UPIControllImpl extends UnicastRemoteObject implements UPIControll {

    private GpioPinPwmOutput pwmOutput;

    public UPIControllImpl() throws RemoteException {
        com.pi4j.wiringpi.Gpio.pwmSetMode(com.pi4j.wiringpi.Gpio.PWM_MODE_MS);
        com.pi4j.wiringpi.Gpio.pwmSetClock(384);
        Gpio.wiringPiSetup();
        SoftPwm.softPwmCreate(24, 0, 1000);

    }

    public void setValueOnPin_0(Integer value) {
        System.out.println("Value: " + value);
        SoftPwm.softPwmWrite(24, value);
    }
}
