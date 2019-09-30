package App;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * @author Dillon, Amina, Kumar. Last Updated: September 29, 2019.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        AppController appContol = new AppController(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
