package DataBase;

import java.util.Map;

/**
 * Class that translates objects into database.
 *
 * @author Dillon. Last updated: November 4, 2019.
 */
public class DataBaseTranslator {
    // Give access to the DataBaseInterface class.
    private static final DataBaseInterface connect = new DataBase();

    /**
     * Method that sends an object and its table to the database to see if the
     * information can be saved as a new object.
     *
     * @param _obj - The information of the new object.
     * @param _table - The table the object will be stored in.
     * @return - Integer returned from DataBase call.
     */
    public int createObject(Map<String, String> _obj, String _table) {
        return DataBaseTranslator.connect.createObject(_obj, _table);
    }

    /**
     * Method that sends information passed in to the Database class to perform desired actions.
     * @param _map - The information the user wants read.
     * @param _table - The table the information is located in.
     * @return - The integer returned from DataBase call.
     */
    public int readObject(Map<String, String> _map, String _table) {
        return DataBaseTranslator.connect.readObject(_map, _table);
    }

    /**
     * Method that sends information passed in from the user to be updated by the database.
     * @param _newInfo - The information the user wants updated.
     * @param _uuid - The uuid of that particular user.
     * @param _table - The table in which the information would be located.
     * @return - Integer returned from DataBase call.
     */
    public boolean updateObject(Map<String, String> _newInfo, String _uuid, String _table) {
        return DataBaseTranslator.connect.updateObject(_newInfo, _uuid, _table);
    }
    
    /**
     * Method that sends the uuid and table name to the database to delete an object.
     * @param _uuid - the uuid of that particular user.
     * @param _table - The table in which the object is located in.
     * @return - Value returned from DataBase call.
     */
    public boolean deleteObject(String _uuid, String _table) {
        return DataBaseTranslator.connect.deleteObject(_uuid, _table);
    }
}
