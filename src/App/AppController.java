package App;

import Events.AppEvent;
import Events.AppMessage;
import Events.ListenerInterface;
import GUI.AppGui;
import Models.AppBase;
import javafx.stage.Stage;

/**
 *
 * @author Owner
 */
public class AppController implements ListenerInterface {

    // Creates a new AppGui object to later on be 
    protected AppGui gui;
    protected AppBase activeModule = null;

    /**
     * Constructor to create new AppController object. Also adds the module as a
     * listener.
     *
     * @param primaryStage - Will be used in AppGui class to help build the GUI
     * for the user.
     */
    public AppController(Stage primaryStage) {
        this.gui = new AppGui(primaryStage);
        this.gui.addListener(this);
    }

    /**
     * Method to open the logInPanel.
     */
    private void logInPanel() {
        // Loads the logInPanel() in AppGui class.
        this.gui.logInPanel();
        this.gui.removeListener(this.activeModule);
        this.activeModule = null;
    }

    /**
     * Method to load the registrationPanel.
     */
    private void registrationPanel() {
        this.gui.registrationPanel();
        this.activeModule = null;
    }

    /**
     * Method to load the homeScreenPanel.
     */
    private void homeScreenPanel() {
        this.gui.homeScreenPanel();
        this.activeModule = null;
    }

    /**
     * Overridden method from the ListenerInterface that performs actions based
     * on what the AppController module listens for.
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
