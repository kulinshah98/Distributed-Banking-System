import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

// Creating Remote interface for our application
public interface Methods_201501234 extends Remote {
   public void printMsg(int acc_num) throws RemoteException;
   public void deposit(int acc_num, int amount) throws RemoteException;
   public void withdraw(int acc_num, int amount) throws RemoteException;
   public int knowBalance(int acc_num) throws RemoteException;
   public void add_client_data() throws RemoteException;
   public void updateHistory( int acc_num, int amount ) throws RemoteException;
   public ArrayList<ArrayList<String>> get_details( int acc_num ) throws RemoteException;
}
