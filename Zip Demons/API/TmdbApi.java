package API;

/**
 * 
 * @author Dillon. Last updated October 2, 2019.
 */
public class TmdbApi {
    private static final String baseURL = "https://api.themoviedb.org";
    private static final String apiKey = "68c9635b6b0bc9ccad7ea0b91402025b";
    
    /**
     * Method that searches the TMDB Api by a title searched by the USer.
     * @param _movieTitle - The name of the movie title to be searched.
     * @return 
     */
    public String loadByTitle(String _movieTitle) {
        return "";
    }
    
    /**
     * Method that loads the top rated movies by rating.
     * @return - Top rated movies.
     */
    public String loadByRating() {
        return "";
    }
    
    /**
     * Loads movies based on actor passed in form user.
     * @param _actorName - Name of the actor to be searched.
     * @return - Return list of movies this actor has acted in.
     */
    public String loadByActor(String _actorName) {
        return "";
    }
    
    /**
     * Loads top rated movies.
     * @return - List of current top rated movies.
     */
    public String loadTopMovies() {
        return "";
    }
}
