package UserModels;

import GUI.DataBase;

/**
 * USer class that defines user attributes and methods defining what users can
 * do.
 *
 * @author Dillon, Amina, Kumar. Last updated: October 6, 2019.
 */
public class User {

    private String email;
    private String username;
    private String password;

    private DataBase db;

    public User(String _email, String _username, String _password) {
        this.email = _email;
        this.username = _username;
        this.password = _password;
    }

    /**
     * Method that will search and display all movies.
     */
    private void searchMovies() {
        // Will be implemented by External API.
    }

    /**
     * Method that will search movies by genre entered in by user.
     *
     * @param _genre - Genre wanted to be searched by user.
     */
    private void searchMovieGenre(String _genre) {
        // Will be implemented by External API.
    }

    /**
     * Method that will search for movies based on certain actor.
     *
     * @param _actorName
     */
    private void searchMovieActors(String _actorName) {
        // Will be implemented by External API.
    }

    /**
     * Method that will search movies by rating.
     *
     * @param _rating - The desired rating entered by user.
     */
    private void searchMovieRating(double _rating) {
        // Will be implemented by External API.
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
        db.changeEmail(_email, this.getEmail());
    }

    /**
     * Method that will change the users username.
     *
     * @param _username - The new user name.
     */
    private void changeUsername(String _username) {
        db.changeUsername(_username, this.getUsername());
    }

    /**
     * Method that will change the users password.
     *
     * @param _password - The users new password.
     */
    private void changePassword(String _password) {
        db.changePassword(_password, this.getUsername(), this.getPassword());
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
