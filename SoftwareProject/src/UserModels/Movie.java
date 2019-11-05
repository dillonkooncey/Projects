package UserModels;

import Events.AppBase;

/**
 * Movie class that stores information about a searched movie's title, overview,
 * rating, release date, and id.
 *
 * @author Dillon. Last updated: October 30 2019.
 */
public class Movie extends AppBase {

    // Data fields for Movie Object.
    private String title;
    private String overview;
    private double rating;
    private String releaseDate;
    private int id;

    // Basic Movie constructor with no arguments being passed in.
    public Movie() {
    }

    // Constructor for Movie object.
    public Movie(String _title, String _overview, double _rating, String _releaseDate, int _id) {
        this.title = _title;
        this.overview = _overview;
        this.rating = _rating;
        this.releaseDate = _releaseDate;
        this.id = _id;
    }

    // ========== SETTERS ==========//
    public void setTitle(String _title) {
        this.title = _title;
    }

    public void setOverview(String _overview) {
        this.overview = _overview;
    }

    public void setRating(double _rating) {
        this.rating = _rating;
    }

    public void setReleaseDate(String _releaseDate) {
        this.releaseDate = _releaseDate;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    // ========== GETTERS ==========//
    public String getTitle() {
        return this.title;
    }

    public String getOverview() {
        return this.overview;
    }

    public double getRating() {
        return this.rating;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public int getId() {
        return this.id;
    }
}
