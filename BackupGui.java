package Backups;

import DataBase.DataBaseTranslator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Class that acts as a backup GUI to demonstrate the functionality of the
 * program.
 *
 * @author Dillon. Last updated December 3, 2019.
 */
public class BackupGui {

    // Creating Scanner object.
    private Scanner input = new Scanner(System.in);
    // Enumeration for panel routing.
    private final int START_PANEL = 0;
    private final int LOG_IN_PANEL = 1;
    private final int CREATE_NEW_ACCOUNT = 2;
    private final int ACCOUNT_RECOVERY = 3;
    private final int HOME_SCREEN_PANEL = 4;
    private final int MOVIE_PANEL = 5;
    private final int OPTIONS_PANEL = 6;
    private final int ACTOR_PANEL = 7;
    private final int DELETE_ACCOUNT_PANEL = 8;
    // Declare a BackupUser object that will be modified later.
    private BackupUser user;

    // Giving access to DataBaseTranslator class for Database calls.
    private static DataBaseTranslator translate = new DataBaseTranslator();
    private final BackupModelController control = new BackupModelController();

    // Main method.
    public static void main(String[] args) {
        BackupGui gui = new BackupGui();
    }

    // Constructor for BackupGui class that go to startup panel.
    public BackupGui() {
        this.startPanel();
    }

    /**
     * Method that show the start up panel for the user.
     */
    private void startPanel() {
        System.out.println("Would you like to sign in, create new account, or recover an account?");
        System.out.println("1.) Log in \n 2.) Create new account \n 3.) Recover Account");
        int appAccessMethod = this.input.nextInt();
        // Route user to panel based on input.
        switch(appAccessMethod) {
            case 1:
                panelRouter(this.LOG_IN_PANEL);
                break;
            case 2:
                panelRouter(this.CREATE_NEW_ACCOUNT);
                break;
            case 3:
                panelRouter(this.ACCOUNT_RECOVERY);
                break;
        }
    }

    /**
     * Method that shows the log in panel for the user.
     */
    private void logInPanel() {
        // Prompt message.
        System.out.println("Log in panel. \n Enter your account information");
        // Fetch email from user and save it.
        System.out.print("Email: ");
        String _email = input.next();
        // Fetch username from user and save it.
        System.out.print("Username: ");
        String _username = input.next();
        // Fetch password from user and save it.
        System.out.print("Password: ");
        String _password = input.next();
        // Create a Hashmap of the users input.
        HashMap<String, String> map = this.createOrValidateHash(_email, _username, _password);
        // Send user information to Database to see if the information matches an account.
        boolean checkInfo = translate.readObject(map, "users");
        // If account exists initialize a new BackupUser object and go to home screen.
        if (checkInfo == true) {
            this.user = new BackupUser(_email, _username, _password);
            panelRouter(this.HOME_SCREEN_PANEL);
            // Go back to log in to re-enter information.
        } else {
            panelRouter(this.LOG_IN_PANEL);
        }
    }

    /**
     * Method that shows the create new account panel.
     */
    private void createNewAccountPanel() {
        System.out.println("Creating a new account \n Enter new account information.");
        System.out.print("Email: ");
        String email = input.next();
        System.out.print("Username: ");
        String username = input.next();
        System.out.print("Password: ");
        String password = input.next();
        // Create a hashmap of the users input.
        HashMap<String, String> map = this.createOrValidateHash(email, username, password);
        // Check and see if the information entered already matches a previous account.
        boolean checkInfo = translate.createObject(map, "users");
        // If user was created go to home screen
        if (checkInfo == true) {
            this.user = new BackupUser(email, username, password);
            panelRouter(this.HOME_SCREEN_PANEL);
            // Go back to create new account to enter new information.
        } else {
            panelRouter(this.CREATE_NEW_ACCOUNT);
        }
    }

    /**
     * Method that shows recover account panel.
     */
    private void recoverAccountPanel() {
        System.out.println("Account Recovery \n Enter the information of the deleted account.");
        System.out.print("Email: ");
        String email = input.next();
        System.out.print("Username: ");
        String username = input.next();
        System.out.print("Password: ");
        String password = input.next();
        // Put user information into a hashmap.
        HashMap<String, String> map = this.recoverHash(email, username, password);
        // Check for deleted account.
        boolean checkDeletedAccount = translate.reactivateAccount(map, "users");
        // If deleted account was found, initialize BackupUser object and go to home screen.
        if (checkDeletedAccount == true) {
            this.user = new BackupUser(email, username, password);
            panelRouter(this.HOME_SCREEN_PANEL);
            // Deleted account was not found so go back to account recovery.
        } else {
            panelRouter(this.ACCOUNT_RECOVERY);
        }
    }

    /**
     * Method that shows home screen panel to user.
     */
    private void homeScreenPanel() {
        System.out.println("Welcome " + this.user.getUsername() + "! \n Where do you want to go?");
        System.out.println("1.) Search Movies \n 2.) Search Actors \n 3.) Options \n 4.) Log out \n 5.) Delete Account");
        int decision = this.input.nextInt();
        // Switch that routes user to panel based on input.
        switch (decision) {
            case 1:
                panelRouter(this.MOVIE_PANEL);
                break;
            case 2:
                panelRouter(this.ACTOR_PANEL);
                break;
            case 3:
                panelRouter(this.OPTIONS_PANEL);
                break;
            case 4:
                panelRouter(this.START_PANEL);
                break;
            case 5:
                panelRouter(this.DELETE_ACCOUNT_PANEL);
            default:
                panelRouter(this.HOME_SCREEN_PANEL);
                break;
        }
    }

    /**
     * Method that shows the movie rating panel.
     */
    private void moviePanel() {
        System.out.print("Search for your favorite movie to find its rating! \n Movie (type done to go back to home screen): ");
        String movie = this.input.next();
        // create a new double of the movie rating
        double movieRating = this.control.findMovieRating(movie);
        // Display the movie rating.
        System.out.println("The rating is " + movieRating);
    }

    /**
     * Method that shows the search actor panel.
     */
    private void actorPanel() {
        System.out.print("Search for your favorite actor to see movies they have acted in! \n Actor (Type done to go back to home screen):");
        String actor = this.input.next();
        // Create a new arraylist of the movie list found for that actor.
        ArrayList<String> movieList = this.control.findActorList(actor);
        // Loop through the ArrayList and print each element.
        for (int i = 0; i < movieList.size(); i++) {
            System.out.println(movieList.get(i));
        }
        System.out.println("Movies in ascending order: " + this.sortAscendingOrder(movieList));
        System.out.println("Movies in Descending order: " + this.sortDescendingOrder(movieList));
    }

    private void optionsPanel() {
        System.out.println("Enter account information change");
        // Changing information here.
        System.out.print("email change: ");
        String email = this.input.next();
        System.out.print("Username change: ");
        String username = this.input.next();
        System.out.print("Password change: ");
        String password = this.input.next();
        // Put new information into a hashmap.
        HashMap<String, String> map = this.updateHash(email, username, password);
        // Send information to database to see if update was made.
        boolean updateObject = translate.updateObject(map, this.user.getUsername(), "users");
        // If update was made update the this.user object and print new attributes.
        if (updateObject == true) {
            this.user = new BackupUser(email, username, password);
            System.out.println(this.user.getEmail() + " " + this.user.getUsername() + " " + this.user.getPassword());
            // Else notify user the update was not successful.
        } else {
            System.out.println("Update not successful.");
        }
    }

    /**
     * Method to demonstrate deleting the account.
     */
    private void deleteAccountPanel() {
        System.out.println("Deleting your account");
        // Send account to database to be deleted.
        boolean delete = translate.deleteObject(this.user.getUsername(), "users");
        // If account was deleted notify user of deleted account then go back to start panel.
        if (delete == true) {
            System.out.println("Account was deleted");
            panelRouter(this.START_PANEL);
            // Notify user that the account was not deleted then go back to home screen panel.
        } else {
            System.out.println("Account was not deleted");
            panelRouter(this.HOME_SCREEN_PANEL);
        }
    }

    /**
     * Method to create the HashMap for creating or validating accounts.
     *
     * @param _email - Email entered.
     * @param _username - Username entered.
     * @param _password - Password entered.
     * @return - Created Hashmap.
     */
    private HashMap<String, String> createOrValidateHash(String _email, String _username, String _password) {
        HashMap<String, String> map = new HashMap();
        map.put("email", _email);
        map.put("username", _username);
        map.put("password", _password);
        map.put("active", "true");
        return map;
    }

    /**
     * Method to build a HashMap designed for updating.
     * @param _email - Email entered.
     * @param _username - Username entered.
     * @param _password - Password entered.
     * @return - New HashMap with passed in information.
     */
    private HashMap<String, String> updateHash(String _email, String _username, String _password) {
        HashMap<String, String> map = new HashMap();
        map.put("email", _email);
        map.put("username", _username);
        map.put("password", _password);
        return map;
    }

    /**
     * Method that creates the hashmap for reactivating accounts.
     *
     * @param _email - Email entered.
     * @param _username - Username entered.
     * @param _password - Password entered.
     * @return - Created Hashmap
     */
    private HashMap<String, String> recoverHash(String _email, String _username, String _password) {
        HashMap<String, String> map = new HashMap();
        map.put("email", _email);
        map.put("username", _username);
        map.put("password", _password);
        map.put("active", "false");
        return map;
    }

    /**
     * Sorting the movie list in ascending order using the collections class.
     *
     * @param movieList - The movie List.
     * @return - Sorted Movie list.
     */
    private ArrayList<String> sortAscendingOrder(ArrayList<String> movieList) {
        // Use the collections class to sort the movies ArrayList.
        Collections.sort(movieList);
        // Return the newly sorted arraylist.
        return movieList;
    }

    /**
     * Method that sorts the ArrayList of movies into descending order using the
     * collections class.
     *
     * @return - The descending order of movie titles.
     */
    private ArrayList<String> sortDescendingOrder(ArrayList<String> movieList) {
        Collections.sort(movieList, Collections.reverseOrder());
        return movieList;
    }

    /**
     * Method that acts as the controller. Method routes user to different
     * panels based in input from user.
     *
     * @param _panel - Int of the desired panel.
     */
    private void panelRouter(int _panel) {
        switch (_panel) {
            case 0:
                this.startPanel();
                break;
            case 1:
                this.logInPanel();
                break;
            case 2:
                this.createNewAccountPanel();
                break;
            case 3:
                this.recoverAccountPanel();
                break;
            case 4:
                this.homeScreenPanel();
                break;
            case 5:
                this.moviePanel();
                break;
            case 6:
                this.optionsPanel();
                break;
            case 7:
                this.actorPanel();
                break;
            case 8:
                this.deleteAccountPanel();
            default:
                break;
        }
    }

}
