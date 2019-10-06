/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class that defines the database and methods that perform database functions 
 * such as search, add, and remove users.
 * @author Dillon, Amina, Kumar. Last updated: September 29, 2019.
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
     * Method that checks to see if a username and password exists in the database.
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
                System.out.println("Username or email is taken choose another");
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
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
