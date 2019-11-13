package GUI;

import Events.AppEvent;
import Events.AppMessage;
import Events.AppBase;
import UserModels.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Class that displays all GUI to the user.
 *
 * @author Dillon. Last updated: November 4, 2019.
 */
public class AppGui extends AppBase {

    // Create Stage object that will be built based on how panel is to be designed.
    private final Stage stage;
    // User object to give GUI access to User class for User method calls.
    private User user;

    /**
     * Constructor to set the passed in stage from the AppController class to
     * the defined stage and loads the loginPanel.
     *
     * @param _primaryStage - Stage passed in from AppController class.
     */
    public AppGui(Stage _primaryStage) {
        // Assign _primaryStage as this.stage.
        this.stage = _primaryStage;
        // Show the logInPanel
        this.logInPanel();
    }

    /**
     * Loads log in panel. View panel for log in.
     */
    public void logInPanel() {
        // Create a scene that will call the buildLogInPanel() to build that scene.
        Scene scene = this.buildLogInPanel();
        // Set the title of the passed in stage,then set the scene, and show the stage.
        this.stage.setTitle("Log In");
        // Sets the scene as the scene created in buildLogInPanel().
        this.stage.setScene(scene);
        // Display the stage.
        this.stage.show();
    }

    /**
     * Loads registration panel. View Panel for registration panel.
     */
    public void registrationPanel() {
        // Create a scene that will call the buildRegistrationPanel() to build the scene.
        Scene scene = this.buildRegistrationPanel();
        // Set the title of the passed in stage,then set the scene, and show the stage.
        this.stage.setTitle("Register");
        // Sets the scene as th scene created in buildRegistrationPanel().
        this.stage.setScene(scene);
        // Display the stage.
        this.stage.show();
    }

    /**
     * Loads home screen panel. View panel for homeScreenPanel.
     */
    public void homeScreenPanel() {
        // Create a scene that will call the buildHomeScreenPanel() to build the scene.
        Scene scene = this.buildHomeScreenPanel();
        // Set the title of the passed in stage,then set the scene, and show the stage.
        this.stage.setTitle("Home Screen");
        // Sets the scene as the scene created in buildHomeScreenPanel();
        this.stage.setScene(scene);
        // Display the stage.
        this.stage.show();
    }

    public void searchMoviePanel() {
        // Create a scene that will be built by the buildSearchMoviePanel().
        Scene scene = this.buildSearchMoviePanel();
        // Set the title of the stage.
        this.stage.setTitle("Search Movies");
        // Set the scene with the newly built scene.
        this.stage.setScene(scene);
        // Show the stage.
        this.stage.show();
    }

    public void searchActorsPanel() {
        // Call the buildSearchActorsPanel() to build the scene.
        Scene scene = this.buildSearchActorsPanel();
        // Set the title of the Stage.
        this.stage.setTitle("Search Actors");
        // Set the scene of the stage with the scene built in the buildSearchActorsPanel();
        this.stage.setScene(scene);
        // Show the stage.
        this.stage.show();
    }

    /**
     * Constructs the scene for the login screen. Model for log in panel.
     *
     * @return - Returns newly constructed scene object to loginPanel().
     */
    private Scene buildLogInPanel() {
        // Creating the GridPane object that will be initially constructed in the buildGridPane().
        GridPane grid = this.buildGridPane();
        // Sets the verticle gap between rows in GridPane.
        grid.setVgap(10);
        // Sets the Horizontal gap between Columns in GridPane.
        grid.setHgap(10);
        // Creating the email label and textfield which will be built by helper methods.
        Label emailLbl = this.addLabel("Email: ");
        TextField emailTxt = this.addTextField("Email");
        // Creating the username label and Textfield which will be build helper methods.
        Label userNameLbl = this.addLabel("Username: ");
        TextField userNameTxt = this.addTextField("Username");
        // Creating the password label and textfield which will be built by helper methods.
        Label passWordLbl = this.addLabel("Password: ");
        TextField passWordTxt = this.addTextField("Password");
        // Creating the "create new account" and "log in" button.
        Button registerBtn = this.addButton("Create new account", new AppMessage(AppMessage.REGISTRATION_PANEL));
        Button logInBtn = this.addButton("Log in", new AppMessage(AppMessage.HOME_SCREEN_PANEL));
        // Organizing the GridPane objects labels.
        grid.add(emailLbl, 0, 1);
        grid.add(userNameLbl, 0, 2);
        grid.add(passWordLbl, 0, 3);
        // Orgainzing the GridPane objects TextFields.
        grid.add(emailTxt, 1, 1);
        grid.add(userNameTxt, 1, 2);
        grid.add(passWordTxt, 1, 3);
        // Orgainzing the GridPane objects buttons.
        grid.add(registerBtn, 1, 4);
        grid.add(logInBtn, 0, 4);
        // Populating the VBox object with the ImageView and GridPane objects.
        // Creating the scene.
        Scene scene = new Scene(grid, 600, 350);
        // Returning the newly built scene object.
        return scene;

    }

    /**
     * Constructs the scene for the registration screen. Model for registration
     * panel.
     *
     * @return - Returns newly created scene object to registrationPanel().
     */
    private Scene buildRegistrationPanel() {
        // Creating the GridPane object and setting the Verticle/Horizontal gap.
        GridPane grid = this.buildGridPane();
        grid.setVgap(20);
        grid.setHgap(10);
        // Creating a Registration label to act as a Title for the panel.
        Label registration = this.addLabel("Registration");
        // Label and TextField for email information.
        Label emailLbl = this.addLabel("Email: ");
        TextField emailTxt = this.addTextField("Email");
        // Label and TextField for username information.
        Label userNameLbl = this.addLabel("Username: ");
        TextField userNameTxt = this.addTextField("Username");
        // Label and TextField for Password information.
        Label passWordLbl = this.addLabel("Password: ");
        TextField passWordTxt = this.addTextField("Password");
        // Buttons for registering the account and exiting to the log in screen.
        Button registerBtn = this.addButton("Submit", new AppMessage(AppMessage.HOME_SCREEN_PANEL));
        Button logOutBtn = this.addButton("Return to log in screen", new AppMessage(AppMessage.LOG_IN_PANEL));
        // Organizing the Labels in the GridPane object.
        grid.add(registration, 0, 0, 2, 1);
        grid.add(emailLbl, 0, 1);
        grid.add(userNameLbl, 0, 2);
        grid.add(passWordLbl, 0, 3);
        // Organizing the TextFields, Buttons, and ChoiceBox in GridPane object.
        grid.add(emailTxt, 1, 1);
        grid.add(userNameTxt, 1, 2);
        grid.add(passWordTxt, 1, 3);
        grid.add(registerBtn, 0, 5);
        grid.add(logOutBtn, 1, 5);
        // Creating a new Scene object and populating it with the newly build grid.
        Scene scene = new Scene(grid, 600, 350);
        // Returning the newly build scene.
        return scene;
    }

    /**
     * Constructs the scene for the home screen. Model for home Screen panel.
     *
     * @return - Returns newly created scene object to homeScreenPanel().
     */
    private Scene buildHomeScreenPanel() {
        // Building the GridPane object.
        GridPane grid = this.buildGridPane();
        // Setting the verticle and horizontal gap for GridPane.
        grid.setVgap(5);
        grid.setHgap(5);
        // Building the labels and buttons for the GridPane object.
        Label homeScreenLbl = this.addLabel("Welcome to the Movie Finder App");
        Button searchMoviesBtn = this.addButton("Search Movies", new AppMessage(AppMessage.ALL_MOVIES_PANEL));
        Button searchMovieActorsBtn = this.addButton("Search Movie Actors", new AppMessage(AppMessage.ACTORS_PANEL));
        Button logOutBtn = this.addButton("Log out", new AppMessage(AppMessage.LOG_IN_PANEL));
        // Adding the labels and buttons to the gridpane object.
        grid.add(logOutBtn, 3, 0);
        grid.add(homeScreenLbl, 0, 1, 2, 1);
        grid.add(searchMoviesBtn, 0, 2);
        grid.add(searchMovieActorsBtn, 1, 2);
        // Create the scene and return it.
        Scene scene = new Scene(grid, 600, 350);
        return scene;
    }

    /**
     * Method that builds the SearchMovie panel.
     *
     * @return - Returns scene of the movie panel.
     */
    private Scene buildSearchMoviePanel() {
        // Building the GridPane object.
        GridPane grid = this.buildGridPane();
        // Setting the horizontal and verticle gap of the gridpane.
        grid.setVgap(10);
        grid.setHgap(5);
        // Building the lables, textfields, and buttons for the grid pane.
        Label searchMovieLbl = this.addLabel("Search Movie");
        TextField searchMovieTxt = this.addTextField("Search");
        Button search = this.addButton("Search", new AppMessage(AppMessage.ALL_MOVIES_PANEL));
        Label movieRatingLbl = this.addLabel("Movie Rating");
        TextField movieRatingTxt = this.addTextField("The movie rating is: Under Construction");
        Button returnToHomeScreen = this.addButton("Return to home Screen", new AppMessage(AppMessage.HOME_SCREEN_PANEL));
        // Adding the Labels, TextFields, and Buttons to the GridPane.
        grid.add(returnToHomeScreen, 3, 0);
        grid.add(searchMovieLbl, 0, 1);
        grid.add(searchMovieTxt, 1, 1);
        grid.add(search, 2, 1);
        grid.add(movieRatingLbl, 0, 2);
        grid.add(movieRatingTxt, 1, 2);
        // Building the Scene with the newly constructed GridPane and setting the size.
        Scene scene = new Scene(grid, 600, 350);
        // Return the scene.
        return scene;
    }

    /**
     * Method that builds the ActorPanel scene.
     * @return - The actorsPanel scene.
     */
    private Scene buildSearchActorsPanel() {
        // Cnstruct a GridPane object.
        GridPane grid = this.buildGridPane();
        // Set the verticle and horizontal gap.
        grid.setVgap(10);
        grid.setHgap(5);
        // Build the labels, textfields, buttons, and ListView for the GridPane.
        Label searchActorLbl = this.addLabel("Search for Actor");
        TextField searchActorTxt = this.addTextField("Search");
        Button search = this.addButton("Search", new AppMessage(AppMessage.ACTORS_PANEL));
        Label listOfMoviesLbl = this.addLabel("List of movies acted in");
        ListView listOfMoviesList = new ListView();
        Button returnToHomeScreen = this.addButton("Return to home Screen", new AppMessage(AppMessage.HOME_SCREEN_PANEL));
        // Add all of the labels, textfields, buttons, and listview to the GridPane object.
        grid.add(returnToHomeScreen, 3, 0);
        grid.add(searchActorLbl, 0, 1);
        grid.add(searchActorTxt, 1, 1);
        grid.add(search, 2, 1);
        grid.add(listOfMoviesLbl, 0, 2);
        grid.add(listOfMoviesList, 1, 2);
        // Populate the scene with the GridPane and set the size,
        Scene scene = new Scene(grid, 600, 350);
        // Return the newly created Scene.
        return scene;
    }

    /**
     * Constructs a new Button with given parameters.
     *
     * @param _name - Sets the title of the Button.
     * @param _message - Message sent with the event.
     * @return - New Button object.
     */
    private Button addButton(String _name, final AppMessage _message) {
        // Adding a new Button object.
        Button btn = new Button();
        // Setting the text for that button.
        btn.setText(_name);
        //Add setOnAction event to perform action user desires.
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Fire a custom event.
                AppEvent appEvent = new AppEvent(this, _message);
                fireEvent(appEvent);
            }
        });
        // Return newly created button object with new event action capability.
        return btn;
    }

    /**
     * Method that constructs a new label.
     *
     * @param _name - Name used for new label.
     * @return - New label object.
     */
    private Label addLabel(String _name) {
        // Creating a new label object.
        Label lbl = new Label();
        // Adding text for that label based on passed in String.
        lbl.setText(_name);
        // Returning that newly created Label.
        return lbl;

    }

    /**
     * Method to create a TextField object.
     *
     * @param _name - Passed in to set the name of the TextField.
     * @return - Returns created TextField object.
     */
    private TextField addTextField(String _name) {
        // Creating a new TextField object.
        TextField txtField = new TextField();
        txtField.setPromptText(_name);
        return txtField;
    }

    /**
     * Method to create a new GridPane object.
     *
     * @param _name - Name of the GridPane.
     * @return - Returns newly created GridPane object.
     */
    private GridPane buildGridPane() {
        // Creates new GridPane object.
        GridPane gp = new GridPane();
        // Setting the alignment of the GridPane object passed in.
        gp.setAlignment(Pos.CENTER);
        // Sets the padding of GridPane.
        gp.setPadding(new Insets(10, 10, 10, 10));
        // Sets the minimum size of GridPane.
        // Returns newly created GridPane.
        return gp;
    }
    
    /**
     * Method that takes in a image path string and builds the ImageView object.
     * @param _imagePath - The path of the image used.
     * @return - The ImageView object with the desired picture.
     */
    private ImageView createImageView(String _imagePath) {
        // Create the image object with the image path passed in.
        Image img = new Image(_imagePath);
        // Create the Imageview based on the image previouly created.
        ImageView viewImage = new ImageView(img);
        // Return the newly created ImageView object.
        return viewImage;
    }

}
