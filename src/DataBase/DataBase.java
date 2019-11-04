package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * Database class to create, read, update, and delete objects.
 *
 * @author Dillon. Last updated October 23, 2019.
 */
public class DataBase implements DataBaseInterface {

    // Data fields for DataBase class.
    private final String host = "jdbc:derby://localhost:1527/dillonkooncey";
    private final String userName = "dckoonce";
    private final String passWord = "November21998";
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pst;
    private Statement stmt;

    // Constructor that connects to the database.
    public DataBase() {
        this.connect();
    }

    /**
     * Method that creates a new object and saves it to the database. First, it
     * checks to see if the information already exists in the database. If not
     * it adds the new information to the database. If so it returns 0 meaning
     * the object was not created.
     *
     * @param _attributes - The attributes of the new object.
     * @param _table - The table that will be checked and where the object will
     * be added.
     * @return - 1 if the object was created and 0 if not.
     */
    @Override
    public int createObject(Map<String, String> _attributes, String _table) {
        /*
        first check to see if the information exists in the database.
        If not, create the new object and return 1 indicating the object was created.
        If so, return 0 indicating the object couldnt be created.
         */
        int recordSearch = this.checkRecords(_attributes, _table);
        // If to insert into table.
        if (recordSearch == 0) {
            // Strings to create the SQL statement.
            String table = "INSERT INTO " + _table;
            String column = "(";
            String values = "VALUES (";
            // Looping through the Hashmap to find the columns needed to be searched in the table and the values in those columns.
            for (Map.Entry<String, String> entry : _attributes.entrySet()) {
                column += "" + entry.getKey() + " , ";
                values += " '" + entry.getValue() + "', ";
            }
            // Removing the last comma in each of the statements from the for loop.
            column = column.substring(0, column.length() - 2);
            values = values.substring(0, values.length() - 2);
            // Add the last parenthesis for the SQL statement.
            column += ")";
            values += ")";
            // Creating the SQl by combining the previous strings together.
            String SQL = table + column + values;
            // Creating an integer that will represent how many object with the entered attributes exist in the database.
            this.executeChange(SQL);
            System.out.println("Object added to " + _table + " table");
            return 1;
            // Object already exists and was not added to table.
        } else {
            System.out.println("Object already exists in the " + _table + " table");
            return 0;
        }
    }

    /**
     * Method that reads an object from the database and returns it.
     *
     * @param _obj - The values of the object passed in to see if it exists.
     * @param _table - The table where the object is located.
     * @return - Return the object and its attributes.
     */
    @Override
    public int readObject(Map<String, String> _obj, String _table) {
        // Send the passed in info to method to be checked if it exists in passed in table.
        int checked = this.checkRecords(_obj, _table);
        // If there exists a name in database with this information return true indicating the information exists.
        if (checked == 1) {
            System.out.println("Object exists in database.");
            return 1;
            // Else the information did not exist so return false.
        } else {
            System.out.println("Object does not exist in database.");
            return 0;
        }
    }

    /**
     * Method that updates an object in a database based on passed in arguments.
     *
     * @param _newInfo - Key(what object wants changed) and value(the value of
     * the change)
     * @param _uuid
     * @param _table - The table this object is stored in.
     * @return - True if the update was successful or false if not.
     */
    @Override
    public boolean updateObject(Map<String, String> _newInfo, String _uuid, String _table) {
        // First check to see if the desired information is already entered into 
        int checked = this.checkUpdate(_newInfo, _table);
        // If no object in the database exists with this information, change the info of the uuid.
        if (checked == 0) {
            // Create the strings for the SQL String later.
            String table = "UPDATE " + _table + " SET ";
            String values = "";
            // Iterate through the HahsMap to prepare the SQL string.
            for (Map.Entry<String, String> _map : _newInfo.entrySet()) {
                values += "" + _map.getKey() + " = '" + _map.getValue() + "', and ";
            }
            // Trim off the last , and.
            values = values.substring(0, values.length() - 6);
            // Create the string for the SQL update
            String SQL = table + values + " WHERE uuid = '" + _uuid + "'";
            // Perform the SQL update.
            this.executeChange(SQL);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method that deactivates an account based on a uuid of the account.
     *
     * @param _uuid - The uuid of the account in the database.
     * @param _table - The table the object is located in.
     * @return - True if the account was deleted or false if not.
     */
    @Override
    public Boolean deleteObject(String _uuid, String _table) {
        // Delete object from database at passed in uuid location.
            String SQL = "update " + _table + " set active = 'false' where uuid = '" + _uuid + "'";
            this.executeChange(SQL);
            System.out.println("Object was deleted from database.");
        return true;
    }

    /**
     * Method that checks if a object exists in the database.
     *
     * @param _obj - The attributes of the object.
     * @param _table - The table to be searched.
     * @return - Return 0 if no records exists or 1 if there does.
     */
    private int checkRecords(Map<String, String> _obj, String _table) {
        String table = "SELECT * FROM " + _table;
        String values = " WHERE ";

        for (Map.Entry<String, String> _map : _obj.entrySet()) {
            values += "" + _map.getKey() + " = '" + _map.getValue() + "' and ";
        }
        values = values.substring(0, values.length() - 5);
        String SQL = table + values;
        System.out.println(SQL);
        try {
            // Prepared statement with the SQL string.
            this.pst = this.con.prepareStatement(SQL);
            // Create a result set with the SQL search.
            this.rs = this.pst.executeQuery();
            // If a record exists with this information return 1 indicating 1 object
            if (this.rs.next()) {
                return 1;
                // Else return 0 indicating 0 objects have this data.
            } else {
                return 0;
            }

        } catch (SQLException e) {
            System.out.println("There was an error: " + e.getMessage());
        }
        return 0;
    }

    /**
     * Method that checks to see if an update is valid or not.
     *
     * @return - Return int based on whether you can update or not.
     */
    private int checkUpdate(Map<String, String> _obj, String _table) {
        // Create strings that will help create the SQL statement.
        String table = "SELECT * FROM " + _table;
        String values = " WHERE ";
        //loop though hashmap to help create SQL statement. 
        for (Map.Entry<String, String> _map : _obj.entrySet()) {
            values += "" + _map.getKey() + " = '" + _map.getValue() + "' or ";
        }
        // Remove trailing or from values String.
        values = values.substring(0, values.length() - 4);
        // Create SQL statement by concatenating previously created strings.
        String SQL = table + values;
        // Execute the SQl statement.
        try {
            this.pst = this.con.prepareStatement(SQL);
            // Create a result set with the SQL search.
            this.rs = this.pst.executeQuery();
            // If an object in the database exists with this information return 1 indicating
            // at least one object exists with this information.
            if (this.rs.next()) {
                return 1;
            // Else 0 objects have this information.
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("There was an error: " + e.getMessage());
        }
        return 1;
    }

    /**
     * Method that runs the insert query passed into it.
     *
     * @param _sql - The SQl to be inserted into the Database.
     */
    private void executeChange(String _sql) {
        // 
        try {
            this.stmt = con.createStatement();
            this.stmt.executeUpdate(_sql);
            this.con.close();
        } catch (SQLException e) {
            System.out.println("There was an error: " + e.getMessage());
        }
    }

    /**
     * This helper method establishes a connection to the database.
     */
    private void connect() {
        try {
            this.con = DriverManager.getConnection(this.host, this.userName, this.passWord);
            this.stmt = con.createStatement();
        } catch (SQLException ex) {
            System.out.println("No Connection to DB: " + ex.getMessage());
        }
    }
}
