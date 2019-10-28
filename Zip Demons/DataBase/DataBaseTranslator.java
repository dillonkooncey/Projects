package DataBase;

import java.util.Map;

/**
 * Class that translates objects into database.
 *
 * @author Dillon. Last updated: October 25, 2019.
 */
public class DataBaseTranslator {

    private static final DataBaseInterface connect = new DataBase();

    /**
     * Method that sends an object and its table to the database to see if the
     * information can be saved as a new object.
     *
     * @param _obj - The information of the new object.
     * @param _table - The table the object will be stored in.
     * @return - A newly constructed object or null if the object was not
     * created.
     */
    public static boolean createObject(Map<String, String> _obj, String _table) {
       return true;
    }
}
