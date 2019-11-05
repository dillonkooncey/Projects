package App;

import Events.AppEvent;
import Events.AppMessage;
import Events.ListenerInterface;
import GUI.AppGui;
import javafx.stage.Stage;

/**
 * Class that acts as the controller for the Application. This class loads
 * panels and send the User to certain panels based on GUI commands.
 *
 * @author Dillon. Last updated: November 4, 2019.
 */
public class AppController implements ListenerInterface {
    // Makes the controller aware of the GUI so it can route the user to different panels based on certain actions.
    protected AppGui gui;

    /**
     * Constructor to create new AppController object. Also adds the module as a
     * listener.
     *
     * @param primaryStage - Will be used in AppGui class to help build the GUI
     * for the user.
     */
    public AppController(Stage primaryStage) {
        // Creates stage for the AppGui to show.
        this.gui = new AppGui(primaryStage);
        // Sets the controller as a listener.
        this.gui.addListener(this);
    }

    /**
     * Method to open the logInPanel. Controller for Log in panel.
     */
    private void logInPanel() {
        // Loads the logInPanel() in AppGui class.
        this.gui.logInPanel();
    }

    /**
     * Method to load the registrationPanel in AppGui class. Controller for
     * registration panel.
     */
    private void registrationPanel() {
        this.gui.registrationPanel();
    }

    /**
     * Method to load the homeScreenPanel in AppGui class. Controller for home
     * screen panel.
     */
    private void homeScreenPanel() {
        this.gui.homeScreenPanel();
    }

    /**
     * Overridden method from the ListenerInterface that performs actions based
     * on what the AppController module listens for.
     *
     * @param _event - Includes instructions for controller to route user to
     * different modules based on certain events.
     */
    @Override
    public void messageRecieved(AppEvent _event) {
        switch (_event.getMessage().getMessageCode()) {
            case AppMessage.LOG_IN_PANEL:
                System.out.println("User has signed out and now going to Log in page.");
                this.logInPanel();
                break;
            case AppMessage.HOME_SCREEN_PANEL:
                System.out.println("User has logged in and now going to home screen.");
                this.homeScreenPanel();
                break;
            case AppMessage.REGISTRATION_PANEL:
                System.out.println("User is creating a new account.");
                this.registrationPanel();
                break;
            default:
                System.out.println("Message not needed...");
                break;
        }
    }

}
