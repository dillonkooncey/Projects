package App;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class where the project begins.
 * @author Dillon, Amina, Kumar. Last Updated: October 6, 2019.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        AppController appControl = new AppController(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
