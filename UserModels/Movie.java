package UserModels;

import Api.ApiTranslator;
import Events.AppBase;
import Events.AppMessage;

/**
 * Movie class that stores information about a searched movie's title, overview,
 * rating, release date, and id.
 *
 * @author Dillon. Last updated: November 18, 2019.
 */
public class Movie extends AppBase {

    // Data fields for Movie Object.
    private double rating;
    private String name;
    // Give access to the Apitranslator class for API calls.
    private ApiTranslator translate;

    // Constructor for Movie object.
    public Movie(double _rating, String _name) {
        this.rating = _rating;
        this.name = _name;
    }

    /**
     * Method that searches the API for a movie searched by the User and stores
     * that result as a new Movie object.
     *
     * @param _movieName - Name of the movie searched by the User.
     * @return - int of the Movie panel
     */
    public int findMovieRating(String _movieName) {
        // Get the rating of the movie searched by the User and store it as a double.
        double movieRating = this.translate.findMovieRating(_movieName);
        // Create a new Movie object with the double value of the searched movie.
        Movie movie = new Movie(movieRating, _movieName);
        // Return back to the movie rating panel.
        return AppMessage.MOVIE_RATING_PANEL;
    }

    // ========== SETTERS ==========//
    public void setRating(double _rating) {
        this.rating = _rating;
    }

    public void setMovieName(String _movieName) {
        this.name = _movieName;
    }

    // ========== GETTERS ==========//
    public double getRating() {
        return this.rating;
    }

    public String getMovieName() {
        return this.name;
    }
}
