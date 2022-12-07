
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

/**
 *
 * @author google
 */
public class Addcustomer extends Application {

    @Override
    public void start(final Stage stage) {
        stage.setTitle("Add Customer Panel");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label Id = new Label("Customer ID:");
        grid.add(Id, 0, 1);

        final TextField t1 = new TextField();
        grid.add(t1, 1, 1);

        Label Fname = new Label("Customer Name:");
        grid.add(Fname, 0, 2);

        final TextField t2 = new TextField();
        grid.add(t2, 1, 2);

        Label Lname = new Label("Customer Email:");
        grid.add(Lname, 0, 3);

        final TextField t3 = new TextField();
        grid.add(t3, 1, 3);

        Label pn = new Label("Payment :");
        grid.add(pn, 0, 4);

        final TextField t4 = new TextField();
        grid.add(t4, 1, 4);

        Label mail = new Label("Phone Number:");
        grid.add(mail, 0, 5);

        final TextField t5 = new TextField();
        grid.add(t5, 1, 5);

        Label address = new Label("Address :");
        grid.add(address, 0, 6);

        final TextField t6 = new TextField();
        grid.add(t6, 1, 6);

        Button btn = new Button("Add");

        grid.add(btn, 1, 7);

        Button back = new Button("Back");

        grid.add(back, 0, 7);

        Scene scene = new Scene(grid, 500, 400);
        stage.setScene(scene);
        stage.show();

        btn.setOnAction(new EventHandler<ActionEvent>() { // action 3ala add button
            @Override
            public void handle(ActionEvent e) {
                Customer c = new Customer();
                Customer.addCustomer( t1.getText(),
                        t2.getText(),
                        t3.getText(),
                        t4.getText(),
                        t5.getText(),
                        t6.getText());
                          stage.close();
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                stage.close();
               
            }
        });
    }

}
