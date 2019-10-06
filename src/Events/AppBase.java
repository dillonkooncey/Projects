package Events;

import Events.AppEvent;
import Events.ListenerInterface;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that allows for adding listeners, removing listeners, and firing
 * events. This class will be used by classes that need to use these events for GUI actions.
 * @author Dillon, Amina, Kumar. Last updated: September 29, 2019.
 */
public class AppBase implements ListenerInterface {
    // Creating a list of all the classes listening for events.
    private final List listeners = new ArrayList();
    // A synchronized method that adds a listener to the List listeners.
    public synchronized void addListener(ListenerInterface listener) {
        listeners.add(listener);
    }
    // A synchronized method that removes a listener from the List listeners.
    public synchronized void removeListener(ListenerInterface listener) {
        listeners.remove(listener);
    }
    // A synchronized method that fire events based on actions passed into them.
    protected synchronized void fireEvent(AppEvent event) {
        // Clone the active listeners.
        Object[] temp_list = this.listeners.toArray();
        for (Object temp_list1 : temp_list) {
            ListenerInterface temp_obj = (ListenerInterface) temp_list1;
            // Sends the event to objects listening for.
            temp_obj.messageRecieved(event);
        }
    }

    /**
     * Message received event that prints the the console that the event passed in does not effect this class.
     * @param _event - Newly fired event based on UI actions.
     */
    @Override
    public void messageRecieved(AppEvent _event) {
        System.out.println("This module does not act on messages.");
    }
}
