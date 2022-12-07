package pos;

import javax.swing.JOptionPane;

public class Cash extends Payment {

    Ttransactions r = new Ttransactions();
    private double amount;
    static double sum;
    Item t1 = new Item();

    public Cash() {

    }

    public Cash(double amount) {
        this.amount = amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public double SELLS(String itemCode, int Amount) {

        double total_price = 0.0;
        t1.SellItem(itemCode, Amount);
        int x = t1.ReturnPrice(itemCode);
        sum = Amount * x;
        total_price += sum;
        r.addTrans(itemCode, total_price);
       // JOptionPane.showMessageDialog(null, "Item Code : " + itemCode + "\n" + "  Quantity : " + Amount + "\n" + "Total Price : " + total_price);
        return total_price;
    } 
    public double RETURN(String itemCode, int Amount)
    {
        double total_price = 0.0;
        t1.UnSellItem(itemCode, Amount);
        int x = t1.ReturnPrice(itemCode);
        sum = Amount * x;
        total_price += sum;
        r.addTrans(itemCode, total_price);
        JOptionPane.showMessageDialog(null, "Returned Money : " + total_price);
        return total_price;
    }

}
