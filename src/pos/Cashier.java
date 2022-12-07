package pos;

import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cashier extends Staff implements log {

    private String Name;
    private String Email;
    private String Salary;
    private String Age;
    private String index;
    private String PhoneNumber;
    private String Username;
    private String Password;
    private static Scanner x;
    private static final String CashFile = "files/Cashiers.txt";
    private boolean foundM = false;

    public Cashier() {

    }

    public Cashier(String id, String us, String pas, String name, String email, String age, String phonenumber, String salary) {
        this.Age=age;
        this.index=id;
        this.Username=us;
        this.Password=pas;
        this.Name=name;
        this.Email=email;
        this.PhoneNumber=phonenumber;
        this.Salary=salary;
    } 

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String Salary) {
        this.Salary = Salary;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean addCashier(String index, String Name, String Email, String Age, String Salary, String PhoneNumber, String Us, String Pas) {

        setName(Name);
        setIndex(index);
        setUsername(Us);
        setPassword(Pas);
        setEmail(Email);
        setPhoneNumber(PhoneNumber);
        setSalary(Salary);
        setAge(Age);
        try {
            x = new Scanner(new File(CashFile));
            String nw = "\n" + getIndex() + "-" + getName() + "-" + getEmail() + "-" + getAge() + "-" + getSalary() + "-" + getPhoneNumber() + "-" + getUsername() + "-" + getPassword();
            Writer z = new BufferedWriter(new FileWriter(CashFile, true));
            z.append(nw);
            z.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean deleteCashier(String index) {
        String tmpFile = "files/tmp.txt";

        File oldFile = new File(CashFile);
        File newFile = new File(tmpFile);
        try {
            x = new Scanner(new File(CashFile));
            Writer z = new BufferedWriter(new FileWriter(tmpFile, true));
            x.useDelimiter("[-\n]");
            while (x.hasNext()) {
                setIndex(x.next());
                setName(x.next());
                setEmail(x.next());
                setAge(x.next());
                setSalary(x.next());
                setPhoneNumber(x.next());
                setUsername(x.next());
                setPassword(x.next());
                if (!index.equals(getIndex())) {
                    z.append("\n" + getIndex() + "-" + getName() + "-" + getEmail() + "-" + getAge() + "-" + getSalary() + "-" + getPhoneNumber() + "-" + getUsername() + "-" + getPassword());
                }
            }
            x.close();
            z.close();
            oldFile.delete();
            File dump = new File(CashFile);
            newFile.renameTo(dump);
            JOptionPane.showMessageDialog(null, "Delete Record");
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean UpdateCashier(String index, String Us, String Pas, String Name, String Email, String Age, String PhoneNumber, String Salary) {
        String tmpFile = "files/tmp.txt";

        File oldFile = new File(CashFile);
        File newFile = new File(tmpFile);

        try {
            x = new Scanner(new File(CashFile));
            Writer z = new BufferedWriter(new FileWriter(tmpFile, true));
            x.useDelimiter("[-\n]");
            while (x.hasNext()) {
                setIndex(x.next());
                setName(x.next());
                setEmail(x.next());
                setAge(x.next());
                setSalary(x.next());
                setPhoneNumber(x.next());
                setUsername(x.next());
                setPassword(x.next());
                if (!index.equals(getIndex())) {
                    z.append("\n" + getIndex() + "-" + getName() + "-" + getEmail() + "-" + getAge() + "-" + getSalary() + "-" + getPhoneNumber() + "-" + getUsername() + "-" + getPassword());
                } else {
                    z.append("\n" + index + "-" + Name + "-" + Email + "-" + Age + "-" + Salary + "-" + PhoneNumber + "-" + Us + "-" + Pas);
                }
            }
            x.close();
            z.close();
            oldFile.delete();
            File dump = new File(CashFile);
            newFile.renameTo(dump);
            return true;

        } catch (IOException ex) {
            Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void searchCashier(String searchTerm) {
        boolean found = false;
        String Name = "";
        String Email = "";
        String Salary = "";
        String Age = "";
        String index = "";
        String PhoneNumber = "";
        String Username = "";
        String Password = "";
        try {
            x = new Scanner(new File(CashFile));
            x.useDelimiter("[-\n]");
            while (x.hasNext() && !found) {
                index = x.next();
                Name = x.next();
                Email = x.next();
                Age = x.next();
                Salary = x.next();
                PhoneNumber = x.next();
                Username = x.next();
                Password = x.next();
                if (index.equals(searchTerm)) {
                    found = true;
                }
            }
            if (found) {
                JOptionPane.showMessageDialog(null, "ID: " + index + "  Name : " + Name + "  Email : " + Email + "  Age : " + Age + "  Salary : " + Salary + "  Phone : " + PhoneNumber + "  Username : "  + Username + "  Password : " + Password);
            } else {
                JOptionPane.showMessageDialog(null, "Cashier Not Found");
            }
        } catch (HeadlessException | FileNotFoundException E) {
            System.out.println("Error");
        } 
        x.close();
       
    }

    @Override
    public boolean login(String Username, String Password) {
        String tempUs;
        String tempPas;
        try {
            x = new Scanner(new File(CashFile));
            x.useDelimiter("[-\n]");
            while (!foundM && x.hasNext()) {
                tempUs = x.next();
                if (tempUs.equals(Username)) {
                    tempPas = x.next();
                    if (tempPas.equals(Password)) {
                        foundM = true;
                        return foundM;
                    } else {
                        return false;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            return false;
        }
        return false;
    }

}
