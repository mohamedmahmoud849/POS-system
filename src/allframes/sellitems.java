package allframes;

import java.util.ArrayList;
import java.util.List;
import pos.*; // msh 3arfa leha lazma wla la2 bs han3rf ya3ni aked :""")))
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class sellitems extends Application {
    ArrayList<Double> ar = new ArrayList( );
    static int i=0;
    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("SELL ITEM");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(30);
        grid.setVgap(30);
        grid.setPadding(new Insets(25, 25, 25, 25));
         TextField userTextField = new TextField();
        userTextField.setPrefWidth(800);
       grid.add(userTextField,6,9);

        Label l = new Label("item code :");
        grid.add(l, 0, 1);
        TextField t = new TextField();
        grid.add(t, 1, 1);

        Label l1 = new Label("quantity :");
        grid.add(l1, 0, 2);

        TextField t1 = new TextField();
        grid.add(t1, 1, 2);

        Label l2 = new Label("payment :");
        grid.add(l2, 0, 3);

        final ComboBox Options = new ComboBox();
        Options.getItems().addAll(
                "cash", "credit"
        );
        Options.getSelectionModel().selectFirst();
        grid.add(Options, 0, 4);

        Label l4 = new Label("print bill :");
        grid.add(l4, 0, 5);

        Button btn = new Button("Sell & Print Bill");
        grid.add(btn, 1, 5); 
        Button btn2 = new Button("Add");
        grid.add(btn2, 1, 7);

        Scene scene = new Scene(grid, 400, 500);
        stage.setScene(scene);
        stage.show();
      int a = 0;
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent i) {
                
                if (t1.getText().equals("") || t.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Fill All Requirments !");

                } else {
                    try {
                        //Payment payment = new Payment((String) Options.getValue(), t.getText(), Integer.parseInt(t1.getText()));
                        Cash z= new Cash();
                       double x=z.SELLS(t.getText(), Integer.parseInt(t1.getText()));
                       ar.add(x);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "NumberFormatException!");
                    }
                }
            }
        }); 
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent i) { 
                int sum=0;
                for (int o=0;o<ar.size();o++)
                {
                    sum+=ar.get(o);
                } 
                JOptionPane.showMessageDialog(null, "You`ve paid : "+ sum+ " LE");
            }
        });
        

    } 
   
}
