
package allframes;
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


public class returnitems extends Application{

    @Override
    public void start(final Stage stage) throws Exception {
         stage.setTitle("RETURN ITEM");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(30);
        grid.setVgap(30);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Label l = new Label("item code :");     
        grid.add(l, 0, 1);
        TextField t = new TextField();
        grid.add(t, 1, 1);
         
        Label l1 = new Label("quantity :");
        grid.add(l1, 0, 2);
        
        TextField t1 = new TextField();
        grid.add(t1, 1, 2);
       
        Label l4 = new Label("Returned Money :");
        grid.add(l4, 0, 5);
        
        Button btn = new Button("Return");
        grid.add(btn, 1, 5);
        
         Scene scene = new Scene(grid, 400, 500);
        stage.setScene(scene);
        stage.show();   
        
          btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent i) { 
                 if (t1.getText().equals("")||t.getText().equals(""))
               {
                   JOptionPane.showMessageDialog(null,"Please Fill All Requirments !");
                  
               } 
                 else { 
                     try {
                Cash x=new Cash();
                x.RETURN(t.getText(), Integer.parseInt(t1.getText()));
                     } 
                      catch (NumberFormatException e)
      {
          JOptionPane.showMessageDialog(null, "NumberFormatException!");
      }
                 }
               
            } 
        });
        
        
 
    }
}
