package Testing;

import DataBase.DataBaseTranslator;
import UserModels.User;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that runs tests on the DataBase to ensure everything is running
 * correctly.
 *
 * @author Dillon. Last updated: December 8, 2019.
 */
public class DataBaseTest {

    // Give access to DataBaseTranslator class.
    private User user = new User();
    private static DataBaseTranslator translate = new DataBaseTranslator();

    // Empty constructor for DataBaseTest class.
    public DataBaseTest() {

    }

    /**
     * Method to test the validate user function for the database.
     *
     * @param _email - Email tested.
     * @param _username - username tested.
     * @param _password - password tested.
     */
    public void testValidateUser(String _email, String _username, String _password) {
        boolean validate = user.validateUser(_email, _username, _password);
        if (validate == true) {
            System.out.println("Validation succesful");
        } else {
            System.out.println("Validation failed");
        }
    }

    /**
     * Method to test the create user function for the database.
     *
     * @param _email - Email tested.
     * @param _username -username tested.
     * @param _password - password tested.
     */
    public void testCreateUser(String _email, String _username, String _password) {
        boolean create = user.createUser(_email, _username, _password);
        if (create == true) {
            System.out.println("Creation successful");
        } else {
            System.out.println("Creation failed");
        }
    }

    /**
     * Method to test the account recovery functionality of the user class and
     * the Database.
     *
     * @param _email - Email tested.
     * @param _username - Username tested.
     * @param _password - Password tested.
     */
    public void testAccountReactivate(String _email, String _username, String _password) {
        boolean activate = user.reactivateAccount(_email, _username, _password);
        if (activate == true) {
            System.out.println("Reactivation successful");
        } else {
            System.out.println("Reactivation failed");
        }
    }

    /**
     * Method to test the update user information functionality of the User
     * class and the database.
     *
     * @param _email - New email.
     * @param _newUsername - New username.
     * @param _password - New password.
     * @param _oldUsername - The username saved in the database.
     */
    public void updateTest(String _email, String _newUsername, String _password, String _oldUsername) {
        HashMap<String, String> hash = this.hashCreater(_email, _newUsername, _password);
        boolean update = translate.updateObject(hash, _oldUsername, "users");
        if (update == true) {
            System.out.println("Update successful");
        } else {
            System.out.println("Update failed");
        }
    }

    /**
     * Method to test the delete account function for the database.
     *
     * @param _map - HashMap of account information.
     */
    public void deleteAccountTest(Map<String, String> _map) {
        boolean delete = translate.deleteObject(_map, "users");
        if (delete == true) {
            System.out.println("Deletion successful");
        } else {
            System.out.println("Deletion failed");
        }
    }

    /**
     * Method to build the HashMap for Method calls in other methods.
     *
     * @param _email - Email passed in.
     * @param _username - Username passed in.
     * @param _password - Password passed in.
     * @return - The created HashMap.
     */
    private HashMap<String, String> hashCreater(String _email, String _username, String _password) {
        HashMap<String, String> map = new HashMap();
        map.put("email", _email);
        map.put("username", _username);
        map.put("password", _password);
        map.put("active", "true");
        return map;
    }
}
