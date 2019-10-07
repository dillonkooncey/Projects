package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class that defines the database and methods that perform database functions
 * such as search, add, and remove users. Also changes user information such as
 * email, username, and password.
 *
 * @author Dillon, Amina, Kumar. Last updated: October 6, 2019.
 */
public class DataBase {

    // Data fields for DataBase class.
    private final String host = "jdbc:derby://localhost:1527/dillonkooncey";
    private final String userName = "dckoonce";
    private final String passWord = "November21998";
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pst;
    private Statement stmt;

    /**
     * Method that checks to see if a username and password exists in the
     * database.
     *
     * @param _email - Email checked to see if it exists.
     * @param _username - Username checked to see if it exists.
     * @param _password - Password checked to see if it exists.
     * @return - Return true if user does exists, false if they do not.
     */
    public Boolean isUser(String _email, String _username, String _password) {
        try {
            // establishing the connection.
            con = DriverManager.getConnection(host, userName, passWord);
            // SQL statement to find a user that matches the email, username, and password entered.
            String SQL = "SELECT * FROM Users where Email = '" + _email + "' and Username = '" + _username + "' and Password = '" + _password + "'";
            // Prepared statement with the SQL string.
            pst = con.prepareStatement(SQL);
            // Create a result set with the SQL search.
            rs = pst.executeQuery();
            // If statement for if there exists a user print the information matched and return true (true this user exists).
            if (rs.next()) {
                System.out.println("Email, Username, and password matched");
                con.close();
                return true;
                // Else the user does not exist in the database. Print that something didnt match and return false (False this user does not exist.).
            } else {
                System.out.println("Something did not match");
                con.close();
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Method that adds a new user to the Database first checking if the entered
     * in username and email already exists in the database.
     *
     * @param _email - Email to be added in.
     * @param _username - Username to be added in.
     * @param _password - Password to be added in.
     * @return - Return true if added. False if not.
     */
    public Boolean addUser(String _email, String _username, String _password) {
        try {
            // Establish a connection.
            con = DriverManager.getConnection(host, userName, passWord);
            // Prepare a SQL statement looking for emails and usernames that match values entered.
            String SQL = "SELECT * FROM Users where Email = '" + _email + "' or Username = '" + _username + "'";
            // Prepared statement included with the SQL search.
            pst = con.prepareStatement(SQL);
            // Result set with results that match SQL search.
            rs = pst.executeQuery();
            // If a user has a email or username matched with values entered the user cannot use this account.
            if (rs.next()) {
                System.out.println("Username or email is taken.");
                con.close();
                // Retrun false we cannot add this user.
                return false;
                // Else the email and username eneterd are original and add the values to the database.
            } else {
                String SQL2 = "INSERT INTO Users (Email, Username, Password) VALUES ('" + _email + "','" + _username + "','" + _password + "')";
                stmt = con.createStatement();
                stmt.executeUpdate(SQL2);
                System.out.println("Email: " + _email + " Username: " + _username + " Password: " + _password + " added to DataBase");
                con.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // Return true we did add the values to the database.
        return true;
    }

    /**
     * Method that removes a user from the database.
     *
     * @param _email - Email to be removed.
     * @param _username - Username to be removed.
     * @param _password - Password to be removed.
     */
    public void removeUser(String _email, String _username, String _password) {
        try {
            // Establish the connction.
            con = DriverManager.getConnection(host, userName, passWord);
            // SQl for deleting the account for the user.
            String SQL = "DELETE FROM Users where Email = '" + _email + "' and Username = '" + _username + "' and Password = '" + _password + "'";
            // Create a statement.
            stmt = con.createStatement();
            // Execute the update desired with the SQL string.
            stmt.executeUpdate(SQL);
            // Close the connection.
            con.close();
            // Print to the console that the user has been removed.
            System.out.println("Removed User");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to change the users email in the database.
     *
     * @param _email - The old user email.
     * @param _newEmail - The new user email.
     * @return - Return true of false if the action completed or failed.
     */
    public Boolean changeEmail(String _newEmail, String _email) {
        try {
            // Establish a connection with database.
            con = DriverManager.getConnection(host, userName, passWord);
            // Check the database for if the new email already exists.
            String SQLCheck = "SELECT * FROM Users where Email = " + _newEmail + "'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQLCheck);
            // If the new email already exists the print to user that the email is already taken.
            if (rs.next()) {
                System.out.println("Email: " + _newEmail + "' is taken. Choose another email.");
                return false;
                // Else the new email has not been used and can now be changed and notify console of the change.
            } else {
                String SQL = "update Users set Email = '" + _newEmail + "' where Email = '" + _email + "'";
                stmt = con.createStatement();
                stmt.executeUpdate(SQL);
                con.close();
                System.out.println("Email changed to " + _newEmail);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    /**
     * Method to change the users username in the database.
     *
     * @param _newUsername - The new username.
     * @param _username - The old username.
     * @return - Return true or false for if the action completed for failed.
     */
    public Boolean changeUsername(String _newUsername, String _username) {
        try {
            // Establish a connection to database.
            con = DriverManager.getConnection(host, userName, passWord);
            // Check the database for if the new username already exists.
            String SQLCheck = "Select * From Users where Username = '" + _newUsername + "'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQLCheck);
            // If the new username already exists print the username has already been taken.
            if (rs.next()) {
                System.out.println("Username: " + _newUsername + " is taken. Choose another username");
                return false;
                // Else change the username to the new username and notify the console of the change.
            } else {
                String SQL = "update Users set Username = '" + _newUsername + "' where Username = '" + _username + "'";
                stmt = con.createStatement();
                stmt.executeUpdate(SQL);
                con.close();
                System.out.println("Username changed from " + _username + " to " + _newUsername);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    /**
     * Method that changes the users password in the database.
     *
     * @param _newPassword - The new user password.
     * @param _username - Username of the user to ensure only one password is
     * changed.
     * @param _password - The old user password.
     * @return - Return true for password change confirmation
     */
    public Boolean changePassword(String _newPassword, String _username, String _password) {
        try {
            // Establish a connection to the database.
            con = DriverManager.getConnection(host, userName, passWord);
            // SQL statement to update the users old password to the new password.
            String SQL = "update Users set Password = '" + _newPassword + "' where Password = '" + _password + "' and Username = '" + _username + "'";
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
            con.close();
            System.out.println("Password changed from " + _password + " to " + _newPassword + " for " + _username + " account.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
