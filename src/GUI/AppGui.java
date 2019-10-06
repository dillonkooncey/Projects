package GUI;

import Events.AppEvent;
import Events.AppMessage;
import Events.AppBase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * Class that displays all GUI to the user.
 *
 * @author Dillon, Amina, Kumar. Last updated: September 29, 2019.
 */
public class AppGui extends AppBase {

    // Create Stage object that will be built based on how panel is to be designed.
    private final Stage stage;
    protected DataBase db;

    /**
     * Constructor to set the passed in stage from the AppController class to
     * the defined stage.
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
        grid.add(emailLbl, 0, 0);
        grid.add(userNameLbl, 0, 1);
        grid.add(passWordLbl, 0, 2);
        // Orgainzing the GridPane objects TextFields.
        grid.add(emailTxt, 1, 0);
        grid.add(userNameTxt, 1, 1);
        grid.add(passWordTxt, 1, 2);
        // Orgainzing the GridPane objects buttons.
        grid.add(registerBtn, 1, 3);
        grid.add(logInBtn, 0, 3);
        // Creating the scene.
        Scene scene = new Scene(grid, 450, 350);
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
        // Label and TextField for account "Job Title".
        Label optionsLbl = this.addLabel("Options: ");
        ChoiceBox choices = this.buildChoiceBox();
        // Buttons for registering the account and exiting to the log in screen.
        Button registerBtn = this.addButton("Submit", new AppMessage(AppMessage.HOME_SCREEN_PANEL));
        Button logOutBtn = this.addButton("Return to log in screen", new AppMessage(AppMessage.LOG_IN_PANEL));
        // Organizing the Labels in the GridPane object.
        grid.add(registration, 0, 0, 2, 1);
        grid.add(emailLbl, 0, 1);
        grid.add(userNameLbl, 0, 2);
        grid.add(passWordLbl, 0, 3);
        grid.add(optionsLbl, 0, 4);
        // Organizing the TextFields, Buttons, and ChoiceBox in GridPane object.
        grid.add(emailTxt, 1, 1);
        grid.add(userNameTxt, 1, 2);
        grid.add(passWordTxt, 1, 3);
        grid.add(choices, 1, 4);
        grid.add(registerBtn, 0, 5);
        grid.add(logOutBtn, 1, 5);
        // Creating a new Scene object and populating it with the newly build grid.
        Scene scene = new Scene(grid, 450, 350);
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
        Button searchMoviesBtn = this.addButton("Search All Movies", new AppMessage(AppMessage.ALL_MOVIES_PANEL));
        Button searchMovieGenreBtn = this.addButton("Search movies by genre", new AppMessage(AppMessage.MOVIE_GENRE_PANEL));
        Button searchMovieActorsBtn = this.addButton("Search Movie Actors", new AppMessage(AppMessage.MOVIE_ACTORS_PANEL));
        Button searchMovieRatingBtn = this.addButton("Search movies by rating", new AppMessage(AppMessage.MOVIE_RATING_PANEL));
        Button optionsBtn = this.addButton("Options", new AppMessage(AppMessage.OPTIONS_PANEL));
        // Adding the labels and buttons to the gridpane object.
        grid.add(optionsBtn, 3, 0);
        grid.add(homeScreenLbl, 0, 1, 2, 1);
        grid.add(searchMoviesBtn, 0, 2);
        grid.add(searchMovieGenreBtn, 1, 2);
        grid.add(searchMovieActorsBtn, 0, 3);
        grid.add(searchMovieRatingBtn, 1, 3);

        Scene scene = new Scene(grid, 450, 350);
        return scene;
    }

    /**
     * Method that checks to see if a user exists in the database upon log in.
     *
     * @param _name - Name of the button.
     * @param _username - The username entered in to be checked.
     * @param _password - The password entered in to be checked.
     * @return - Return the button object and its message.
     */
    /*private Button logInRegistration(String _email, String _username, String _password) {
        Boolean isUser = this.db.isUser(_email, _username, _password);
        if(isUser) {
            Button btn = this.addButton(_name, new AppMessage(AppMessage.HOME_SCREEN_PANEL));
            User user = new User(_email, _username, _password);
            return btn;
        } else {
            Button btn = this.addButton(_name, new AppMessage(AppMessage.LOG_IN_PANEL));
            return btn;
        }
    }*/

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

    private ChoiceBox buildChoiceBox() {
        ChoiceBox choice = new ChoiceBox();
        choice.setItems(FXCollections.observableArrayList("Producer", "Artist", "Agent"));
        return choice;

    }

}
