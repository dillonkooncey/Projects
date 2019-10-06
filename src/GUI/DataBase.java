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
            con = DriverManager.getConnection(host, userName, passWord);
            String SQL = "SELECT * FROM Users where Email = '" + _email + "' and Username = '" + _username + "' and Password = '" + _password + "'";
            pst = con.prepareStatement(SQL);
            rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Email, Username, and password matched");
                con.close();
                return true;
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
            con = DriverManager.getConnection(host, userName, passWord);
            String SQL = "SELECT * FROM Users where Email = '" + _email + "' or Username = '" + _username + "'";
            pst = con.prepareStatement(SQL);
            rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("Username or email is taken choose another");
                return false;
            } else {
                String SQL2 = "INSERT INTO Users (Email, Username, Password) VALUES ('" + _email + "','" + _username + "','" + _password + "')";
                stmt = con.createStatement();
                stmt.executeUpdate(SQL2);
                System.out.println("Email: " + _email + " Username: " + _username + " Password: " + _password + " added to DataBase");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    /**
     * Method not completed.
     * Method that removes a user from the database.
     * @param _email - Email to be removed.
     * @param _username - Username to be removed.
     * @param _password - Password to be removed.
     */
    public void removeUser(String _email, String _username, String _password) {
        try {
            con = DriverManager.getConnection(host, userName, passWord);
            String SQL = "DELETE FROM Users (Email, Username, Password) where Email = '" + _email + "', '" + _username + "', '" + _password + "'";
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
            System.out.println("Removed User");
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
