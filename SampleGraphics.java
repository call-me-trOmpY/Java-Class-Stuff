import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.paint.CycleMethod;
import javafx.stage.Stage;

public class SampleGraphics extends Application
{
    Stop[] rainbow = new Stop[] { new Stop(0, Color.RED),
                                  new Stop(.17, Color.ORANGE),
                                  new Stop(.33, Color.YELLOW),
                                  new Stop(.50, Color.GREEN),
                                  new Stop(.67, Color.BLUE),
                                  new Stop(.84, Color.INDIGO),
                                  new Stop(1, Color.VIOLET)};


    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {

         LinearGradient roygbiv = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, rainbow);
        // create a special green to blue gradient to use in lieu of solid color
        // Stop[] stops = new Stop[] { new Stop(0, Color.GREEN), new Stop(.1, Color.rgb(112,219,147)), new Stop(.6, Color.BLUE), new Stop(1, Color.CYAN)};
        Stop[] stops = new Stop[] { new Stop(0, Color.GREEN), new Stop(1, Color.BLUE)};
        LinearGradient greenToBlue = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);


        // Create a pane to hold our shapes
        Pane pane = new Pane();


        Rectangle r = new Rectangle(0, 0, 50, 20);
        r.setFill(Color.BROWN);
        pane.getChildren().add(r);


        // circle
        Circle circle = new Circle();
        circle.setCenterX(600);
        circle.setCenterY(100);
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(greenToBlue);
        pane.getChildren().add(circle);


        // Ellipse
        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(300);
        ellipse.setCenterY(400);
        ellipse.setRadiusX(100);
        ellipse.setRadiusY(50);
        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(5);
        ellipse.setFill(Color.GOLD);
        pane.getChildren().add(ellipse);



        // grid
        drawGrid(pane, 70, 70, 200, 200, 10);

        // rectangle with border, but use polygon
        //drawRectangleWithBorder(pane, 5, 610, 150, 660, 10);


       // triangle
        Color spicyPink = Color.web("FF1CAE");
        Polygon pTri = new Polygon();
        pTri.setFill(spicyPink);
        pTri.getPoints().addAll(new Double[] { 425.0, 575.0, 450.0, 525.0, 475.0, 575.0  });
        pane.getChildren().add(pTri);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 800, 800);
        primaryStage.setTitle("ShowSomeShapes"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }


    protected void drawGrid(Pane pane, double x1, double y1, double x2, double y2, double spacing)
    {
        for (double i = x1; i <= (x1 + x2); i+= spacing)
        {
            Line l = new Line(i, y1, i, y1 + y2);
            l.setStroke(Color.GREEN);
            pane.getChildren().add(l);
        }

        for (double i = y1; i <= (y1 + y2); i+= spacing)
        {
            Line l = new Line(x1, i, x1 + x2, i);
            l.setStroke(Color.BLUE);
            pane.getChildren().add(l);
        }

    }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }

}