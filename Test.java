package Testing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that runs all of the testing for the project. Class includes a main
 * method so that it can be run separate from the rest of the system.
 *
 * @author Dillon. Last updated: December 8, 2019.
 */
public class Test {

    // Give access to DataBaseTest and ApiTest classes for testing.
    private static DataBaseTest dbTest = new DataBaseTest();
    private static ApiTest apiTest = new ApiTest();

    public static void main(String[] args) {
        // Complete: runCreationTest();
        // Complete: runValidationTest();
        // Incomplete: runUpdateTest();
        // Complete: runDeleteTest();
        // Complete: runAccountReactivateTest();
        // Complete: runAPIAscendingOrderTest();
        // Complete: runAPIDescendingOrderTest();
        // Complete: runSearchActorTest();
        // Complete: runMovieSearchTest();
    }

    // ====== All DataBase and User class tests ====== //
    /**
     * Method that tests the User classes createUser() and the DataBases
     * createUser functionality. Expected outputs are commented above the method
     * call.
     */
    public static void runCreationTest() {
        // Should print creation failed since account already exists.
        dbTest.testCreateUser("d", "d", "d");
        // Should print creation successful since account doesnt exist.
        dbTest.testCreateUser("dillon", "cole", "koonce");
        // Should all print creation failed since parameters are empty.
        dbTest.testCreateUser("", "dillon", "koonce");
        dbTest.testCreateUser("dillon", "", "koonce");
        dbTest.testCreateUser("dillon", "koonce", "");

    }

    /**
     * Method that tests the User classes validateUser() and the Databases
     * readObject functionality. Expected outputs are commented above the method
     * call.
     */
    public static void runValidationTest() {
        // Should print validation successful since account exists.
        dbTest.testValidateUser("d", "d", "d");
        // Should print validation failed since account does not exist.
        dbTest.testValidateUser("di", "d", "d");
        // Should all print validation failed since accounts dont exist and parameters are empty.
        dbTest.testValidateUser("d", "", "d");
        dbTest.testValidateUser("", "d", "d");
        dbTest.testValidateUser("d", "d", "");
    }

    /**
     * Method to test the update User information functionality of the User
     * class and the Database.
     */
    public static void runUpdateTest() {
        // Should print update Successful since nothing new passed in already exists in database.
        dbTest.updateTest("dillon", "cole", "koonce", "d");
        // Should print update failed since parameters are empty.
        dbTest.updateTest("", "", "", "d");
    }

    /**
     * Method that tests the delete account functionality of the database.
     */
    public static void runDeleteTest() {
        HashMap<String, String> map = new HashMap();
        map.put("email", "d");
        map.put("username", "d");
        map.put("password", "d");
        map.put("active", "true");
        // Should print Deletion successful since account exists and is active.
        dbTest.deleteAccountTest(map);
        // If you run it again it will say deletion failed since account has already been deleted.
    }

    /**
     * Method to test the account reactivation functionality of the User class
     * and the DataBase.
     */
    public static void runAccountReactivateTest() {
        // Should print reactivation failed since account is active (unless we just deleted it).
        dbTest.testAccountReactivate("d", "d", "d");
        // Should print reactivation failed since parameters are empty.
        dbTest.testAccountReactivate("d", "d", "");
        dbTest.testAccountReactivate("d", "", "d");
        dbTest.testAccountReactivate("", "d", "d");
        // Should print reactivation successful since account is deleted and the information matches an account.
        dbTest.testAccountReactivate("dillon", "cole", "koonce");
    }

    // ====== All API, Actor, and Movie class tests ====== //
    /**
     * Method to tests the functionality of the sortAscendingOrder() in the
     * Actor class.
     */
    public static void runAPIAscendingOrderTest() {
        ArrayList<String> test = new ArrayList();
        test.add("Dillon");
        test.add("Cole");
        test.add("Koonce");
        test.add("Austin");
        // Should print the original version of the ArrayList and then the ascending order version.
        apiTest.testSortAscending(test);
        ArrayList<String> test2 = new ArrayList();
        test2.add("");
        test2.add("");
        // Should print "" since information passed in is empty.
        apiTest.testSortAscending(test2);
    }

    /**
     * Method to test the sortDescendingOrder functionality of the Actor class.
     */
    public static void runAPIDescendingOrderTest() {
        // Should print "original: Dillon, Cole, Koonce, Austin. Sorted: Koonce, Cole, Dillon, Austin"
        ArrayList<String> test = new ArrayList();
        test.add("Dillon");
        test.add("Cole");
        test.add("Koonce");
        test.add("Austin");
        apiTest.testDescending(test);
        ArrayList<String> test2 = new ArrayList();
        test2.add("");
        test2.add("");
        // Should print "" since parameters passed in are empty.
        apiTest.testDescending(test2);
    }

    /**
     * Method to test the search Actor functionality of the API.
     */
    public static void runSearchActorTest() {
        // Should print out The Avengers, The Avengers: Infinity War, The Avengers: Age of Ultron since that is what TheMovieDatabase gives.
        apiTest.testActorSearch("Chris Hemsworth");
        // Should print actor not found.
        apiTest.testActorSearch("");
    }

    /**
     * Method to test the search movie functionality of the API.
     */
    public static void runMovieSearchTest() {
        // Should print 7.1 for the rating since that is the TheMovieDatabase rating.
        apiTest.testMovieSearch("Skyfall");
        // Should print 7.7 since that is the TheMovieDatabase rating.
        apiTest.testMovieSearch("The Avengers");
        // Should print "Movie not found" and 0.0 since movie is nothing is entered.
        apiTest.testMovieSearch("");
    }
}
