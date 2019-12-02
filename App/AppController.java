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
 * @author Dillon. Last updated: December 1, 2019.
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
     * Method to show the account recovery panel in the AppGui class.
     */
    private void accountRecoveryPanel() {
        this.gui.accountRecoveryPanel();
    }

    /**
     * Method to load the homeScreenPanel in AppGui class. Controller for home
     * screen panel.
     */
    private void homeScreenPanel() {
        this.gui.homeScreenPanel();
    }

    /**
     * Method to show the options panel in the AppGui class.
     */
    private void optionsPanel() {
        this.gui.optionsPanel();
    }

    /**
     * Method to show the delete account panel in the AppGui class.
     */
    private void deleteAccountPanel() {
        this.gui.deleteAccountPanel();
    }

    /**
     * Method to show the movies panel in the AppGui class.
     */
    private void searchMoviesPanel() {
        this.gui.searchMoviePanel();
    }

    /**
     * Method to show the Actors panel in the AppGui class.
     */
    private void searchActorsPanel() {
        this.gui.searchActorsPanel();
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
            case AppMessage.ALL_MOVIES_PANEL:
                System.out.println("User is going to search movies panel.");
                this.searchMoviesPanel();
                break;
            case AppMessage.ACTORS_PANEL:
                System.out.println("User is going to the search actors panel.");
                this.searchActorsPanel();
                break;
            case AppMessage.OPTIONS_PANEL:
                System.out.println("User is going to the options panel.");
                this.optionsPanel();
                break;
            case AppMessage.ACCOUNT_RECOVERY:
                System.out.println("User is going to account recovery panel.");
                this.accountRecoveryPanel();
                break;
            case AppMessage.DELETE_ACCOUNT:
                System.out.println("User is going to delete account panel.");
                this.deleteAccountPanel();
                break;
            default:
                System.out.println("Message not needed...");
                break;
        }
    }

}
