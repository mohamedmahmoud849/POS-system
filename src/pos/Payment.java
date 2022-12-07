package pos;

public class Payment {

    Ttransactions r = new Ttransactions();
    private double amount;
    private String pay;
    private int NumbOfItems;

    public int getNumbOfItems() {
        return NumbOfItems;
    }

    public void setNumbOfItems(int NumbOfItems) {
        this.NumbOfItems = NumbOfItems;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public Payment(String payment, String itemCode, int Amount) {

        if (payment.equals("cash")) {
            Cash z = new Cash();
            double l = z.SELLS(itemCode, Amount);
        }

        if (payment.equals("credit")) {
            Credit a = new Credit();
            double l = a.SELLD(itemCode, Amount);
        }

    }

    public Payment() {

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
