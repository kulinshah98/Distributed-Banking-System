import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server_201501234 extends ImplExample_201501234 {
   public Server_201501234() {}
   public static void main(String args[]) {
      try {
          // Instantiating the implementation class
          ImplExample_201501234 obj = new ImplExample_201501234();

          // Exporting the object of implementation class
          // (here we are exporting the remote object to the stub)
          Methods_201501234 stub = (Methods_201501234) UnicastRemoteObject.exportObject(obj, 0);

          // Binding the remote object (stub) in the registry
          Registry registry = LocateRegistry.getRegistry();

          registry.bind("Methods_201501234", stub);
          stub.add_client_data();
          System.err.println("Server ready");
      } catch (Exception e) {
         System.err.println("Server exception: " + e.toString());
         e.printStackTrace();
      }
   }
}
