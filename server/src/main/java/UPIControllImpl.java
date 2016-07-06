import com.pi4j.wiringpi.SoftPwm;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UPIControllImpl extends UnicastRemoteObject implements UPIControll {

    public UPIControllImpl() throws RemoteException {
        SoftPwm.softPwmCreate(0, 0, 100);
    }

    public void setValueOnPin_0(Integer value) {
        System.out.println("Value: " + value);
        SoftPwm.softPwmWrite(0, value);
    }
}
