package allframes;
import GUI.manager;
import pos.*; // msh 3arfa leha lazma wla la2 bs han3rf ya3ni aked :""")))
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
import javax.swing.JOptionPane;

public class Addcasheir extends Application{
     @Override
    public void start(final Stage stage) {
        stage.setTitle("Add casheir Panel");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Label Id = new Label("cahier ID:");
        grid.add(Id, 0, 1);

        final TextField t1 = new TextField();
        grid.add(t1, 1, 1);

        Label Fname = new Label("cashier Name:");
        grid.add(Fname, 0, 2);

        final TextField t2 = new TextField();
        grid.add(t2, 1, 2);
        
        Label Lname = new Label("Email:");
        grid.add(Lname, 0, 3);

        final TextField t3 = new TextField();
        grid.add(t3, 1, 3);
        
        Label pn = new Label("Age:");
        grid.add(pn, 0, 4);

        final TextField t4 = new TextField();
        grid.add(t4, 1, 4);
        
        Label mail = new Label("Salary:");
        grid.add(mail, 0, 5);

        final TextField t5 = new TextField();
        grid.add(t5, 1, 5);
        
        Label address = new Label("Phone Number:");
        grid.add(address, 0, 6);

        final TextField t6 = new TextField();
        grid.add(t6, 1, 6);
        
        Label age = new Label("Username:");
        grid.add(age, 0, 7);

        final TextField t7 = new TextField();
        grid.add(t7, 1, 7);
        
        Label payment = new Label("Password :");
        grid.add(payment, 0, 8);

        final TextField t8 = new TextField();
        grid.add(t8, 1, 8);
        
        Button btn = new Button("Add");
        
        grid.add(btn, 1, 9);

        Button back = new Button("Back");
       
        grid.add(back, 0, 9);
        
        Scene scene = new Scene(grid, 400, 500);
        stage.setScene(scene);
        stage.show();   
        
        
        btn.setOnAction(new EventHandler<ActionEvent>() { // action 3ala add button
          @Override
            public void handle(ActionEvent e) {
               Cashier S = new Cashier(); 
               if (t1.getText().equals("")||t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||t5.getText().equals("")||t6.getText().equals("")||t7.getText().equals("")||t8.getText().equals(""))
               {
                   JOptionPane.showMessageDialog(null,"Please Fill All Requirments !");
                  
               } 
               else 
               { 
                       S.addCashier( 
                       t1.getText(),
                       t2.getText(),
                       t3.getText(),
                       t4.getText(),
                       t5.getText(),
                        t6.getText(),
                        t7.getText(),
                        t8.getText()); 
                JOptionPane.showMessageDialog(null,"Added Successfully!"); 
                     stage.close();
                     manager admin = new manager();
               Stage s = new Stage();
               admin.start(s);
               }   
            }
        });
          back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               stage.close();
               manager admin = new manager();
               Stage s = new Stage();
               admin.start(s);
            }
        });
        
        
    }
    
}



