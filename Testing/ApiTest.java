package Testing;

import Api.ApiTranslator;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class that runs test for the API to ensure the API is running smoothly.
 *
 * @author Dillon. Last updated: December 8, 2019.
 */
public class ApiTest {

    // Give access to the ApiTranslator class for Api calls.
    private ApiTranslator translate = new ApiTranslator();

    // Constructor for ApiTest class.
    public ApiTest() {

    }

    /**
     * Method to test the search Actor functionality of the Actor and Tmdb
     * class.
     *
     * @param _actor - Actor name.
     */
    public void testActorSearch(String _actor) {
        ArrayList<String> movieList = translate.findMovieList(_actor);
        System.out.println(movieList);
    }

    /**
     * Method to test the search movie functionality of the movie and Tmdb
     * class.
     *
     * @param _movie - Movie name.
     */
    public void testMovieSearch(String _movie) {
        double movieRating = translate.findMovieRating(_movie);
        System.out.println(movieRating);
    }

    /**
     * Method to test the sort in ascending order function in the Actor class.
     *
     * @param _movieList - List of strings.
     */
    public void testSortAscending(ArrayList<String> _movieList) {
        System.out.println("Original: " + _movieList);
        Collections.sort(_movieList);
        System.out.println("Sorted: " + _movieList);
    }

    /**
     * Method to test the sort in descending order functionality in the Actor
     * class.
     *
     * @param _movieList List of Strings.
     */
    public void testDescending(ArrayList<String> _movieList) {
        System.out.println("Original: " + _movieList);
        Collections.sort(_movieList, Collections.reverseOrder());
        System.out.println("Sorted: " + _movieList);
    }
}
