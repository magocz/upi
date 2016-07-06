import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UPIControllImpl extends UnicastRemoteObject implements UPIControll {

    public UPIControllImpl() throws RemoteException {
        Gpio.wiringPiSetup();
        SoftPwm.softPwmCreate(0, 0, 40);
    }

    public void setValueOnPin_0(Integer value) {
        System.out.println("Value: " + value);
        SoftPwm.softPwmWrite(0, value);
    }
}
