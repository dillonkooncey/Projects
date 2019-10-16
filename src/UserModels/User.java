package UserModels;

import DataBase.DataBase;

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
    private String uuid;
    private boolean active;
    // DataBase object to give access to DataBase class.
    private DataBase db;

    // Constuctor to construct new User object.
    public User(String _uuid, String _email, String _username, String _password, boolean _active) {
        this.uuid = _uuid;
        this.email = _email;
        this.username = _username;
        this.password = _password;
        this.active = _active;
    }

    /**
     * Method that allows user to delete their account.
     */
    private void deleteAccount() {
        
    }

    /**
     * Method that allows user to change their email.
     *
     * @param _email - New email for user.
     */
    private void changeEmail(String _email) {
    }

    /**
     * Method that will change the users username.
     *
     * @param _username - The new user name.
     */
    private void changeUsername(String _username) {
    }

    /**
     * Method that will change the users password.
     *
     * @param _password - The users new password.
     */
    private void changePassword(String _password) {
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
