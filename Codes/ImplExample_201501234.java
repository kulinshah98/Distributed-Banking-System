import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

// Implementing the remote interface
public class ImplExample_201501234 implements Methods_201501234 {
  public HashMap<Integer, String> acc_name = new HashMap<Integer, String>();
	public HashMap<Integer, String> acc_type = new HashMap<Integer, String>();
	public HashMap<Integer, Integer> cont_info = new HashMap<Integer, Integer>();
	public HashMap<Integer, Integer> balance = new HashMap<Integer, Integer>();
	public HashMap<Integer, ArrayList<String>> trans_id = new HashMap<Integer, ArrayList<String>>();
	public HashMap<Integer, ArrayList<String>> trans_amount = new HashMap<Integer, ArrayList<String>>();
	public HashMap<Integer, ArrayList<String>> trans_date = new HashMap<Integer, ArrayList<String>>();
	public HashMap<Integer, ArrayList<String>> trans_time = new HashMap<Integer, ArrayList<String>>();
  public int count_trans_id;

  public void printMsg( int acc_num ){
    System.out.println(acc_num);
  }

  public void updateHistory( int acc_num, int amount ){

    DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
    Date date = new Date();

    ArrayList<String> tid = trans_id.get(acc_num);
    count_trans_id = count_trans_id + 1;
    tid.add( Integer.toString(count_trans_id + 1) );
    trans_id.put( acc_num, tid );

    ArrayList<String> tam = trans_amount.get(acc_num);
    tam.add( Integer.toString(amount) );
    trans_amount.put( acc_num, tam);

    ArrayList<String> tdate = trans_date.get(acc_num);
    tdate.add( dateFormat1.format(date) );
    trans_date.put( acc_num, tdate);

    ArrayList<String> ttime = trans_time.get(acc_num);
    ttime.add( dateFormat2.format(date) );
    trans_time.put( acc_num, ttime);
  }

  public void add_client_data() {
	  System.out.println("Adding Client data");
    count_trans_id = 0;
	  int [] acc_num = {1, 2};
	  String [] clients = {"abcd1", "abcd2"};
	  String [] type = {"Basic", "Premium"};
	  int [] info = {9999, 10000};
	  int [] st_balance = {0, 0};

	  int i;
	  for(i=0; i<clients.length; i++)
	  {
		  acc_name.put( acc_num[i], clients[i] );
		  acc_type.put(acc_num[i], type[i]);
		  cont_info.put( acc_num[i], info[i]);
		  balance.put( acc_num[i], st_balance[i] );

		  ArrayList<String> tid = new ArrayList<String>();
		  trans_id.put( acc_num[i], tid);

		  ArrayList<String> tam = new ArrayList<String>();
		  trans_amount.put( acc_num[i], tam);

		  ArrayList<String> tdate = new ArrayList<String>();
		  trans_date.put( acc_num[i], tdate);

		  ArrayList<String> ttime = new ArrayList<String>();
		  trans_time.put( acc_num[i], ttime);
	  }

  }

  public void deposit(int acc_num, int amount){
    System.out.println(acc_num + "\n" + amount);
    balance.put(acc_num, balance.get(acc_num) + amount);
    updateHistory(acc_num, amount);
	  System.out.println( balance.get(acc_num) );
  }

  public void withdraw(int acc_num, int amount){
    System.out.println(acc_num + "\n" + amount);
    balance.put(acc_num, balance.get(acc_num) - amount);
    updateHistory(acc_num, -amount);
	  System.out.println( balance.get(acc_num) );
  }

  public ArrayList<ArrayList<String>> get_details( int acc_num ){

    ArrayList<ArrayList<String>> total_hist = new ArrayList<ArrayList<String>>();
    total_hist.add( trans_id.get(acc_num) );
    ArrayList<String> tami = trans_amount.get(acc_num);
    total_hist.add( tami );
    total_hist.add( trans_date.get(acc_num) );
    total_hist.add( trans_time.get(acc_num) );

    return total_hist;
  }

  public int knowBalance(int acc_num){
    return balance.get(acc_num);
  }

}
