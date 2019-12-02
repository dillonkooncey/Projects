package DataBase;

import java.util.Map;

/**
 * Interface for database class.
 *
 * @author Dillon. Last updated December 1, 2019.
 */
public interface DataBaseInterface {

    public abstract boolean createObject(Map<String, String> _attributes, String _table);

    public abstract boolean readObject(Map<String, String> _keyValuePairs, String _table);

    public abstract boolean updateObject(Map<String, String> _keyValuePairs, String _username, String _table);

    public abstract boolean deleteObject(String _username, String _table);
    
    public abstract boolean reactivateAccount(Map<String,String> _map, String _table);
}
