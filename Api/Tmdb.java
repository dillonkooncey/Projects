package Api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
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
    private ArrayList<String> movieList = new ArrayList();

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
            // Create a JSON array of the results from the API call.
            JSONArray array = obj.getJSONArray("results");
            JSONObject ob = array.getJSONObject(0);
            // Get the vote average from the JSONArray.
            double movieRating = ob.getDouble("vote_average");
            // Return movie rating double value.
            return movieRating;
        } catch (Exception e) {
            System.out.println("Movie was not found.");
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
            String searchString = "/3/search/person?api_key=" + Tmdb.apiKey + "&language=en-US&query=" + newString + "&page=1&include_adult=false";
            // Create a new URL object with the baseUrl and created search string.
            URL url = new URL(Tmdb.baseUrl + searchString);
            // Establish a HttpURLConnection with the created URL object.
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // Set the request method.
            con.setRequestMethod("GET");
            // Create a BufferedReader to read the character stream from the HttpURLConnection.
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
            // Create a new JSONArray with the "results" array from JSONObject.
            JSONArray array = obj.getJSONArray("results");
            // Get the first element of the "results" array.
            JSONObject first = array.getJSONObject(0);
            // Create JSONArray with the "known_for" array from the "results" array.
            JSONArray array2 = first.getJSONArray("known_for");
            // Loop through the results array to find each movie the Actor has acted in.
            for (int i = 0; i < array2.length(); i++) {
                JSONObject test1 = array2.getJSONObject(i);
                String test2 = test1.getString("title");
                // Add the movie title to the ArrayList to then be returned.
                this.movieList.add(test2);
            }
            return this.movieList;
        } catch (Exception e) {

        }
        this.movieList.add("Actor not found");
        return this.movieList;
    }

    /**
     * Method to help construct the search string for the API call.
     *
     * @param _string - String searched by the user
     * @return - Newly constructed string.
     */
    private String queryBuilder(String _string) {
        try {
            return URLEncoder.encode(_string, "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }

}
