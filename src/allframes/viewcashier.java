package allframes;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.geometry.Insets;
import pos.Cashier;

public class viewcashier extends Application {

    Stage windwo;
    TableView<Cashier> table;


    @Override
    public void start(Stage primaryStage) throws Exception {

        windwo = primaryStage;
        windwo.setTitle("cashiers data");
        TableColumn<Cashier, String> idcolumn = new TableColumn<>("ID"); //esm el coloumn nafso 
        idcolumn.setMinWidth(200);
        idcolumn.setCellValueFactory(new PropertyValueFactory<>("index")); // eli fel constructor bta3 el customers w 5udu copy paste 34an law katpto keda haydek erroe

        TableColumn<Cashier, String> usernamecolumn = new TableColumn<>("userName");
        usernamecolumn.setMinWidth(200);
        usernamecolumn.setCellValueFactory(new PropertyValueFactory<>("username")); // nfs el coment eli fo2

        TableColumn<Cashier, String> passwordcolumn = new TableColumn<>("password");
        passwordcolumn.setMinWidth(200);
        passwordcolumn.setCellValueFactory(new PropertyValueFactory<>("password")); //copy paste llattributes eli fe class al cashier

        TableColumn<Cashier, String> namecolumn = new TableColumn<>("name");
        namecolumn.setMinWidth(200);
        namecolumn.setCellValueFactory(new PropertyValueFactory<>("name")); //

        TableColumn<Cashier, String> emailcolumn = new TableColumn<>("email");
        emailcolumn.setMinWidth(200);
        emailcolumn.setCellValueFactory(new PropertyValueFactory<>("email")); //

        TableColumn<Cashier, String> agecolumn = new TableColumn<>("age");
        agecolumn.setMinWidth(200);
        agecolumn.setCellValueFactory(new PropertyValueFactory<>("age"));//

        TableColumn<Cashier, String> phonenumbercolumn = new TableColumn<>("phone number");
        phonenumbercolumn.setMinWidth(200);
        phonenumbercolumn.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));

        TableColumn<Cashier, String> salarycolumn = new TableColumn<>("salary");
        salarycolumn.setMinWidth(200);
        salarycolumn.setCellValueFactory(new PropertyValueFactory<>("salary"));

        table = new TableView<>();
        table.setItems(getItem());
        table.getColumns().addAll(idcolumn, usernamecolumn, passwordcolumn, namecolumn, emailcolumn, agecolumn, phonenumbercolumn, salarycolumn);

        final VBox vbx = new VBox();
        vbx.setSpacing(5);
        vbx.setPadding(new Insets(10, 0, 0, 10));
        vbx.getChildren().addAll(table);

        Scene scene = new Scene(vbx);
        windwo.setScene(scene);
        windwo.show();

    }

    public ObservableList<Cashier> getItem() {
        ObservableList<Cashier> items = FXCollections.observableArrayList();

        String id = ""; //eli fe clus el customer 
        String us = "";
        String pas = "";
        String name = "";
        String email = "";
        String age = "";
        String phonenumber = "";
        String salary = "";

        try {
            Scanner x = new Scanner(new File("files/Cashiers.txt")); //file el cashier
            x.useDelimiter("[-\n]");
            while (x.hasNext()) {
                id = x.next();
                name = x.next();
                email = x.next();
                age = x.next();
                salary = x.next();
                phonenumber = x.next();
                us = x.next();
                pas = x.next();

                items.add(new Cashier(id, us, pas, name, email, age, phonenumber, salary));
            }
            x.close();
        } catch (FileNotFoundException E) {
            System.out.println("error");
        }

        return items;
    }

}
