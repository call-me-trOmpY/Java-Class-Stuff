import javax.swing.text.Position;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.text.TextAlignment;

public class lab10 extends Application {
   @Override
   public void start(Stage stage) {
       // set scene and title
       Scene scene = new Scene(new Group(), 250, 250);
       stage.setTitle("Shape Display");

       GridPane grid = new GridPane();
       grid.setVgap(10);
       grid.setHgap(40);
       grid.setPadding(new Insets(30, 50, 50, 50));
	   //grid.setGridLinesVisible(true);

       // label for the RED Triangle
       Label red = new Label("RED");
       grid.setHalignment(red,HPos.CENTER);
       red.setTextFill(Color.web("#ff0900"));
       grid.add(red, 0, 0);
       // Triangle with red color
       Polygon triangle = new Polygon(50 / 2, 0, 50, 50, 0, 50);
       triangle.setFill(Color.web("#ff0900"));
       grid.add(triangle, 0, 1);

	   // label for the BLUE Diamond
       Label blue = new Label("BLUE");
       blue.setTextFill(Color.web("#0000FF"));
       grid.add(blue, 1, 0);
       grid.setHalignment(blue,HPos.CENTER);
       // Diamond shape
       Polygon diamond = new Polygon(25, 0, 50, 25, 25, 50, 0,25,25,0 );
       diamond.setFill(Color.web("#0000FF"));
       grid.add(diamond, 1, 1);

       // label for the Yellow Circle
       Label yellow = new Label("YELLOW");
       grid.add(yellow, 0, 2);
       grid.setHalignment(yellow,HPos.CENTER);
       // Circle shape
       Circle circle = new Circle(25);
       circle.setFill(Color.web("#FFFF00"));
       grid.add(circle, 0, 3);

       // label for the Green Rectangle
       Label green = new Label("GREEN");
       green.setTextFill(Color.web("#008000"));
       grid.add(green, 1, 2);
       grid.setHalignment(green,HPos.CENTER);
       // Rectangle shape
       Rectangle rectangle = new Rectangle(50,50);
       rectangle.setFill(Color.web("#008000"));
       grid.add(rectangle, 1, 3);

       // add gridpane to group
       Group root = (Group) scene.getRoot();
       root.getChildren().add(grid);
       // set scene and show stage
       stage.setScene(scene);
       stage.show();
   }

   // Main method
   public static void main(String[] args) {
       Application.launch(args);
   }
}