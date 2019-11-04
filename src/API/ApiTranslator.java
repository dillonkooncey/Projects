package API;

/**
 * Translator class for the external Api.
 * @author Dillon. Last updated October 31, 2019.
 */
public class ApiTranslator implements ApiInterface{
    // Give access to the external API.
    protected static final ApiInterface connectApi = new TmdbApi();

    /**
     * Method that translate request from GUI to the TmdbApi class.
     * @param _actor - Name of the actor entered in from the GUi.
     */
    @Override
    public void searchActor(String _actor) {
    }

    /**
     * Method that translates request from GUI to the TmdbApi class.
     * @param _movie 
     */
    @Override
    public void searchMovie(String _movie) {
    }
    
    
}
