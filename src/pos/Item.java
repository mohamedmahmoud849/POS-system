package pos;

import java.awt.HeadlessException;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Item {

    private String code;
    private  String NameOfItem;
    private  String NumOfItem;
    private  String Price;
    private String editItem;
    private String deleteItem;
    private int NumOfsell;
    private static final String ItmFile = "files/itemsData.txt";
        public Item(String code, String NamOfItem , String NumOfItem , String Price) {

        this.code = code;
        this.NameOfItem = NamOfItem;
        this.NumOfItem = NumOfItem;
        this.Price = Price;
    }

    public Item() {
       
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameOfItem() {
        return NameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        NameOfItem = nameOfItem;
    }

    public String getNumOfItem() {
        return NumOfItem;
    }

    public void setNumOfItem(String numOfItem) {
        NumOfItem = numOfItem;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getEditItem() {
        return editItem;
    }

    public void setEditItem(String editItem) {
        this.editItem = editItem;
    }

    public String getDeleteItem() {
        return deleteItem;
    }

    public void setDeleteItem(String deleteItem) {
        this.deleteItem = deleteItem;
    }
   public static void searchItem (String searchTerm)
    {
        boolean found = false;
        String code = "";
        String nameOfItem = "";
        String numOfItem = "";
        String price = "";
        try
        {
            Scanner x = new Scanner(new File(ItmFile));
            x.useDelimiter("[,\n]");
            while (x.hasNext() && !found)
            {
                code = x.next();
                nameOfItem = x.next();
                numOfItem = x.next();
                price = x.next();
                if (code.equals(searchTerm))
                    found=true;
            }
            if (found) {
                JOptionPane.showMessageDialog(null, "Code: " + code + ", Name: " + nameOfItem + ", Quantatiy " + numOfItem + ", price " + price );
            } else {
                JOptionPane.showMessageDialog(null, "Item Not Found");
            }
        }
        catch (HeadlessException | FileNotFoundException E)
        {
            System.out.println("error");
        }
    }

    static void addItem (String code , String nameOfItem , String numOfItem , String price)
    {
        try
        {
            FileWriter fw = new FileWriter(ItmFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append("\n"+code + "," + nameOfItem + "," + numOfItem + "," + price);
            bw.flush();
            bw.close();
            JOptionPane.showMessageDialog(null, "savedRecord");

        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    static void deleteItem (String deleteItem)
    {
        String tempFile = "temp.txt";
        File oldFile = new File(ItmFile);
        File newFile = new File("tempFile");
        String code;
        String nameOfItem;
        String numOfItem;
        String price;
        try
        {
            FileWriter fw = new FileWriter(newFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner x = new Scanner(new File(ItmFile));
            x.useDelimiter("[,\n]");
            while (x.hasNext())
            {
                code = x.next();
                nameOfItem = x.next();
                numOfItem = x.next();
                price = x.next();
                if (!code.equals(deleteItem))
                    bw.append("\n"+code + "," + nameOfItem + "," + numOfItem + "," + price);
            }
            x.close();
            bw.flush();
           bw.close();
            oldFile.delete();
            File dump = new File(ItmFile);
            newFile.renameTo(dump);
            JOptionPane.showMessageDialog(null, "Delete Record");
        }

        catch (Exception E)
        {
            System.out.println("erroe");
        }
    }
    static void updateItem (String editItem, String newCode, String newName , String newNo , String newPrice)
    {
        String tempFile = "temp.txt";
        File oldFile = new File(ItmFile);
        File newFile = new File("tempFile");
        String code;
        String nameOfItem;
        String numOfItem;
        String price;
        try
        {
            FileWriter fw = new FileWriter(newFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner x = new Scanner(new File(ItmFile));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                code = x.next();
                nameOfItem = x.next();
                numOfItem = x.next();
                price = x.next();
                if (code.equals(editItem))
                    bw.append(newCode + "," +newName + "," + newNo + "," + newPrice+"\n");
                else
                    bw.append(code + "," + nameOfItem + "," + numOfItem + "," + price+"\n");
                
            }
            x.close();
            bw.flush();
            bw.close();
            oldFile.delete();
            File dump = new File(ItmFile);
            newFile.renameTo(dump);
            JOptionPane.showMessageDialog(null, "update Record");
        }
        catch (HeadlessException | IOException e)
        {
            System.out.println("error");
        }
    }
    static void updateItemAmount (String editItem, String newAmount)
   
    {
        String tempFile = "temp.txt";
        File oldFile = new File(ItmFile);
        File newFile = new File("tempFile");
        String code;
        String nameOfItem;
        String numOfItem;
        String price;
        try
        {
            FileWriter fw = new FileWriter(newFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner x = new Scanner(new File(ItmFile));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                code = x.next();
                nameOfItem = x.next();
                numOfItem = x.next();
                price = x.next();
                if (code.equals(editItem))
                    bw.append(code + "," +nameOfItem+ "," + newAmount + "," + price+"\n");
                else
                    bw.append(code + "," + nameOfItem + "," + numOfItem + "," + price+"\n");
                
            }
            x.close();
            bw.flush();
            bw.close();
            oldFile.delete();
            File dump = new File(ItmFile);
            newFile.renameTo(dump);
            JOptionPane.showMessageDialog(null, "update Record");
        }
        catch (HeadlessException | IOException e)
        {
            System.out.println("error");
        }
    }
    public String ReturnAmount (String searchTerm)
    {
        boolean found = false;
        String code = "";
        String nameOfItem = "";
        String numOfItem = "";
        String price = "";
        try
        {
            Scanner x = new Scanner(new File(ItmFile));
            x.useDelimiter("[,\n]");
            while (x.hasNext() && !found)
            {
                code = x.next();
                nameOfItem = x.next();
                numOfItem = x.next();
                price = x.next();
                if (code.equals(searchTerm))
                {
                    found=true;
                    x.close();
                    return numOfItem;
                }
            }
        }
        catch (HeadlessException | IOException e)
        {
            System.out.println("error");
        }
        return null;
    }
     public int ReturnPrice (String searchTerm)
    {
        boolean found = false;
        String code = "";
        String nameOfItem = "";
        String numOfItem = "";
        String price = "";
        try
        {
            Scanner x = new Scanner(new File(ItmFile));
            x.useDelimiter("[,\n]");
            while (x.hasNext() && !found)
            {
                code = x.next();
                nameOfItem = x.next();
                numOfItem = x.next();
                price = x.next();
                if (code.equals(searchTerm))
                {
                    found=true;
                    x.close();
                    try {
                    return Integer.parseInt(price.trim());
                    } 
                    catch (NumberFormatException e)
                    {
                        JOptionPane.showMessageDialog(null, "NumberFormatException!");
                    }
                }
            } 
            x.close();
        }
        catch (HeadlessException | IOException e)
        {
            System.out.println("error");
        }
        return 0;
    }
    public void SellItem(String itemCode,int NumOfsell)
    {  
      try{
      String z=ReturnAmount(itemCode); 
      int a=Integer.parseInt(z)-NumOfsell;
      String ab=String.valueOf(a);
      updateItemAmount(itemCode,ab); 
      }
      catch (NumberFormatException e)
      {
          JOptionPane.showMessageDialog(null, "NumberFormatException!");
      }
      
    }
    
    public void UnSellItem(String itemCode,int Return)
    { 
        try {
      String z=ReturnAmount(itemCode);
      int a=Integer.parseInt(z)+Return;
      String ab=String.valueOf(a);
      updateItemAmount(itemCode,ab);
        }
         catch (NumberFormatException e)
      {
          JOptionPane.showMessageDialog(null, "NumberFormatException!");
      }
    }

}
