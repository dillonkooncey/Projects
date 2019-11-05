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
    private String active;
    // Give User access to DataBaseTranslator class.
    private DataBaseTranslator translate;

    // Constuctor to construct new User object.
    public User(String _email, String _username, String _password) {
        this.email = _email;
        this.username = _username;
        this.password = _password;
        this.active = "true";
    }

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
