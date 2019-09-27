package Events;

import java.util.EventObject;

/**
 *
 * @author Owner
 */
public class AppEvent extends EventObject{
    // Take in a message from the AppMessage class that will later be used in a method to display this message.
    private final AppMessage message;
    
    /**
     * 
     * @param _source - Takes in the name of the Object class the message came from.
     * @param _message - Takes in the message from AppMessage class.
     */
    public AppEvent(Object _source, AppMessage _message) {
        super(_source);
        this.message = _message;
    }
    
    /**
     * Displays the message from the original object class in which the message came from.
     * @return  - Returns the message given from the original message from the object class.
     */
    public AppMessage getMessage() {
        return this.message;
    }
    
    
    
}
