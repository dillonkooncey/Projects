package Api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Tmdb class that searches the Tmdb API for movies and actors.
 *
 * @author Dillon. Last updated: November 4, 2019.
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
            String searchString = "/3/search/movie?api_key=" + Tmdb.apiKey + "&language=en-US&query=" + newString + "&page=1&include_adult=false";
            // Creating the URL with the base URL and the created search String.
            URL url = new URL(Tmdb.baseUrl + searchString);
            // Creating an HttpURLConnection with the url.
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // Setting the request method of the HttpURLConnection.
            con.setRequestMethod("GET");
            // Creating a new BufferedReader object with the input stream coming from the Http connection.
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            // Build the content from the buffered input.
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // Close the connections.
            in.close();
            con.disconnect();
            // Extract the JSON object.
            JSONObject obj = new JSONObject(content.toString());
            // Get the double value of the vote average for the movie entered.
            double movieRating = obj.getDouble("vote_average");
            // Return movie rating double value.
            return movieRating;
        } catch (Exception e) {
            System.out.println("there was an error: " + e.getMessage());
        }
        return -1;
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
            String searchString = "/3/search/person?api_key=" + Tmdb.apiKey + "&language=en-US&query=" + newString + "&page=1&include_adult=false";
            URL url = new URL(Tmdb.baseUrl + searchString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            // Build the content from the buffered input.
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // Close the connections.
            in.close();
            con.disconnect();
            // Extract the JSON object.
            JSONObject obj = new JSONObject(content.toString());
            JSONArray array = obj.getJSONArray("original_title");
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
