package UserModels;

import DataBase.DataBaseTranslator;
import java.util.HashMap;
import java.util.UUID;

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
    private boolean active = true;
    // Give access to DataBasetranslator class.
    public DataBaseTranslator dbTranslate;

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
     * @return - True if the object was created or false if not.
     */
    public boolean create() {
        HashMap<String, String> map = new HashMap();
        map.put("uuid", this.makeUUID());
        map.put("email", this.getEmail());
        map.put("username", this.getUsername());
        map.put("password", this.getPassword());

        return true;
    }

    public boolean save() {
        HashMap<String, String> map = new HashMap();
        map.put("uuid", this.makeUUID());
        map.put("email", this.getEmail());
        map.put("username", this.getUsername());
        map.put("password", this.getPassword());
        
        
        return true;
    }
    
    
    
    private String makeUUID() {
        return UUID.randomUUID().toString();
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

    public void setActive(boolean _active) {
        this.active = _active;
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

    public boolean getActive() {
        return this.active;
    }
}
