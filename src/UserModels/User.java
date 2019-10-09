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
    // DataBase object to give access to DataBase class.
    private DataBase db;

    // Constuctor to construct new User object.
    public User(String _email, String _username, String _password) {
        this.email = _email;
        this.username = _username;
        this.password = _password;
    }

    /**
     * Method that allows user to delete their account.
     */
    private void deleteAccount() {
        this.db.removeUser(this.getEmail(), this.getUsername(), this.getPassword());
    }

    /**
     * Method that allows user to change their email.
     *
     * @param _email - New email for user.
     */
    private void changeEmail(String _email) {
        Boolean check = db.changeEmail(_email, this.getEmail());
        if (check = true) {
            this.setEmail(_email);
        } else {
            System.out.println("Email is taken choose another email.");
        }
    }

    /**
     * Method that will change the users username.
     *
     * @param _username - The new user name.
     */
    private void changeUsername(String _username) {
        Boolean check = db.changeUsername(_username, this.getUsername());
        if (check = true) {
            this.setUsername(_username);
        } else {
            System.out.println("Username is taken choose another username.");
        }
    }

    /**
     * Method that will change the users password.
     *
     * @param _password - The users new password.
     */
    private void changePassword(String _password) {
        Boolean check = db.changePassword(_password, this.getUsername(), this.getPassword());
        if (check = true) {
            this.setPassword(_password);
        } else {
            System.out.println("Something went wrong try again.");
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
