import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UPIControll extends Remote {

    void testMethod(String msg) throws RemoteException;
}
