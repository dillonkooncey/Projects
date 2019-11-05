package App;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class where program starts.
 * @author Dillon. Last Updated: November 4, 2019.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creating a new AppController object and passing it the stage to begin the program.
        AppController appControl = new AppController(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}