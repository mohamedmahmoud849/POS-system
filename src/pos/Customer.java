package pos;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Customer extends Payment {
    private String id;
    private String name;
    private String Email;
    private String payment;
    private String phone;
    private String address;
    private String editTerm;
    private String removeTerm;
    private static final String CustFile = "files/Customers.txt";
    private static Scanner x;
    public Customer(String id, String name, String email, String Phone,String Address, String Payment)
    {
        this.Email=email;
        this.address=Address;
        this.id=id;
        this.payment=Payment;
        this.phone=Phone;
        this.name=name;
    } 
    public Customer()
    {
        
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEditTerm() {
        return editTerm;
    }

    public void setEditTerm(String editTerm) {
        this.editTerm = editTerm;
    }

    public String getRemoveTerm() {
        return removeTerm;
    }

    public void setRemoveTerm(String removeTerm) {
        this.removeTerm = removeTerm;
    }

    public static void searchCustomer(String searchTerm) {
        boolean found = false;
        String id = "";
        String name = "";
        String Email = "";
        String payment = "";
        String phone = "";
        String address = "";
        try {
             x = new Scanner(new File(CustFile));
            x.useDelimiter("[,\n]");
            while (x.hasNext() && !found) {
                id = x.next();
                name = x.next();
                Email = x.next();
                payment = x.next();
                phone = x.next();
                address = x.next();
                if (id.equals(searchTerm))
                    found = true;
            }
            if (found) {
                JOptionPane.showMessageDialog(null, "ID: " + id + ", Name: " + name + ", E_Mail: " + Email + ", Payment: " + payment + ", Phone: " + phone + ", Address: " + address);
            } else {
                JOptionPane.showMessageDialog(null, " Not Found");
            }
        } catch (Exception e) {
            System.out.println("Error");
        } 
        x.close();
    }

    public static void addCustomer(String id, String name, String Email, String payment, String phone, String address) {
        try {
            x = new Scanner(new File(CustFile));
            Writer z = new BufferedWriter(new FileWriter(CustFile, true));
            z.append(id + "," + name + "," + Email + "," + payment + "," + phone + "," + address+"\n");
            z.close();
            x.close();
            JOptionPane.showMessageDialog(null, "savedRecord");
        } catch (Exception E) {
            System.out.println("Error");
        } 
        
    }

    public static void updateCustomer(String editTerm, String newId, String newName, String newEmail, String newPayment, String newPhone, String newAddress) {
        String tempFile = "files/temp.txt";
        File oldfile = new File(CustFile);
        File newfile = new File(tempFile);
        String id;
        String name;
        String Email;
        String payment;
        String phone;
        String address;
        try {
            FileWriter fw = new FileWriter(newfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
             x = new Scanner(new File(CustFile));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                id = x.next();
                name = x.next();
                Email = x.next();
                payment = x.next();
                phone = x.next();
                address = x.next();
                if (id.equals(editTerm)) {
                    pw.println(newId + "," + newName + "," + newEmail + "," + newPayment + "," + newPhone + "," + newAddress);
                } else {
                    pw.println(id + "," + name + "," + Email + "," + payment + "," + phone + "," + address);
                }
            }
            x.close();
            bw.flush();
            bw.close();
            pw.close();
            fw.close();
            oldfile.delete();
            File dump = new File(CustFile);
            newfile.renameTo(dump);
         
            JOptionPane.showMessageDialog(null, "Update Record");
        }
        catch (Exception e) {
            System.out.println("Error");
        }
    }
    public static void deleteCustomer(String removeTerm)
    {
        String tempFile = "files/temp.txt";
        File oldfile = new File(CustFile);
        File newfile = new File(tempFile);
        String id;
        String name;
        String Email;
        String payment;
        String phone;
        String address;
        try
        {
            FileWriter fw = new FileWriter(newfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
             x = new Scanner(new File(CustFile));
            x.useDelimiter("[,\n]");
            while (x.hasNext() ) {
                id = x.next();
                name = x.next();
                Email = x.next();
                payment = x.next();
                phone = x.next();
                address = x.next();
                if (!id.equals(removeTerm))
                    pw.println(id + "," + name + "," + Email + "," + payment + "," + phone + "," + address);
            }
            x.close();
            bw.flush();
            bw.close();
            pw.close();
            fw.close();
            oldfile.delete();
            File dump = new File(CustFile);
            newfile.renameTo(dump);
            JOptionPane.showMessageDialog(null, "Delete Record");
            }
            catch (Exception e)
                {
                    System.out.println("Error");
                }
        }

    static void typeOfPay(String searchTerm ) {
        boolean found =false;
        String id = "";
        String name = "";
        String e_mail = "";
        String payment = "";
        String phone_number = "";
        String address = "";
        try {
            Scanner x = new Scanner(new File(CustFile));
            x.useDelimiter("[,\n]");
            while (x.hasNext() && !found) {
                id = x.next();
                name = x.next();
                e_mail = x.next();
                payment = x.next();
                phone_number = x.next();
                address = x.next();
                if(id.equals(searchTerm))
                    found = true;
            }
           if (found)
           {
               JOptionPane.showMessageDialog(null, payment);
               if (payment.equals("cash")) {
                   Cash c = new Cash();

               }
               else if (payment.equals("credit"))
               {
                   Credit c = new Credit();
               }
           }
           else
               JOptionPane.showMessageDialog(null,"ID NOT FOUND");

        }
        catch (Exception E) {
            System.out.println("Error");
        }
        x.close();
        
    }
}

