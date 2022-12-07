/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allframes;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pos.Customer;// import llcasheir eli enta 3amlo 34an hakhod mno el attributes w msh mot2kda han3ml wla la2 nb2a ngrbha

public class Modifycustomer extends Application {

    @Override
   
       
        
         public void start(final Stage stage) {
        stage.setTitle("Modify customer Panel");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        
        final TextField search = new TextField();
        grid.add(search, 0, 1);
        
        Button searchbttn=new Button("Search");
        grid.add(searchbttn, 1, 1);
        
        
        Label Id = new Label("ID:");
        grid.add(Id, 0, 2);

        final TextField t1 = new TextField();
        grid.add(t1, 1, 2);
        Label Fname = new Label("New ID:");
        grid.add(Fname, 0, 3);

        final TextField t2 = new TextField();
        grid.add(t2, 1, 3);
        
        Label Lname = new Label("New Name:");
        grid.add(Lname, 0, 4);

        final TextField t3 = new TextField();
        grid.add(t3, 1, 4);
        
        Label pn = new Label("New Email:");
        grid.add(pn, 0, 5);

        final TextField t4 = new TextField();
        grid.add(t4, 1, 5);
        
        Label mail = new Label("New Payment:");
        grid.add(mail, 0, 6);

        final TextField t5 = new TextField();
        grid.add(t5, 1, 6);
        
        Label address = new Label("New Phone:");
        grid.add(address, 0, 7);

        final TextField t6 = new TextField();
        grid.add(t6, 1, 7);
        Label phonee = new Label("New Address:");
        grid.add(phonee, 0, 8);
        final TextField t7 = new TextField();
        grid.add(t7, 1, 8);
               
        Button removebttn = new Button("Delete");
        
        grid.add(removebttn, 2, 1);

        Button updatebttn = new Button("update");
       
        grid.add(updatebttn, 1, 10);       
        

        Label l = new Label(); // 3mlt create llable da 34an a3ml makan a7ut fe resala law mad5lsh el bayanat kolha 
        grid.add(l,0,9); 
    
         Scene scene = new Scene(grid, 600, 480);
        stage.setScene(scene);
        stage.show();   
        
        searchbttn.setOnAction(new EventHandler<ActionEvent>() { // button el search
          @Override
            public void handle(ActionEvent e) {    
                   if(!search.getText().equals("")){ // hab3tlo el id eli haysearch beh string id
            Customer c = new Customer();
            Customer.searchCustomer(search.getText()); // de function enta 3amlha aked bt3ml serach 3al casheir
                   }
           
        else{
            l.setText("Missing required fields , Please enter ID you want to search"); 
        }
                
            }
        });
        
        
    removebttn.setOnAction(new EventHandler<ActionEvent>() { // button el remove
          @Override
            public void handle(ActionEvent e) {       
                if(!search.getText().equals("")) //
        {
           Customer c = new Customer();
            if(!search.getText().equals("")) //shuf esm el function eli btms7 el casheir eh fel class bta3ha
            {
                Customer.deleteCustomer(search.getText());
               l.setText("Deleted Successfully");
                
            }
            else
            {
                l.setText("Failed Delete");
            }
        }
        else
        {
            l.setText("Please Enter ID you want to delete");
        }
    }               
            } );
    
    
      updatebttn.setOnAction(new EventHandler<ActionEvent>() { // button el update
          @Override
            public void handle(ActionEvent e) {
                
                 if(!t1.getText().equals("") && 
                         !t2.getText().equals("") && 
                         !t3.getText().equals("") &&
                         !t4.getText().equals("") &&
                         !t5.getText().equals("") && 
                         !t6.getText().equals("") &&
                         !t7.getText().equals("")){
                     
        
            Customer c = new Customer();
            c.updateCustomer(t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText(), t6.getText(), t7.getText()); // el functions eli fel class el casheir el setter w el getter 
           
                l.setText("Updated Successfully .. !");
            
                 }
        else 
        {
            l.setText("Missing required fields");
        }
    }                                                           
                
                
           



    public void start(Stage s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
      });
}
}


