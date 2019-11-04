package API;

/**
 * Class that handles all of the Api calls and returns information back to the 
 * Api translator class.
 * @author Dillon. Last updated October 2, 2019.
 */
public class TmdbApi implements ApiInterface {
    // Data fields for TmdbApi class.
    private static final String baseURL = "https://api.themoviedb.org";
    private static final String apiKey = "68c9635b6b0bc9ccad7ea0b91402025b";    
    
    /**
     * Searches Api for Actors and returns any information that actor may have
     * such as movies, department, and gender.
     * @param _actor - The name of the actor the user wants searched.
     */
    @Override
    public void searchActor(String _actor) {
        // In case of query having a space split the query into an arrayList.
        String [] splitQuery = _actor.split(" ");
        // Create a string to be modified later.
        String st = "";
        // Loop through the splitquery String [] to help build the api query.
        for(String i : splitQuery) {
            st += i + "%20";
        }
        // Trim off the last %20.
        st = st.substring(0, st.length() - 3);
        // Create the search string for the api.
        String searchString = TmdbApi.baseURL + "/3/search/person?api_key=" + TmdbApi.apiKey + "&language=en-US&query=" + st + "&page=1&include_adult=false";
        
    }

    /**
     * Method that searches TMDB for a movie entered in by the user.
     * @param _movie - Name of the movie to be searched.
     */
    @Override
    public void searchMovie(String _movie) {
        // In case of search having a space in it split the query into an string array.
        String [] splitQuery = _movie.split(" ");
        // Create a string that will be modified later.
        String st = "";
        // Loop through the String [] adding a %20 to each postion in each positon in the array.
        for(String i : splitQuery) {
            st += i + "%20";
        }
        // Trim off the last %20 for the string.
        st = st.substring(0, st.length() -3);
        // Create the search string for the URL.
        String searchString = TmdbApi.baseURL + "/3/search/movie?api_key=" + TmdbApi.apiKey + "&language=en-US&query=" + st + "&page=1&include_adult=false";
    }
}
