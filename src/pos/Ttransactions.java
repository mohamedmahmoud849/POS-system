package pos;

import java.io.*;
import java.util.*;
import java.text.*;

public class Ttransactions {
    
    private String date;
    private String time;
    private String itemCode;
    private String totalPrice;

    private static Scanner x;
   public Ttransactions()
   {
       
   }

    public Ttransactions(String date, String time, String itemCode, String totalPrice) {
        this.date=date;
        this.time=time;
        this.totalPrice=totalPrice;
        this.itemCode=itemCode;
    }
    
    public String getDate() {
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyy/MM/dd");
        return sd.format(date);
    }

    public String getTime() {
        Date time = new Date();
        SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss a");
        return st.format(time);
    }

    public void addTrans(String itemCode, double totalPrice) { 
        try {
             x = new Scanner(new File("files/transactions.txt"));
             Writer z = new BufferedWriter(new FileWriter("files/transactions.txt", true));
            z.append( getDate() + "-" + getTime().trim()+  "-" + itemCode + "-" + totalPrice + "\n");
            z.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No file found !");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    } 
   

}
