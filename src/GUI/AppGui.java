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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Owner
 */
public class AppGui extends AppBase {

    // Create Stage object to take in the stage passed in from the controller.
    private final Stage stage;

    /**
     * Constructor to set the passed in stage from the AppController class to
     * the defined stage.
     *
     * @param primaryStage - Stage passed in from AppController class.
     */
    public AppGui(Stage primaryStage) {
        this.stage = primaryStage;
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
        Label userNameLabel = this.addLabel("Username");
        TextField userNameTxtField = this.addTextField("Username");

        Label passWordLabel = this.addLabel("Password");
        TextField passWordTxtField = this.addTextField("Password");

        Button btnCreateNewAccount = this.addButton("Create new account", new AppMessage(AppMessage.REGISTRATION_PANEL));
        Button btnLogIn = this.addButton("Log in", new AppMessage(AppMessage.HOME_SCREEN_PANEL));
        // Finish doing the layout of all the buttons and adding the scene.
        VBox vb = this.addVBox("Log in");
        vb.getChildren().addAll(userNameLabel, userNameTxtField, passWordLabel, passWordTxtField, btnCreateNewAccount, btnLogIn);
        vb.setAlignment(Pos.CENTER);

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

        //this.checkValues(userNameTxt, conUserNameTxt);
        //this.checkValues(passWordTxt, conPassWordTxt);

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
        // Creating the TabPane object.
        TabPane tPane = this.buildTabPane("Home Screen");
        // Creating a new producers Tab in the tPane TabPane object. Also adds the tab contents to build the Tab.
        Tab producersTab = this.addTab("Producers");
        // Creates a new directors Tab in the tPane TabPane object. Also adds the Tab contents to build the Tab.
        Tab directorsTab = this.addTab("Directors");
        // Creates a new writers Tab in the tPane TabPane object. Also adds the Tab contents to build the Tab.
        Tab writersTab = this.addTab("Writers");
        // Creates a new actors Tab in the tPane TabPane object. Also adds the Tab contents to build the Tab.
        Tab actorsTab = this.addTab("Actors");

        // Adds all of the Tabs to the TabPane object.
        tPane.getTabs().addAll(producersTab, directorsTab, writersTab, actorsTab);

        // Creates a new scene and populates it with the TabPane object.
        Scene scene = new Scene(tPane, 800, 400);
        // Returns the newly created scene.
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
        Button btn = new Button();
        btn.setText(_name);
        //Add setOnAction event
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Fire a custom event.
                AppEvent appEvent = new AppEvent(this, _message);
                fireEvent(appEvent);
            }
        });
        return btn;
    }

    /**
     * Method that constructs a new label.
     *
     * @param _name - Name used for new label.
     * @return - New label object.
     */
    private Label addLabel(String _name) {
        Label lbl = new Label();
        lbl.setText(_name);
        return lbl;

    }

    /**
     * Method to create a TextField object.
     *
     * @param _name - Passed in to set the name of the TextField.
     * @return - Returns created TextField object.
     */
    private TextField addTextField(String _name) {
        TextField txtField = new TextField();
        txtField.setText(_name);
        txtField.setPromptText(_name);
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
     * Method that creates a new TabPane object and returns it.
     *
     * @param _name - Name of the TabPane.
     * @return - Newly created TabPane object.
     */
    private TabPane buildTabPane(String _name) {
        TabPane tp = new TabPane();
        return tp;
    }

    /**
     * Method that creates a new Tab
     *
     * @param _name
     * @return
     */
    private Tab addTab(String _name) {
        Tab tab = new Tab(_name);
        return tab;
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
