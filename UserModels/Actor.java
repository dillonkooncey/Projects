package UserModels;

import Api.ApiTranslator;
import Events.AppBase;
import Events.AppMessage;
import java.util.ArrayList;

/**
 * Actor class that includes the list of movies that actor has acted in.
 *
 * @author Dillon. Last updated October 30, 2019.
 */
public class Actor extends AppBase {
    // DataField for the Actor class.
    private ArrayList<String> movies;
    private String name;
    // Give access to the ApiTranslator class for API calls.
    private ApiTranslator translate;

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
    public int findMovieList(String _actorName) {
        /* Send the actor name to the API translator class to see if the actor 
        exists in the API and if so get an arrayList of movies that they have acted in.*/
        ArrayList<String> _movieList = this.translate.findMovieList(_actorName);
        // Create a new Actor object with the ArrayList of movies.
        Actor actor = new Actor(_movieList, _actorName);
        return AppMessage.ACTORS_PANEL;
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
