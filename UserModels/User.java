package UserModels;

import DataBase.DataBaseTranslator;
import Events.AppMessage;
import java.util.HashMap;

/**
 * User class that defines user attributes and methods defining what users can
 * do.
 *
 * @author Dillon. Last updated: November 18, 2019.
 */
public class User {

    // Data fields for User class.
    private String email;
    private String username;
    private String password;
    private String active = "true";
    // Give User access to DataBaseTranslator class.
    private final DataBaseTranslator translate = new DataBaseTranslator();

    // Constuctor to construct new User object.
    public User(String _email, String _username, String _password) {
        this.email = _email;
        this.username = _username;
        this.password = _password;
        this.active = "true";
    }

    /**
     * Method that checks to see if an object is in the database. If so it saves
     * the information passed in as a new object and returns a AppMessage int.
     * If not it returns a different AppMessage int.
     *
     * @param _email - Email passed in from login
     * @param _username - Username passed in from login
     * @param _password - Password passed in from login.
     * @return - return AppMessage int based on whether or not object was found
     * and saved.
     */
    public int save(String _email, String _username, String _password) {
        // Create a HashMap and populate it with the information passed in from GUI and the string indicating what it is.
        HashMap<String, String> map = new HashMap();
        map.put("email", _email);
        map.put("username", _username);
        map.put("password", _password);
        map.put("active", this.active);
        // Int that equals the result of the DataBaseTranslator call.
        int checkDb = this.translate.readObject(map, "users");
        // Check and see if user does not exist then create a new one. Else dont.
        if (checkDb == 1) {
            User user = new User(_email, _username, _password);
            return AppMessage.HOME_SCREEN_PANEL;
            // Else the object didnt exist so return the int of the log in panel.
        } else {
            return AppMessage.LOG_IN_PANEL;
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
     * @return - AppMessage int corresponding to panel routed to.
     */
    public int createUser(String _email, String _username, String _password) {
        // Create HashMap and populate it with the information passed in from GUI and the string indicating what it is.
        HashMap<String, String> map = new HashMap();
        map.put("email", _email);
        map.put("username", _username);
        map.put("password", _password);
        // Int that equals the result of the DataBaseTranslator method call.
        int checkDb = this.translate.createObject(map, "users");
        // If checkDb = 1, a new User object has been created in the database so create a new User object and route to homescreen panel.
        if (checkDb == 1) {
            User user = new User(_email, _username, _password);
            return AppMessage.HOME_SCREEN_PANEL;
            // Else a user already existed with this information so return the int of the registration panel.
        } else {
            return AppMessage.REGISTRATION_PANEL;
        }

    }

    /**
     * Method that takes in the attribute the user wants changed and the value.
     * Then checks the DataBase to see if the new value desired is already in
     * the database or not. If not then the attribute is changed. If so the
     * request is denied.
     *
     * @param _attribute - The attribute the User wants changed.
     * @param _value - The value of the new attribute
     * @return - Int indicating whether or not the information was changed or
     * not.
     */
    public int updateInfo(String _attribute, String _value) {
        // Create HashMap object with the attribute as the key and the value as the value.
        HashMap<String, String> map = new HashMap();
        map.put(_attribute, _value);
        // Boolean indicating true if change was made or false if not.
        boolean checkDb = this.translate.updateObject(map, this.getUsername(), "users");
        // If statement for handling true or false from the database.
        if (checkDb == true) {
            // How will i know what part of the User object here?
            return AppMessage.HOME_SCREEN_PANEL;
            // The information already exists so the update can not be performed.
        } else {
            return 0;
        }
    }

    /**
     * Method that deletes an account based on the username of the current
     * account.
     *
     * @return - AppMessage int based on outcome of the DataBaseTranslator call.
     */
    public int deleteAccount() {
        // Create a boolean variable that makes a call to the DataBaseTranslator class to delete the current account.
        boolean deleteUser = this.translate.deleteObject(this.getUsername(), "users");
        // If object was deleted, set everything equal to null and return to the Login screen.
        if (deleteUser == true) {
            this.setEmail(null);
            this.setUsername(null);
            this.setPassword(null);
            // Object is deleted by garbage collector so return to Log in panel.
            return AppMessage.LOG_IN_PANEL;
            // Object was not deleted so return to the Home screen panel with the account information.
        } else {
            return AppMessage.HOME_SCREEN_PANEL;
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
