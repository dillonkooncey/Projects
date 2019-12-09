package UserModels;

import Events.AppMessage;
import java.util.ArrayList;

/**
 * Class that acts as a controller for getting information to and from the view
 * to the models.
 *
 * @author Dillon. December 1, 2019.
 */
public class ModelController {

    // Give access to models to fetch information.
    private User user = new User();
    private Actor actor = new Actor();
    private Movie movie = new Movie();

    // Constructor for ModelController class.
    public ModelController() {

    }

    // ========= User class fetches ========= //
    /**
     * Method that sends the entered log in information from the view to the
     * model check and see if an account exists in the database.
     *
     * @param _email - email passed in from user in view.
     * @param _username - username passed in from user in view.
     * @param _password - password passed in from user in view.
     * @return - The integer of the panel to be routed to.
     */
    public int verifyUser(String _email, String _username, String _password) {
        // Boolean sending information to User class to see if account exists.
        boolean fetchVerification = User.validateUser(_email, _username, _password);
        // If account was verified go to home screen.
        if (fetchVerification == true) {
            this.user = new User(_email, _username, _password);
            return AppMessage.HOME_SCREEN_PANEL;
            // Else go back to Log in screen to re-enter information.
        } else {
            return AppMessage.LOG_IN_PANEL;
        }
    }

    /**
     * Method that sends information to the User class which will then check the
     * database to see if the information provided can create a new user.
     *
     * @param _email - Email passed in from user.
     * @param _username - Username passed in from User.
     * @param _password - Username passed in from User.
     * @return - The integer of the panel routed to.
     */
    public int createUser(String _email, String _username, String _password) {
        // Boolean sending information to User class to see if account can be created.
        boolean checkAccount = this.user.createUser(_email, _username, _password);
        // If account was created go to home screen. Else go back to registration screen.
        if (checkAccount == true) {
            this.user = new User(_email, _username, _password);
            return AppMessage.HOME_SCREEN_PANEL;
        } else {
            return AppMessage.REGISTRATION_PANEL;
        }
    }

    /**
     * Method that will search send information to the User class to see if a
     * User's information can be updated.
     *
     * @param _email - Email String.
     * @param _username - Username String.
     * @param _password - Password String.
     * @return - The integer based on whether or not the update was successful.
     */
    public int updateUser(String _email, String _username, String _password) {
        // Send information to models to see if update was made.
        boolean checkUpdate = this.user.updateInfo(_email, _username, _password);
        // If update was made route to home screen if not go back to options panel to re-enter information.
        if (checkUpdate == true) {
            this.user = new User(_email, _username, _password);
            return AppMessage.HOME_SCREEN_PANEL;
        } else {
            return AppMessage.OPTIONS_PANEL;
        }
    }

    /**
     * Method that tells the User class to delete the current User's account and
     * routes User to log in if delete occurred and home screen if not.
     *
     * @return - Integer of panel routed to.
     */
    public int deleteUser() {
        // Tell User class to delete account.
        boolean deleteAccount = this.user.deleteAccount();
        // If account was deleted route to log in screen and home screen if not.
        if (deleteAccount == true) {
            this.user = new User();
            return AppMessage.LOG_IN_PANEL;
        } else {
            return AppMessage.HOME_SCREEN_PANEL;
        }
    }

    /**
     * Method that send information from user to User class to see if their
     * account can be activated.
     *
     * @param _email - Email entered by user.
     * @param _username - Username entered by user.
     * @param _password - Password entered by user.
     * @return - Integer of panel routed to.
     */
    public int reactivateUser(String _email, String _username, String _password) {
        // Send to User class to check if account can be reactiveated.
        boolean checkDeactivated = this.user.reactivateAccount(_email, _username, _password);
        // If account was reactivated go to home screen, if not go back to account recovery.
        if (checkDeactivated == true) {
            this.user = new User(_email, _username, _password);
            return AppMessage.HOME_SCREEN_PANEL;
        } else {
            return AppMessage.ACCOUNT_RECOVERY;
        }
    }

    /**
     * Method that returns the email from getEmail() of the User class.
     *
     * @return - Email of User.
     */
    public String getUserEmail() {
        return this.user.getEmail();
    }

    /**
     * Method that returns the username from getUsername() of the User class.
     *
     * @return - Username of User.
     */
    public String getUserUsername() {
        return this.user.getUsername();
    }

    /**
     * Method that returns the password from getPassword() of the User class.
     *
     * @return - Password of User.
     */
    public String getUserPassword() {
        return this.user.getPassword();
    }

    // ======= Movie class fetches ====== //
    /**
     * Method that sends movie name string to the Movie class to find its
     * rating.
     *
     * @param _movieName - Name of the movie searched.
     * @return - The integer of the movie rating panel.
     */
    public int findMovieRating(String _movieName) {
        this.movie = new Movie();
        double findRating = this.movie.findMovieRating(_movieName);
        this.movie = new Movie(findRating, _movieName);
        return AppMessage.MOVIE_RATING_PANEL;
    }

    /**
     * Method to get the name of the movie searched from user.
     *
     * @return - Name of the movie searched.
     */
    public String getMovieName() {
        return this.movie.getMovieName();
    }

    /**
     * Method that converts the rating of the searched movie to a string and
     * returns it.
     *
     * @return - The movie rating of the searched movie.
     */
    public String getMovieRating() {
        return String.valueOf(this.movie.getRating());
    }

    // ====== Actor Class fetches ====== //
    /**
     * Method that sends the Actor name to the Actor class to find a list of
     * movies that actor has acted in.
     *
     * @param _actorName - Name of the actor searched by the User.
     * @return - The integer of the actors panel.
     */
    public int findMovieList(String _actorName) {
        this.actor = new Actor();
        ArrayList<String> findList = this.actor.findMovieList(_actorName);
        this.actor = new Actor(findList, _actorName);
        return AppMessage.ACTORS_PANEL;
    }

    /**
     * Method that returns the name of the actor searched from the Actor Class.
     *
     * @return - Name of the searched Actor.
     */
    public String getActorName() {
        return this.actor.getActorName();
    }

    /**
     * Method that returns the ArrayList of movies from the Actor class of
     * movies the searched actor has acted in.
     *
     * @return - The list of movies the actor has acted in.
     */
    public ArrayList<String> getActorMovieList() {
        return this.actor.getMovies();
    }

    /**
     * Method that will call the Actor class to sort the list of movies in
     * ascending order for the user.
     *
     * @return - The list of movies in ascending order.
     */
    public ArrayList<String> sortAscendingOrder() {
        this.actor.sortAscendingOrder();
        return this.actor.getMovies();
    }

    /**
     * Method that will call the Actor class to sort the list of movies in
     * descending order for the user.
     *
     * @return - The list of movies in descending order.
     */
    public ArrayList<String> sortDescendingOrder() {
        this.actor.sortDescendingOrder();
        return this.actor.getMovies();
    }
}
