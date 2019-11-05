package Api;

import java.util.ArrayList;

/**
 * Interface for external API's.
 * @author Dillon. Last updated: November 4, 2019.
 */
public interface ApiInterface {
    // Methods that will search for movies and return the rating of that movie.
    public abstract double searchMovie(String _movie);
    // Methods that will search for actors and return a string ArrayList of movies they have acted in.
    public abstract ArrayList<String> searchActor(String _actor);
}
