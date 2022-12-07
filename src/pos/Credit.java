package pos;

import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static pos.Cash.sum;

public class Credit extends Payment { 
    Ttransactions r=new Ttransactions();
    private String name;
    private Date ExpireDate;
    private int CreditNumber;
    Item t1=new Item();
    public Credit() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(Date expireDate) {
        ExpireDate = expireDate;
    }

    public int getCreditNumber() {
        return CreditNumber;
    }

    public void setCreditNumber(int creditNumber) {
        CreditNumber = creditNumber;
    } 
    double SELLD(String itemCode, int Amount) {

      double total_price = 0.0;
        t1.SellItem(itemCode, Amount);
        int x = t1.ReturnPrice(itemCode);
        sum = Amount * x;
        total_price += sum;
        r.addTrans(itemCode, total_price);
        JOptionPane.showMessageDialog(null, "Item Code : " + itemCode + "\n" + "  Quantity : " + Amount + "\n" + "You`ve paid from credit : " + total_price);
        return total_price;
    }
}
