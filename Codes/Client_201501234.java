import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.*;
import java.util.*;

public class Client_201501234 {
   private Client_201501234() {}
   public static void main(String[] args) {
      try {
        // Getting the registry
      Registry registry = LocateRegistry.getRegistry(null);

      // Looking up the registry for the remote object
      Methods_201501234 stub = (Methods_201501234) registry.lookup("Methods_201501234");

      // Calling the remote method using the obtained object
      while(true)
         {
           java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
           String text_input;
           text_input = in.readLine();
           String[] words = text_input.split(" ");
           if(words[0].equals("exit"))
           {
             break;
           }
           else if(words[0].equals("deposit"))
           {
             stub.deposit( Integer.parseInt(words[1]), Integer.parseInt(words[2]) );
           }
           else if(words[0].equals("withdraw"))
           {
             stub.withdraw( Integer.parseInt(words[1]), Integer.parseInt(words[2]) );
           }
           else if(words[0].equals("balance"))
           {
             System.out.println( "Your balance is... " + stub.knowBalance( Integer.parseInt(words[1]) ) );
           }
           else if( words[0].equals("transaction_details") )
           {
             ArrayList<ArrayList<String>> total_hist = stub.get_details( Integer.parseInt(words[1]) );
             int n = total_hist.size();

             ArrayList<String> trans_id = total_hist.get(0);
             ArrayList<String> trans_amount = total_hist.get(1);
             ArrayList<String> trans_date = total_hist.get(2);
             ArrayList<String> trans_time = total_hist.get(3);
             n = trans_id.size();
             System.out.format("%10s%15s%15s%28s\n","Transaction","Amount","Transaction Date","Transaction Time");
             for(int i=0;i<n;i++)
             {
               System.out.format("%10s%15s%15s%30s\n",trans_id.get(i),trans_amount.get(i),trans_date.get(i), trans_time.get(i));
             }
             System.out.println();
           }
           else if(words[0].equals("print"))
           {
             stub.printMsg(Integer.parseInt(words[1]));
           }
         }

      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString());
         e.printStackTrace();
      }
   }
}
