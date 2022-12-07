package GUI;

import allframes.*; // lazem a3mel import 34an yetrbto bba3d aw msh lazm msh damna nehahahaha :)
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class scm extends Application{

   
    @Override
    public void start(final Stage stage) throws Exception {


    
        stage.setTitle("scm controls");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Choose your operation");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        final ComboBox Options = new ComboBox();
         
        Options.getItems().addAll( // 
            "view items",
            "view expired items",
            "view invoices",
            "Minimum Quantity"
            
           
        );
         Options.getSelectionModel().selectFirst();
        grid.add(Options, 0, 1);

       

        Button btn = new Button("Ok");
        grid.add(btn, 1, 2);

        Button SignOut = new Button("Sign Out");
        grid.add(SignOut, 2, 2);
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
    //keda ana 7atet kol el nodes
            Scene scene = new Scene(grid, 500, 400);//3amlt scene 34an a7ut feha el lay out 
        stage.setScene(scene);
        stage.show();   
        //hahndel el event ll buton ok
           btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                
               String SelectedOption = (String) Options.getValue();
               if (SelectedOption.equals("view items")){
                   
                    viewitems view = new viewitems();  //elframe eli ana 3amltu
                    Stage s = new Stage();
                   try {
                       view.start(s);
                   } catch (Exception ex) {
                       Logger.getLogger(scm.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
             else if (SelectedOption.equals("view expired items")){
                    
                    viewexpireditem expired = new viewexpireditem(); //tany frame 3amltu ana
                    Stage s1 = new Stage();
                   try {
                       expired.start(s1);
                   } catch (Exception ex) {
                       Logger.getLogger(scm.class.getName()).log(Level.SEVERE, null, ex);
                   }
             
               } 
                  else if (SelectedOption.equals("Minimum Quantity")){
                    
                    MinimumQuantity m = new MinimumQuantity (); //tany frame 3amltu ana
                    Stage s1 = new Stage();
                   try {
                       m.start(s1);
                   } catch (Exception ex) {
                       Logger.getLogger(scm.class.getName()).log(Level.SEVERE, null, ex);
                   }
             
               }
               
              else if (SelectedOption.equals("view invoices")){
                    
                    viewinvoices addca = new viewinvoices();
                    Stage s = new Stage();
                   try {
                       addca.start(s);
                   } catch (Exception ex) {
                       Logger.getLogger(scm.class.getName()).log(Level.SEVERE, null, ex);
                   }
       
               }
           
            }
        });
            SignOut.setOnAction(new EventHandler<ActionEvent>() { // 

            @Override
            public void handle(ActionEvent t) {
               stage.close();
            }
        });

    
}
}    
    

