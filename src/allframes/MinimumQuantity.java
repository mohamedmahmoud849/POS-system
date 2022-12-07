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
import pos.Item;

public class MinimumQuantity extends Application {

    Stage windwo;
    TableView<Item> table;



    @Override
    public void start(Stage primaryStage) throws Exception {
        windwo = primaryStage;
        windwo.setTitle("ITEMS REACHED TO MINIMUM QUANTITY");
        TableColumn<Item, String> codecolumn = new TableColumn<>("Code");
        codecolumn.setMaxWidth(200);
        codecolumn.setCellValueFactory(new PropertyValueFactory<>("code"));

        TableColumn<Item, String> namecolumn = new TableColumn<>("Name");
        namecolumn.setMaxWidth(200);
        namecolumn.setCellValueFactory(new PropertyValueFactory<>("NameOfItem"));

        TableColumn<Item, String> quantitycolumn = new TableColumn<>("Quantity");
        quantitycolumn.setMaxWidth(200);
        quantitycolumn.setCellValueFactory(new PropertyValueFactory<>("NumOfItem"));

        TableColumn<Item, String> pricecolumn = new TableColumn<>("Price");
        pricecolumn.setMaxWidth(200);
        pricecolumn.setCellValueFactory(new PropertyValueFactory<>("Price"));

        table = new TableView<>();
        table.setItems(getItem());
        table.getColumns().addAll(codecolumn, namecolumn, quantitycolumn, pricecolumn);

        VBox vbx = new VBox();
        vbx.getChildren().addAll(table);

        Scene scene = new Scene(vbx);
        windwo.setScene(scene);
        windwo.show();

    }

    public ObservableList<Item> getItem() {
        ObservableList<Item> items = FXCollections.observableArrayList();

        String code = "";
        String nameOfItem = "";
        String numOfItem = "";
        String price = "";
        try {
            Scanner x = new Scanner(new File("files/itemsData.txt"));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                code = x.next();
                nameOfItem = x.next();
                numOfItem = x.next();
                price = x.next();
                if (Integer.parseInt(numOfItem)<=50)
                     items.add(new Item(code, nameOfItem, numOfItem, price));
            }
            x.close();
        } catch (Exception E) {
            System.out.println("error");
        }

        return items;
    }

}
