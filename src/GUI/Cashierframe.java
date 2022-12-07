
package GUI;

import allframes.Addcustomer;
import allframes.returnitems;
import allframes.sellitems;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pos.Customer;
import pos.Item;


public class Cashierframe extends Application {
    Stage window;
    @Override
    public void start(Stage primaryStage) {
      window=new Stage();
      window.setTitle("Cahier Controls");
      GridPane grid=new GridPane();
      grid.setAlignment(Pos.CENTER);
      grid.setHgap(40);
      grid.setVgap(30);
      
      Label l = new Label("search");
      grid.add(l, 1, 0);
      
      
      
      final TextField SItem=new TextField();
      grid.add(SItem,1,1);
     
      
      Button SearchItem=new Button("Search Item ");
      grid.add(SearchItem, 2, 1);
       
      Label l1 = new Label("search");
      grid.add(l1, 1, 3);
      
       final TextField scust=new TextField();
      grid.add(scust,1,4);
      
      Button SearchCustomer=new Button("Search Customer");
      grid.add(SearchCustomer, 2, 4);
     
      
      Label l2 = new Label("add customer :");
      grid.add(l2,1,5);
      
      Button add=new Button("Add");
      grid.add(add, 2, 5);
      
      Label l3 = new Label("sell item :");
      grid.add(l3, 1, 6);
     

     Button SellItem =new Button("Sell Item ");
      grid.add(SellItem , 2, 6);
      
      
      
      
        Label ReB=new Label("Return Item : ");
      grid.add(ReB,1,7);
      
      Button ReturnItem=new Button("Return Item           ");
      grid.add(ReturnItem, 2, 7);
      
      
      
     
      
  
      Scene scene=new Scene(grid,450,400);
      window.setScene(scene);
      window.show();
     SearchItem.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent e) {
                if (!SItem.getText().equals("")) { // msh 3arfa han7ut eh fel qutes
                    
                    Item.searchItem(SItem.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Missing required fields!");
                } 

            }
     }); 
     SearchCustomer.setOnAction(new EventHandler<ActionEvent>() {
     public void handle(ActionEvent e) {
                if (!scust.getText().equals("")) { // msh 3arfa han7ut eh fel qutes
                    
                    Customer.searchCustomer(scust.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Missing required fields!");
                } 

            }
     });
      add.setOnAction(new EventHandler<ActionEvent>() {
     @Override
     public void handle(ActionEvent e) {
         
        
         Addcustomer c = new Addcustomer();
         Stage s = new Stage();
         c.start(s);
     }
    
             });
      
      SellItem.setOnAction(new EventHandler<ActionEvent>() {
     @Override
     public void handle(ActionEvent e) {
         
       
         sellitems se = new sellitems();
         Stage s2 = new Stage();
         try {
             se.start(s2);
         } catch (Exception ex) {
             Logger.getLogger(Cashierframe.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
    
             }); 
      ReturnItem.setOnAction(new EventHandler<ActionEvent>() {
     @Override
     public void handle(ActionEvent e) {
         
        window.close();
         returnitems se = new returnitems();
         Stage s2 = new Stage();
         try {
             se.start(s2);
         } catch (Exception ex) {
             Logger.getLogger(Cashierframe.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
    
             });
              }
}

    

