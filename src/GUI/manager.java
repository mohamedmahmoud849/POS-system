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


public class manager extends Application {

    @Override
    public void start(final Stage stage) {
        stage.setTitle("manager controls");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Choose your operation");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        final ComboBox Options = new ComboBox();

        Options.getItems().addAll( // hena hwa daf el processes eli hatt3ml mn el manager
                "Add customer",
                "Modify customer",
                "Add casheir",
                "Modify casheir",
                "View Customers",
                "View Cashiers",
                "View Invoices"
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
        Scene scene = new Scene(grid, 700, 550);//3amlt scene 34an a7ut feha el lay out 
        stage.setScene(scene);
        stage.show();
        //hahndel el event ll buton ok
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                String SelectedOption = (String) Options.getValue();
                if (SelectedOption.equals("Add customer")) {
                    //stage.close();
                    Addcustomer addc = new Addcustomer();  //elframe eli ana 3amltu
                    Stage s = new Stage();
                    addc.start(s);
                } else if (SelectedOption.equals("Modify customer")) {
                    //stage.close();
                    Modifycustomer mod = new Modifycustomer(); //tany frame 3amltu ana
                    Stage s1 = new Stage();
                    mod.start(s1);
                } else if (SelectedOption.equals("Add casheir")) {
                    // stage.close();
                    Stage s = new Stage();
                    new Addcasheir().start(s);
                } else if (SelectedOption.equals("Modify casheir")) {
                    // stage.close();
                    Modifycasheir delca = new Modifycasheir();
                    Stage s3 = new Stage();
                    delca.start(s3); //msh fahma leh mtl3 error 3nd start 
                } else if (SelectedOption.equals("View Customers")) {
                    //stage.close();
                    viewcustumers viewcust = new viewcustumers();
                    Stage s = new Stage();
                    try {
                        viewcust.start(s);
                    } catch (Exception ex) {
                        Logger.getLogger(manager.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (SelectedOption.equals("View Cashiers")) {
                   // stage.close();
                    viewcashier viewcash = new viewcashier();
                    Stage s = new Stage();
                    try {
                        viewcash.start(s);
                    } catch (Exception ex) {
                        Logger.getLogger(manager.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } 
                else if (SelectedOption.equals("View Invoices")) {
                  //  stage.close();
                    viewinvoices w = new viewinvoices();
                    Stage s = new Stage();
                    try {
                        w.start(s);
                    } catch (Exception ex) {
                        Logger.getLogger(manager.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });
        SignOut.setOnAction(new EventHandler<ActionEvent>() { // 3mlt action lel button eli esmo sign out eno ye2fli kol el stages w yu5rug

            @Override
            public void handle(ActionEvent t) {
                Stage s = new Stage();
                try {
                    new LoginFrame().start(s);
                } catch (Exception ex) {
                    Logger.getLogger(manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
}
