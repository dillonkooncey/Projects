package Api;

import java.util.ArrayList;
/**
 * Translator class for the External API's.
 * @author Kumar, Amina. Last updated: November 4, 2019.
 */
public class ApiTranslator {
    private static final ApiInterface connect = new Tmdb();
    
    /**
     * Method that calls the Tmdb API and returns the information from the API method call.
     * @param _actorName - Name of the Actor that the User wants searched.
     * @return - An ArrayList of movie names that Actor has acted in.
     */
    public ArrayList<String> findMovieList(String _actorName) {
        return ApiTranslator.connect.searchActor(_actorName);
    }
    
    /**
     * Method that Calls the Tmdb API and returns the information from the API call.
     * @param _movieName - Name of the Movie the user wants the rating for.
     * @return - The double value of the movie rating.
     */
    public double findMovieRating(String _movieName) {
        return ApiTranslator.connect.searchMovie(_movieName);
    }
}
