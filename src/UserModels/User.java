package UserModels;

import DataBase.DataBaseTranslator;
import Events.AppBase;
import Events.AppMessage;
import java.util.HashMap;
import java.util.UUID;

/**
 * User class that defines user attributes and methods defining what users can
 * do.
 *
 * @author Dillon. Last updated: October 31, 2019.
 */
public class User extends AppBase{

    // Data fields for User class.
    private String email;
    private String username;
    private String password;
    private boolean active = true;
    // Give access to DataBasetranslator class.
    public DataBaseTranslator dbTranslate;
    
    public User() {}

    // Constuctor to construct new User object.
    public User(String _email, String _username, String _password) {
        this.email = _email;
        this.username = _username;
        this.password = _password;
        this.active = true;
    }

    /**
     * Method that sends information to the DataBaseTranslator class to see if
     * the information entered can create a new object or not.
     *
     * @param _email - the email the user has chosen.
     * @param _username - The username the user has chosen.
     * @param _password - The password the user has chosen.
     * @return - The int of the homescreen panel if the object was created or
     * the int of the registration panel if the object was not created.
     */
    public int create(String _email, String _username, String _password) {
        // Create a new HashMap object and populate it with a random uuid and the information passed in from the user.
        HashMap<String, String> map = new HashMap();
        map.put("uuid", this.makeUUID());
        map.put("email", _email);
        map.put("username", _username);
        map.put("password", _password);
        // Send the information to the DataBaseTranslator class to create the new object.
        int createObj = this.dbTranslate.createObject(map, "users");
        // If the object was created, send the GUI to the homescreen panel.
        if (createObj == 1) {
            // Create a new User object with the information passed in from the user.
            User newUser = new User(_email, _username, _password);
            return AppMessage.HOME_SCREEN_PANEL;
            // Else the object was not created so route the GUI back to the registration menu.
        } else {
            return AppMessage.REGISTRATION_PANEL;
        }
    }

    /**
     * Method that saves the user object based on whether or not the passed in
     * information exists in the database.
     *
     * @param _email - The email entered by the user in the log in screen.
     * @param _username - The username entered by the user in the log in screen.
     * @param _password - The password entered by the user in the log in panel.
     * @return - Return the int of the home screen panel if the information was
     * saved and the int of the log in panel if the information was not saved.
     */
    public int save(String _email, String _username, String _password) {
        // Create a new HashMap object and populate it with the information passed in from the user.
        HashMap<String, String> map = new HashMap();
        map.put("email", _email);
        map.put("username", _username);
        map.put("password", _password);
        // Send the HashMap and the table name to the DataBaseTranslator class to see if the information exists in the DataBase.
        int saveObj = this.dbTranslate.readObject(map, "users");
        // If the information exists, create a new User object and send the GUI to the home screen menu.
        if (saveObj == 1) {
            User newUser = new User(_email, _username, _password);
            return AppMessage.HOME_SCREEN_PANEL;
            // Else the information was not found so route the GUI back to the log in menu.
        } else {
            return AppMessage.LOG_IN_PANEL;
        }
    }

    /**
     * Method that creates a uuid for new User object.
     *
     * @return - String uuid.
     */
    private String makeUUID() {
        return UUID.randomUUID().toString();
    }

    // ================ SETTERS ================== //
    public void setEmail(String _email) {
        this.email = _email;
    }

    public void setUsername(String _username) {
        this.username = _username;
    }

    public void setPassword(String _password) {
        this.password = _password;
    }

    public void setActive(boolean _active) {
        this.active = _active;
    }

    // ================= GETTERS ================= //
    public String getEmail() {
        return this.email;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean getActive() {
        return this.active;
    }
}
