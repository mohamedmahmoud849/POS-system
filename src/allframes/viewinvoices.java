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
import pos.Ttransactions;

public class viewinvoices extends Application {
    Stage windwo;
    TableView<Ttransactions> table;


    @Override
    public void start(Stage primaryStage) throws Exception {
        windwo = primaryStage;
        windwo.setTitle("invoices");
         // attribute
        TableColumn<Ttransactions , String> datecolumn = new TableColumn<>("Date");
        datecolumn.setMaxWidth(200);
        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date")); //

        TableColumn<Ttransactions , String> timecolumn = new TableColumn<>("Time");
        timecolumn.setMaxWidth(200);
        timecolumn.setCellValueFactory(new PropertyValueFactory<>("time"));//

        TableColumn<Ttransactions, String> itemcolumn = new TableColumn<>("Item Code");
        itemcolumn.setMaxWidth(200);
        itemcolumn.setCellValueFactory(new PropertyValueFactory<>("itemCode"));//
        
          TableColumn<Ttransactions , String> pricecolumn = new TableColumn<>("Full Price");
        pricecolumn.setMaxWidth(200);
        pricecolumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));//
        

        table = new TableView<>();
        table.setItems(getItem());
        table.getColumns().addAll(datecolumn ,timecolumn ,itemcolumn,pricecolumn);

        VBox vbx = new VBox();
        vbx.getChildren().addAll(table);

        Scene scene = new Scene(vbx);
        windwo.setScene(scene);
        windwo.show();


    }


    public ObservableList <Ttransactions> getItem() {
        ObservableList <Ttransactions> items = FXCollections.observableArrayList();

            String date = "";
            String time = "";
            String itemCode= "";
            String totalPrice= "";

            try
            {
                Scanner x = new Scanner(new File("files/transactions.txt"));
                x.useDelimiter("[-\n]");
                while (x.hasNext())
                {
                    date = x.next().trim();
                    time = x.next().trim();
                    itemCode= x.next().trim();
                    totalPrice = x.next().trim();
                    items.add(new Ttransactions(date,time,itemCode,totalPrice));
                }
            }
            catch (Exception E)
            {
                System.out.println("error");
            }

        return items;
    }

}