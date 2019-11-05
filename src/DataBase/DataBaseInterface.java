/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.util.Map;

/**
 * Interface for database class.
 * @author Dillon. Last updated October 10, 2019.
 */
public interface DataBaseInterface {
    public abstract int createObject(Map<String,String> _attributes, String _table);

    public abstract int readObject(Map<String,String> _keyValuePairs, String _table);

    public abstract boolean updateObject(Map<String,String> _keyValuePairs, String _uuid, String _table);

    public abstract boolean deleteObject(String uuid, String _table);   
}
