package UserModels;

import Api.ApiTranslator;
import Events.AppBase;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Actor class that includes the list of movies that actor has acted in.
 *
 * @author Dillon. Last updated December 1, 2019.
 */
public class Actor extends AppBase {

    // DataField for the Actor class.
    private ArrayList<String> movies;
    private String name;
    // Give access to the ApiTranslator class for API calls.
    private ApiTranslator translate = new ApiTranslator();

    // Overloaded constructor to allow for an empty object.
    public Actor() {

    }

    // Constructor for Actor Object.    
    public Actor(ArrayList<String> _movies, String _name) {
        this.movies = _movies;
        this.name = _name;
    }

    /**
     * Method that based on a searched actors name will search the API for any
     * movie that actor may have acted in.
     *
     * @param _actorName - Name of the actor searched by the User.
     * @return - Return back to the Actors Panel.
     */
    public static boolean findMovieList(String _actorName) {
        // Send the actor name to the API to get a list of moives acted in if they exist in DataBase.
        ArrayList<String> _movieList = ApiTranslator.findMovieList(_actorName);
        // Create a new Actor object with the ArrayList of movies.
        Actor actor = new Actor(_movieList, _actorName);
        return true;
    }

    /**
     * Method that sorts the ArrayList of movies into Ascending order.
     *
     * @return - The ascending order of Movie titles.
     */
    public ArrayList<String> sortAscendingOrder() {
        // Use the collections class to sort the movies ArrayList.
        Collections.sort(this.getMovies());
        // Return the newly sorted arraylist.
        return this.getMovies();
    }

    /**
     * Method that sorts the ArrayList of movies into descending order.
     *
     * @return - The descending order of movie titles.
     */
    public ArrayList<String> sortDescendingOrder() {
        Collections.sort(this.getMovies(), Collections.reverseOrder());
        return this.getMovies();
    }

    // =============== SETTERS ===============// 
    public void setMovies(ArrayList<String> _movies) {
        this.movies = _movies;
    }

    public void setActorName(String _name) {
        this.name = _name;
    }

    // ================ GETTERS ===============//
    public ArrayList<String> getMovies() {
        return this.movies;
    }

    public String getActorName() {
        return this.name;
    }

}
