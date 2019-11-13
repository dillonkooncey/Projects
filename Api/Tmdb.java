package Api;

import java.util.ArrayList;

/**
 * Tmdb class that searches the Tmdb API for movies and actors.
 *
 * @author Kumar, Anima. Last updated: November 4, 2019.
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
        // Send the string to the string builder method.
        String newString = this.searchStringBuilder(_movie);
        // Build the string that will be sent to the API.
        String searchString = Tmdb.baseUrl + "/3/search/movie?api_key=" + Tmdb.apiKey + "&language=en-US&query=" + newString + "&page=1&include_adult=false";
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
        // Send the String to the string builder method.
        String newString = this.searchStringBuilder(_actor);
        // Build the string that will be sent to the API.
        String searchString = Tmdb.baseUrl + "/3/search/person?api_key=" + Tmdb.apiKey + "&language=en-US&query=" + newString + "&page=1&include_adult=false";
        return null;
    }

    /**
     * Method to help construct the search string for the API call.
     *
     * @param _string - String searched by the user
     * @return - Newly constructed string.
     */
    private String searchStringBuilder(String _string) {
        // Split the string into a string array.
        String[] splitString = _string.split(" ");
        // Create a string that will be modified later.
        String string = "";
        // For loop to build a new string for the API search.
        for (String i : splitString) {
            string += i + "%20";
        }
        // trim off the last "%20" from the for loop.
        string = string.substring(0, string.length() - 3);
        // return the newly built string.
        return string;

    }

}
