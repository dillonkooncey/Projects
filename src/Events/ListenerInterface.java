package Events;

/**
 *
 * @author Owner
 */
public interface ListenerInterface {
    /**
     * Method that will be overridden by classes that listen for instructions.
     * @param _event 
     */
    public void messageRecieved(AppEvent _event);
}
