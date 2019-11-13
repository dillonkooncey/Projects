package UserModels;

import DataBase.DataBaseTranslator;
import Events.AppMessage;
import java.util.HashMap;

/**
 * User class that defines user attributes and methods defining what users can
 * do.
 *
 * @author Dillon, Amina, Kumar. Last updated: October 6, 2019.
 */
public class User {

    // Data fields for User class.
    private String email;
    private String username;
    private String password;
    private final String active;
    // Give User access to DataBaseTranslator class.
    private DataBaseTranslator translate;

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
        /*
        If 1 is returned from the DataBaseTranslator class then the object 
        exists so create a new User object with the attributes passed in from 
        the GUI and return the int of the home screen panel.
         */
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
        /*
        If the information entered does not match with an existing user in the database
        create a new User object with the passed in information and return the int 
        of the homescreen panel.
         */
        if (checkDb == 1) {
            User user = new User(_email, _username, _password);
            return AppMessage.HOME_SCREEN_PANEL;
            // Else a user already existed with this information so return the int of the registration panel.
        } else {
            return AppMessage.REGISTRATION_PANEL;
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

            return AppMessage.LOG_IN_PANEL;
            // Object was not deleted so return to the Home screen panel with your account information.
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
