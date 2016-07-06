import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;

public class UPIControllImpl implements UPIControll {


    public UPIControllImpl() {
        Gpio.wiringPiSetup();
        SoftPwm.softPwmCreate(0, 0, 100);
    }

    public void setValueOnPin_0(Integer value) {
        SoftPwm.softPwmWrite(0, value);
    }
}
