import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UPIControll extends Remote {

    void setValueOnPin_0(Integer value) throws RemoteException;
}
