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
import java.util.Scanner;
import javafx.geometry.Insets;
import pos.Customer;

public class viewcustumers extends Application {

    Stage windwo;
    TableView<Customer> table;


    @Override
    public void start(Stage primaryStage) throws Exception {

        windwo = primaryStage;
        windwo.setTitle("customers data");
        TableColumn<Customer, String> idcolumn = new TableColumn<>("ID"); //esm el coloumn nafso 
        idcolumn.setMinWidth(200);
        idcolumn.setCellValueFactory(new PropertyValueFactory<>("id")); // eli fel constructor bta3 el customers w 5udu copy paste 34an law katpto keda haydek erroe

        TableColumn<Customer, String> namecolumn = new TableColumn<>("Name");
        namecolumn.setMinWidth(200);
        namecolumn.setCellValueFactory(new PropertyValueFactory<>("name")); // nfs el coment eli fo2

        TableColumn<Customer, String> emailcolumn = new TableColumn<>("EMAIL");
        emailcolumn.setMinWidth(200);
        emailcolumn.setCellValueFactory(new PropertyValueFactory<>("email")); //copy paste llattributes eli fe class al cashier

        TableColumn<Customer, String> phonecolumn = new TableColumn<>("Phone Number");
        phonecolumn.setMinWidth(200);
        phonecolumn.setCellValueFactory(new PropertyValueFactory<>("phone")); //

        TableColumn<Customer, String> addresscolumn = new TableColumn<>("address");
        addresscolumn.setMinWidth(200);
        addresscolumn.setCellValueFactory(new PropertyValueFactory<>("address")); //

        TableColumn<Customer, String> paymentcolumn = new TableColumn<>("payment");
        paymentcolumn.setMinWidth(200);
        paymentcolumn.setCellValueFactory(new PropertyValueFactory<>("payment"));//

        table = new TableView<>();
        table.setItems(getItem());
        table.getColumns().addAll(idcolumn, namecolumn, emailcolumn, phonecolumn, addresscolumn, paymentcolumn);

        final VBox vbx = new VBox();
        vbx.setSpacing(5);
        vbx.setPadding(new Insets(10, 0, 0, 10));
        vbx.getChildren().addAll(table);

        Scene scene = new Scene(vbx);
        windwo.setScene(scene);
        windwo.show();

    }

    public ObservableList<Customer> getItem() {
        ObservableList<Customer> items = FXCollections.observableArrayList();

        String id = ""; //eli fe clus el customer 
        String name = "";
        String email = "";
        String phone = "";
        String adress = "";
        String payment = "";

        try {
            Scanner x = new Scanner(new File("files/Customers.txt")); //file el customer
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                id = x.next();
                name = x.next();
                email = x.next();
                payment = x.next();
                phone = x.next();
                adress = x.next();
                items.add(new Customer(id, name, email, payment, phone, adress)); 
                
            }
            x.close();
        } catch (Exception E) {
            System.out.println("error");
        }

        return items;
    }

}
