package Events;

/**
 * Interface that creates a messageRecieved() for other classes to user based on their needs.
 * @author Dillon, Amina, Kumar. Last updated: September 29, 2019.
 */
public interface ListenerInterface {
    /**
     * Method that will be overridden by classes that listen for instructions and act upon them.
     * @param _event - Event passed in from other classes.
     */
    public void messageRecieved(AppEvent _event);
}
