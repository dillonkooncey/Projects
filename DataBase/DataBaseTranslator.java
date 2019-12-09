package DataBase;

import java.util.Map;

/**
 * Class that translates objects into database.
 *
 * @author Dillon. Last updated: December 1, 2019.
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
    public boolean createObject(Map<String, String> _obj, String _table) {
        return DataBaseTranslator.connect.createObject(_obj, _table);
    }

    /**
     * Method that sends information passed in to the Database class to perform
     * desired actions.
     *
     * @param _map - The information the user wants read.
     * @param _table - The table the information is located in.
     * @return - The integer returned from DataBase call.
     */
    public boolean readObject(Map<String, String> _map, String _table) {
        return DataBaseTranslator.connect.readObject(_map, _table);
    }

    /**
     * Method that sends information passed in from the user to be updated by
     * the database.
     *
     * @param _newInfo - The information the user wants updated.
     * @param _username - The username of that particular user.
     * @param _table - The table in which the information would be located.
     * @return - Integer returned from DataBase call.
     */
    public boolean updateObject(Map<String, String> _newInfo, String _username, String _table) {
        return DataBaseTranslator.connect.updateObject(_newInfo, _username, _table);
    }

    /**
     * Method that sends the username and table name to the database to delete
     * an object.
     *
     * @param _map - HashMap of user information.
     * @param _table - The table in which the object is located in.
     * @return - Value returned from DataBase call.
     */
    public boolean deleteObject(Map<String, String> _map, String _table) {
        return DataBaseTranslator.connect.deleteObject(_map, _table);
    }

    /**
     * Method that sends informaiton from User class to Database to see if
     * account can be reactivated.
     *
     * @param _map - HashMap of information to be searched through.
     * @param _table - Name of Table to be searched.
     * @return - True if account was reactivated, false if not.
     */
    public boolean reactivateAccount(Map<String, String> _map, String _table) {
        return DataBaseTranslator.connect.reactivateAccount(_map, _table);
    }
}
