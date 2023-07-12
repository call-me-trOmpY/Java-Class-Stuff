//----------------------------------------------------------------------------
/**
 *  A sample to display the three different to perform EventHandlers in JavaFX
 */
//----------------------------------------------------------------------------
//
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HandlerBing extends Application {


  // This is static to facilitate manipulating via the separate handler
  // Typically you would have the application and a "controller"
  //
  private  Text text = new Text(40, 40, "Waiting for Button Click");

  int numClicks = 0;

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {

    Pane pane = new Pane(text);
    //pane.getChildren().add(text);

    // Hold four buttons in an HBox
    Button btHandler = new Button("Handler");
    Button btAnonymous = new Button("AnonymousHandler");
    Button btLambda = new Button("LambaExpression");

    HBox hBox = new HBox(btHandler, btAnonymous, btLambda);
    hBox.setSpacing(10);
    hBox.setAlignment(Pos.CENTER);

    BorderPane borderPane = new BorderPane(pane);
    borderPane.setBottom(hBox);


    // Handler Class method
    SeparateHandlerClass separateHandlerClass = new SeparateHandlerClass();
    btHandler.setOnAction(separateHandlerClass);


    // Anonymous Handler method
    btAnonymous.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override // Override the handle method
      public void handle(ActionEvent e)
      {
          numClicks++;
          text.setText("Anonymous Clicked "+numClicks);
      }
    });



    // Lambda expression
    // btLambda.setOnAction(e -> text.setText("Lambda Click "));
    btLambda.setOnAction(e -> { numClicks++; text.setText("Lambda Click "+numClicks); } );


    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 500, 200);
    primaryStage.setTitle("HandlerBingDemo"); // Set title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }



  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }


  class SeparateHandlerClass implements EventHandler<ActionEvent>
 {
    @Override
    public void handle(ActionEvent e)
    {
        numClicks++;
        text.setText("HandlerEvent clicked "+numClicks);
   }
 }

}



