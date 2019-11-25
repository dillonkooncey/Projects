package UserModels;

import Events.AppMessage;

/**
 * Class that acts as a controller for getting information to and from the view
 * to the models.
 * @author Dillon. November 25, 2019.
 */
public class ModelController {
    /**
     * Method that sends the entered log in information from the view to the model
     * check and see if an account exists in the database.
     * @param _email - email passed in from user in view.
     * @param _username - username passed in from user in view.
     * @param _password - password passed in from user in view.
     * @return - The int of the panel to be routed to.
     */
    public static int verifyUser(String _email, String _username, String _password) {
        // Boolean sending information to User class to see if account exists.
        boolean fetchVerification = User.validateUser(_email, _username, _password);
        // If account was verified go to home screen.
        if(fetchVerification == true) {
            return AppMessage.HOME_SCREEN_PANEL;
        // Else go back to Log in screen to re-enter information.
        } else {
            return AppMessage.LOG_IN_PANEL;
        }
    }
    
    /**
     * Method that sends information to the User class which will then check the 
     * database to see if the information provided can create a new user.
     * @param _email - Email passed in from user.
     * @param _username - Username passed in from User.
     * @param _password - Username passed in from User.
     * @return - The int of the panel routed to.
     */
    public static int createUser(String _email, String _username, String _password) {
        // Boolean sending information to User class to see if account can be created.
        boolean checkAccount = User.createUser(_email, _username, _password);
        // If account was created go to home screen. Else go back to registration screen.
        if(checkAccount == true) {
            return AppMessage.HOME_SCREEN_PANEL;
        } else {
            return AppMessage.REGISTRATION_PANEL;
        }
    }
    
    /**
     * Method that sends movie name string to the Movie class to find its rating.
     * @param _movieName - Name of the movie searched.
     * @return - The int of the movie rating panel.
     */
    public static int findMovieRating(String _movieName) {
        double findRating = Movie.findMovieRating(_movieName);
        return AppMessage.MOVIE_RATING_PANEL;
    }
    
    public static int findMovieList(String _actorName) {
        boolean findList = Actor.findMovieList(_actorName);
        return AppMessage.ACTORS_PANEL;
    }
}
