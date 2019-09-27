package Models;

import Events.AppEvent;
import Events.ListenerInterface;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that allows for adding listeners, removing listeners, and firing
 * events. This class will be used by classes that need to fire events from the
 * user like the AppGui class.
 * @author Owner
 */
public class AppBase implements ListenerInterface {

    private final List listeners = new ArrayList();

    public synchronized void addListener(ListenerInterface listener) {
        listeners.add(listener);
    }

    public synchronized void removeListener(ListenerInterface listener) {
        listeners.remove(listener);
    }

    protected synchronized void fireEvent(AppEvent event) {
        // Clone the active listeners.
        Object[] temp_list = this.listeners.toArray();
        for (Object temp_list1 : temp_list) {
            ListenerInterface temp_obj = (ListenerInterface) temp_list1;
            temp_obj.messageRecieved(event);
        }
    }

    @Override
    public void messageRecieved(AppEvent _event) {
        System.out.println("This module does not receive messages.");
    }
}
