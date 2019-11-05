package Api;

import java.util.ArrayList;

/**
 *
 * @author Dillon. Last updated: November 4, 2019.
 */
public class Tmdb implements ApiInterface {

    /**
     * Method that takes in a movie String query and returns the rating of the movie 
     * entered if it exists in the Tmdb API.
     * @param _movie - Name of movie query.
     * @return - Rating of the movie.
     */
    @Override
    public double searchMovie(String _movie) {
        //hey
        return 0;
    }

    @Override
    public ArrayList<String> searchActor(String _actor) {
        return null;
    }
    
}
