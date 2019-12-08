package UserModels;

import DataBase.DataBaseTranslator;
import java.util.HashMap;
import java.util.Map;

/**
 * User class that defines user attributes and methods defining what users can
 * do.
 *
 * @author Dillon. Last updated: December 1, 2019.
 */
public class User {

    // Data fields for User class.
    private String email;
    private String username;
    private String password;
    private String active;
    private static DataBaseTranslator translate = new DataBaseTranslator();

    // Overloaded constructor to allow for an empty object.
    public User() {

    }

    // Constuctor to construct new User object.
    public User(String _email, String _username, String _password) {
        this.email = _email;
        this.username = _username;
        this.password = _password;
        this.active = "true";
    }

    /**
     * Method that checks to see if an object is in the database. If so it saves
     * the information passed in as a new object and returns a AppMessage
     * integer. If not it returns a different AppMessage integer.
     *
     * @param _email - Email passed in from login
     * @param _username - Username passed in from login
     * @param _password - Password passed in from login.
     * @return - return true if user was found or false if not.
     */
    public static boolean validateUser(String _email, String _username, String _password) {
        // Create a HashMap and populate it with the information passed in from GUI and the string indicating what it is.
        HashMap<String, String> map = new HashMap();
        map.put("email", _email);
        map.put("username", _username);
        map.put("password", _password);
        map.put("active", "true");
        // boolean that equals the result of the DataBaseTranslator call.
        boolean checkDb = translate.readObject(map, "users");
        // Check and see if user does not exist then create a new one. Else dont.
        if (checkDb == true) {
            return true;
            // Else the object didnt exist so return the int of the log in panel.
        } else {
            return false;
        }
    }

    /**
     * Method that creates and saves a user if information passed in is not
     * found in the database. If not, create a new User object with information
     * passed in. If so, the information already exists so the object could not
     * be created.
     *
     * @param _email - Email entered in at registration menu.
     * @param _username - Username entered in at registration menu.
     * @param _password - Password entered in from registration menu.
     * @return - True of false depending on if User was created or not.
     */
    public static boolean createUser(String _email, String _username, String _password) {
        // Create HashMap and populate it with the information passed in from GUI and the string indicating what it is.
        HashMap<String, String> map = new HashMap();
        map.put("email", _email);
        map.put("username", _username);
        map.put("password", _password);
        map.put("active", "true");
        // Int that equals the result of the DataBaseTranslator method call.
        boolean checkDb = translate.createObject(map, "users");
        // If checkDb = true, a new User object has been created in the database so create a new User object and retrurn true.
        if (checkDb == true) {
            User user = new User(_email, _username, _password);
            return true;
            // Else a user already existed with this information so return false..
        } else {
            return false;
        }

    }

    /**
     * Method that takes in the attribute the user wants changed and the value.
     * Then checks the DataBase to see if the new value desired is already in
     * the database or not. If not then the attribute is changed. If so the
     * request is denied.
     *
     * @param _email - Email String passed in from GUI.
     * @param _username - Username String Passed in from GUI.
     * @param _password - PasswordString passed in from GUI.
     * @return - True of object was updated and false if not.
     */
    public boolean updateInfo(String _email, String _username, String _password) {
        // Create HashMap object with the attribute as the key and the value as the value.
        HashMap<String, String> map = new HashMap();
        map.put("email", _email);
        map.put("username", _username);
        map.put("password", _password);
        // Loop through the HashMap for invalid update situations.
        for (Map.Entry<String, String> entry : map.entrySet()) {
            // If the value is empty remove from the HashMap.
            if (entry.getValue().isEmpty()) {
                map.remove(entry.getValue());
                // If the value entered already matches the users current information then remove from the HashMap.
            } else if (entry.getValue().matches(this.getEmail()) || entry.getValue().matches(this.getPassword()) || entry.getValue().matches(this.getUsername())) {
                map.remove(entry.getValue());
            }
        }
        // Boolean indicating true if change was made or false if not.
        boolean checkDb = translate.updateObject(map, this.getUsername(), "users");
        // If statement for handling true or false from the database.
        if (checkDb == true) {
            // Loop through the HashMap one more time to see which attribute needs to be updated.
            for (Map.Entry<String, String> entry : map.entrySet()) {
                // If the key is email then update the email for the User object.
                if (entry.getKey().matches("email")) {
                    this.setEmail(entry.getValue());
                    // If the key is the username then update the username for the User object.
                } else if (entry.getKey().matches("username")) {
                    this.setUsername(entry.getValue());
                    // Else the password needs to be updated for the User object.
                } else {
                    this.setPassword(entry.getValue());
                }
            }
            // Return true to signify the update has occured.
            return true;
            // The information already exists so the update can not be performed.
        } else {
            return false;
        }
    }

    /**
     * Method that deletes an account based on the username of the current
     * account.
     *
     * @return - True if account was deleted, false if not.
     */
    public boolean deleteAccount() {
        // Create a boolean variable that makes a call to the DataBaseTranslator class to delete the current account.
        boolean deleteUser = translate.deleteObject(this.getUsername(), "users");
        // If object was deleted, set everything equal to null and return to the Login screen.
        if (deleteUser == true) {
            this.setEmail(null);
            this.setUsername(null);
            this.setPassword(null);
            // Object is deleted by garbage collector so return to Log in panel.
            return true;
            // Object was not deleted so return to the Home screen panel with the account information.
        } else {
            return false;
        }
    }

    /**
     * Method that allows user to reactive their account if they accidentally
     * deleted it.
     *
     * @param _email - Email of deactivated account.
     * @param _username - Username of deactivated account.
     * @param _password - Password of Deactivated account.
     * @return - True of account was actived, false if not.
     */
    public boolean reactivateAccount(String _email, String _username, String _password) {
        // Build a hashmap of the information passed in from user.
        HashMap<String, String> map = new HashMap();
        map.put("email", _email);
        map.put("username", _username);
        map.put("password", _password);
        map.put("active", "false");
        // Send information to translator to be checked by Database.
        boolean checkDeactivated = translate.reactivateAccount(map, "users");
        // If account was reactivated the create a new User object with that information and return true.
        if (checkDeactivated == true) {
            return true;
            // Else the account was not reactivated so return false;
        } else {
            return false;
        }
    }

    // =========== SETTERS ============= //
    public void setEmail(String _email) {
        this.email = _email;
    }

    public void setUsername(String _username) {
        this.username = _username;
    }

    public void setPassword(String _password) {
        this.password = _password;
    }

    // ============ GETTERS ============ //
    public String getEmail() {
        return this.email;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
