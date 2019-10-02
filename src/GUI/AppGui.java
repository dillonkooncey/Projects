package GUI;

import Events.AppEvent;
import Events.AppMessage;
import Models.AppBase;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Class that displays all GUI to the user. 
 * @author Dillon, Amina, Kumar. Last updated: September 29, 2019.
 */
public class AppGui extends AppBase {

    // Create Stage object that will be built based on how panel is to be designed.
    private final Stage stage;

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
     * Loads log in panel.
     * View panel for log in.
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
     * Loads registration panel.
     * View Panel for registration panel.
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
     * Loads home screen panel.
     * View panel for homeScreenPanel.
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
     * Constructs the scene for the login screen.
     * Model for log in panel.
     * @return - Returns newly constructed scene object to loginPanel().
     */
    private Scene buildLogInPanel() {
        // Creating the GridPane object that will be initially constructed in the buildGridPane().
        GridPane grid = this.buildGridPane();
        // Sets the verticle gap between rows in GridPane.
        grid.setVgap(10);
        // Sets the Horizontal gap between Columns in GridPane.
        grid.setHgap(10);
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
        grid.add(userNameLbl, 0, 0);
        grid.add(passWordLbl, 0, 1);        
        // Orgainzing the GridPane objects TextFields.
        grid.add(userNameTxt, 1, 0);
        grid.add(passWordTxt, 1, 1);        
        // Orgainzing the GridPane objects buttons.
        grid.add(registerBtn, 1, 2);
        grid.add(logInBtn, 0, 2);
        // Creating the scene.
        Scene scene = new Scene(grid, 450, 350);
        // Returning the newly built scene object.
        return scene;
        
    }

    /**
     * Constructs the scene for the registration screen.
     * Model for registration panel.
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
     * Constructs the scene for the home screen.
     * Model for home Screen panel.
     * @return - Returns newly created scene object to homeScreenPanel().
     */
    private Scene buildHomeScreenPanel() {
        // Creating the TilePane object.
        TilePane tilePane = new TilePane();
        // Adding labels for the TilePane for prompting the user.
        Label welcomeLbl = this.addLabel("Welcome to our App!!");
        Label selectLbl = this.addLabel("Select which panel you would like to view:");
        // Creating the available buttons for the TilePane Object.
        Button proBtn = this.addButton("Producers", new AppMessage(AppMessage.PRODUCER_PANEL));
        Button dirBtn = this.addButton("Directors", new AppMessage(AppMessage.DIRECTORS_PANEL));
        Button wirBtn = this.addButton("Writers", new AppMessage(AppMessage.WRITERS_PANEL));
        Button actBtn = this.addButton("Actors", new AppMessage(AppMessage.ACTORS_PANEL));
        Button exitBtn = this.addButton("Log out", new AppMessage(AppMessage.LOG_IN_PANEL));
        // Sending the TilePane and its labels/buttons to a method to create the full TilePane.
        this.createHomeScreenTilePane(welcomeLbl, selectLbl, tilePane, proBtn, dirBtn, wirBtn, actBtn, exitBtn);
        // Creating a new scene and populating it with the newly created TilePane object.
        Scene scene = new Scene(tilePane, 300, 400);
        // Returing the new scene.
        return scene;

    }

    /**
     * Method that creates the TilePane for the Home screen.
     * @param _welcomeLabel - Label that prints "Welcome to our App!!".
     * @param _selectLbl - Label prompting user to select one of the available panels.
     * @param _tPane - The TilePane object.
     * @param _producer - The button for the Producer Panel.
     * @param _director - The button for the director panel.
     * @param _writer - The button for the writer panel.
     * @param _actor - The button for the actor panel.
     * @param _logOut - The button for the logout panel.
     * @return - Returns the newly created TilePane object back to buildHomeScreenPanel().
     */
    private TilePane createHomeScreenTilePane(Label _welcomeLabel, Label _selectLbl, TilePane _tPane, Button _producer, 
            Button _director, Button _writer, Button _actor, Button _logOut) {
        // Adding the Buttons/Labels to the TilePane.
        _tPane.getChildren().addAll(_welcomeLabel, _selectLbl, _producer, _director, _writer, _actor, _logOut);
        // Setting the alignment for the TilePane.
        _tPane.setAlignment(Pos.CENTER);
        _tPane.setPrefColumns(2);
        // Setting the Horizontal and Verticle spacing of the buttons for the TilePane.
        _tPane.setHgap(10);
        _tPane.setVgap(10);
        // Returning the newly built TilePane.
        return _tPane;
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
        txtField.setText(_name);
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
