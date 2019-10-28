package Events;

/**
 * Class that defines the possible messages given by events from the user.
 *
 * @author Dillon, Amina, Kumar. Last updated: October 6, 2019.
 */
public class AppMessage {

    // Creating messages for object classes to use in overridden getMessage() from listenerInterface.
    public static final int LOG_IN_PANEL = 1;
    public static final int REGISTRATION_PANEL = 2;
    public static final int HOME_SCREEN_PANEL = 3;
    public static final int EXIT_PANEL = 4;
    public static final int ALL_MOVIES_PANEL = 5;
    public static final int MOVIE_GENRE_PANEL = 6;
    public static final int MOVIE_RATING_PANEL = 7;
    public static final int MOVIE_ACTORS_PANEL = 8;
    public static final int OPTIONS_PANEL = 9;

    // Create integer to be assigned to message value passed into constructor.
    private final int thisMessage;

    /**
     * Constructor for AppMessage class.
     *
     * @param _message - Passed in by
     */
    public AppMessage(int _message) {
        this.thisMessage = _message;
    }

    /**
     * Method to give the code passed into the AppMessage class.
     *
     * @return - Returns code of message to then perform an instruction in
     * getMessage() in other classes implementing ListenerInterface.
     */
    public int getMessageCode() {
        return this.thisMessage;
    }
}
