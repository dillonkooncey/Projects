package Api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Tmdb class that searches the Tmdb API for movies and actors.
 *
 * @author Kumar, Dillon. Last updated: November 18, 2019.
 */
public class Tmdb implements ApiInterface {

    // Data fields for Tmdb class.
    private static final String apiKey = "68c9635b6b0bc9ccad7ea0b91402025b";
    private static final String baseUrl = "https://api.themoviedb.org";

    /**
     * Method that takes in a movie String query and returns the rating of the
     * movie entered if it exists in the Tmdb API.
     *
     * @param _movie - Name of movie query.
     * @return - Rating of the movie.
     */
    @Override
    public double searchMovie(String _movie) {
        try {
            // Send the string to the string builder method.
            String newString = this.queryBuilder(_movie);
            // Build the string that will be sent to the API.
            String searchString = Tmdb.baseUrl + "/3/search/movie?api_key=" + Tmdb.apiKey + "&language=en-US&query=" + newString + "&page=1&include_adult=false";
            return 0;
        } catch (Exception e) {
            System.out.println("there was an error: " + e.getMessage());
        }
        return 0;
    }

    /**
     * Method that returns an ArrayList of strings of the movies that a
     * particular actor has acted in.
     *
     * @param _actor - Name of the actor that the User searched.
     * @return - The ArrayList of movies names the actor has acted in.
     */
    @Override
    public ArrayList<String> searchActor(String _actor) {
        try {
            // Send Actor name to the searchStringBuilder().
            String newString = this.queryBuilder(_actor);
            // Build the search string to be used by the API.
            String searchString = Tmdb.baseUrl + "/3/search/person?api_key=" + Tmdb.apiKey + "&language=en-US&query=" + newString + "&page=1&include_adult=false";
            return null;
        } catch (Exception e) {
            System.out.println("There was an error: " + e.getMessage());
        }
        return null;
    }

    /**
     * Method to help construct the search string for the API call.
     *
     * @param _string - String searched by the user
     * @return - Newly constructed string.
     */
    private String queryBuilder(String _string) {
        try {
            // Return the String modified by the URLEncoder class.
            return URLEncoder.encode(_string, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }

}
