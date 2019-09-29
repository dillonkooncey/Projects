package Events;

import java.util.EventObject;

/**
 * Class that recognizes events taken in from other classes and creates new events
 * and acts based on what the event is supposed to do.
 * @author Dillon, Amina, Kumar. Last updated: September 29, 2019.
 */
public class AppEvent extends EventObject{
    // Take in a message from the AppMessage class that will later be used in a method to display this message.
    private final AppMessage message;
    
    /**
     * Constructor that takes in new AppEvents from other classes.
     * @param _source - Takes in the name of the Object class the message came from.
     * @param _message - Takes in the desired message from the event passed in.
     */
    public AppEvent(Object _source, AppMessage _message) {
        super(_source);
        this.message = _message;
    }
    
    /**
     * Gets the desired message from the event.
     * @return  - Returns the message given from the event.
     */
    public AppMessage getMessage() {
        return this.message;
    }
    
    
    
}
