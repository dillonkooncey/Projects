package GUI;

import Events.AppEvent;
import Events.AppMessage;
import Models.AppBase;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    // Create Stage object to take in the stage passed in from the controller.
    private final Stage stage;

    /**
     * Constructor to set the passed in stage from the AppController class to
     * the defined stage.
     *
     * @param _primaryStage - Stage passed in from AppController class.
     */
    public AppGui(Stage _primaryStage) {
        this.stage = _primaryStage;
        // Build the logInPanel
        this.logInPanel();
    }

    /**
     * Loads log in panel.
     */
    public void logInPanel() {
        // Create a scene that will call the buildLogInPanel() to build that scene.
        Scene scene = this.buildLogInPanel();
        // Set the title of the passed in stage,then set the scene, and show the stage.
        this.stage.setTitle("Log In");
        this.stage.setScene(scene);
        this.stage.show();
    }

    /**
     * Loads registration panel.
     */
    public void registrationPanel() {
        // Create a scene that will call the buildRegistrationPanel() to build the scene.
        Scene scene = this.buildRegistrationPanel();
        // Set the title of the passed in stage,then set the scene, and show the stage.
        this.stage.setTitle("Register");
        this.stage.setScene(scene);
        this.stage.show();
    }

    /**
     * Loads home screen panel.
     */
    public void homeScreenPanel() {
        // Create a scene that will call the buildHomeScreenPanel() to build the scene.
        Scene scene = this.buildHomeScreenPanel();
        // Set the title of the passed in stage,then set the scene, and show the stage.
        this.stage.setTitle("Home Screen");
        this.stage.setScene(scene);
        this.stage.show();
    }

    /**
     * Constructs the scene for the login screen.
     *
     * @return - Returns newly constructed scene object to loginPanel().
     */
    private Scene buildLogInPanel() {
        // Adding the label and TextField for Username to be enetered in by user.
        Label userNameLabel = this.addLabel("Username");
        TextField userNameTxtField = this.addTextField("Username");
        // Adding the label and TextField for the Passoword to be entered in by the user.
        Label passWordLabel = this.addLabel("Password");
        TextField passWordTxtField = this.addTextField("Password");
        // Adding create new account button and log in button and including events for both buttons based on where those buttons are designed to route to.
        Button btnCreateNewAccount = this.addButton("Create new account", new AppMessage(AppMessage.REGISTRATION_PANEL));
        Button btnLogIn = this.addButton("Log in", new AppMessage(AppMessage.HOME_SCREEN_PANEL));
        // Finish doing the layout of all the buttons and adding the scene.
        VBox vb = this.addVBox("Log in");
        vb.getChildren().addAll(userNameLabel, userNameTxtField, passWordLabel, passWordTxtField, btnCreateNewAccount, btnLogIn);
        vb.setAlignment(Pos.CENTER);
        // Creating a new scene and returning that new scene back to the logInPanel().
        Scene scene = new Scene(vb, 800, 400);
        return scene;
    }

    /**
     * Constructs the scene for the registration screen.
     *
     * @return - Returns newly created scene object to registrationPanel().
     */
    private Scene buildRegistrationPanel() {
        // Creating the labels using addLabel().
        Label userNameLbl = this.addLabel("Username: ");
        Label conUserNameLbl = this.addLabel("Confirm Username: ");
        Label passWordLbl = this.addLabel("Password: ");
        Label nameLbl = this.addLabel("Name: ");
        Label conPassWordLbl = this.addLabel("Confirm password: ");
        // Creting the TextFields using addTextField().
        TextField userNameTxt = this.addTextField("Username");
        TextField conUserNameTxt = this.addTextField("Confirm Username");
        TextField passWordTxt = this.addTextField("Password");
        TextField conPassWordTxt = this.addTextField("Confirm password");
        TextField nameTxt = this.addTextField("First and last name");
        // Creating buttons using addButton() that creates a new message based on a user Event.
        Button btnRegister = this.addButton("Register", new AppMessage(AppMessage.HOME_SCREEN_PANEL));
        Button btnExit = this.addButton("Exit to log in screen", new AppMessage(AppMessage.LOG_IN_PANEL));
        // Creating the GridPane to organize the scene.
        GridPane gPane = this.buildGridPane("Register");
        // Adding Labels to GridPane and organizing them.
        gPane.add(nameLbl, 0, 0);
        gPane.add(userNameLbl, 0, 1);
        gPane.add(conUserNameLbl, 0, 2);
        gPane.add(passWordLbl, 0, 3);
        gPane.add(conPassWordLbl, 0, 4);
        // Adding the TextFields and organizing them.
        gPane.add(nameTxt, 1, 0);
        gPane.add(userNameTxt, 1, 1);
        gPane.add(conUserNameTxt, 1, 2);
        gPane.add(passWordTxt, 1, 3);
        gPane.add(conPassWordTxt, 1, 4);
        // Adding the Buttons to the GridPane and organizing them.
        gPane.add(btnExit, 0, 5);
        gPane.add(btnRegister, 1, 5);
        // Creating a new Scene and populating that scene with previously created gPane.
        Scene scene = new Scene(gPane, 800, 400);
        // Returning newly created scene object to registrationPanel();
        return scene;
    }

    /**
     * Constructs the scene for the home screen.
     *
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
        // Setting the text for that TextField based on passed in string.
        txtField.setText(_name);
        // Adding prompt text so user knows what needs to be entered in that partcular TextField.
        txtField.setPromptText(_name);
        // Returning this newly created TextField.
        return txtField;
    }

    /**
     * Method for creating a VBox object.
     *
     * @param _boxName - Name passed in to name the VBox object.
     * @return - Returns newly created VBox.
     */
    private VBox addVBox(String _boxName) {
        // Creates the VBox.
        VBox vBox = new VBox();
        // Sets the spacing for items in the VBox.
        vBox.setSpacing(10);
        // Sets the padding around the edges for the VBox.
        vBox.setPadding(new Insets(10, 50, 50, 50));
        // Returns the newly created VBox.
        return vBox;
    }

    /**
     * Method to create a new GridPane object.
     *
     * @param _name - Name of the GridPane.
     * @return - Returns newly created GridPane object.
     */
    private GridPane buildGridPane(String _name) {
        // Creates new GridPane object.
        GridPane gp = new GridPane();
        // Sets the padding of GridPane.
        gp.setPadding(new Insets(10, 10, 10, 10));
        // Sets the minimum size of GridPane.
        gp.setMinSize(400, 200);
        // Sets the verticle gap between rows in GridPane.
        gp.setVgap(5);
        // Sets the Horizontal gap between Columns in GridPane.
        gp.setHgap(5);
        // Returns newly created GridPane.
        return gp;
    }

    /**
     * Method that checks to see if user enters the same values for
     * Username/confirm username and password/confirm password.
     *
     * @param _name1 - Name of first input.
     * @param _name2 - name of second input.
     */
    private void checkValues(TextField _name1, TextField _name2) {
        // Gets the values enterd into the text field.
        _name1.getText();
        _name2.getText();
        /* If statement to compare the two values. If they are not equal, it 
        rebuilds the registration panel to be refilled by the user.*/
        if (!_name1.equals(_name2)) {
            this.buildRegistrationPanel();
        }
    }

}
