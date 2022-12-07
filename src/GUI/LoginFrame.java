package GUI;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pos.*;

public class LoginFrame extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Cashier c = new Cashier();
        primaryStage.setTitle("LOG IN "); //el title bta3 el window eli hayzhar foo
        Label l1 = new Label("User name : ");
        Label l2 = new Label("Password :");
        TextField t1 = new TextField(); // el user hayd5al el user name hena
        final PasswordField pf = new PasswordField();   // hayd5al el password hena     
        Button b1 = new Button("Sign in");
        GridPane p = new GridPane(); //3mlt el layout eli ha7ut feha el nodes eli 3andy 
        p.add(l1, 0, 1); // 3amlt add l label 1 , el 0 da makan el coloumn , el 1 makan el row
        p.add(t1, 1, 1); // 7atet el text field eli el user hayktp fe odam el label
        p.add(l2, 0, 2);
        p.add(pf, 1, 2);
        HBox hbBtn = new HBox(10); //3AML LAY OUT TANYA 34an a7ut feha el button lwa7do 
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(b1);
        p.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        p.add(actiontarget, 1, 6);

        p.setHgap(20);
        p.setVgap(20);
        p.setAlignment(Pos.CENTER);
        p.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(p, 550, 420);
        primaryStage.setScene(scene);
        primaryStage.show();

        b1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if ((!t1.getText().equals("") && !pf.getText().equals(""))) {
                    log c = new Manager();
                    if (c.login(t1.getText(), pf.getText())) {
                        try {
                            Stage s = new Stage();
                            primaryStage.close();
                            new manager().start(s);

                        } catch (Exception ex) {
                            Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);

                        }
                    } else {
                        log c2 = new Cashier();
                        if (c2.login(t1.getText(), pf.getText())) {
                            try {
                                Stage s2 = new Stage(); // hena ba2olo ye3ml stage gdeda 34an yefta7li fiha el casheir
                                primaryStage.close();
                                new Cashierframe().start(s2);
                            } catch (Exception ex) {
                                Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);

                            }
                        } else {
                            log c3 = new SCM();
                            if (c3.login(t1.getText(), pf.getText())) {
                                try {
                                    Stage s3 = new Stage(); // hena ba2olo ye3ml stage gdeda 34an yefta7li fiha el manager
                                    primaryStage.close();
                                    new scm().start(s3);
                                } catch (Exception ex) {
                                    Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);

                                }

                            } else {
                                actiontarget.setText("Invaild Username or Password!");
                            }
                        }
                    }
                } else {
                    actiontarget.setFill(Color.RED);
                    actiontarget.setText("Enter Username and Password!");
                }
            }
        }
        );
    }

}
