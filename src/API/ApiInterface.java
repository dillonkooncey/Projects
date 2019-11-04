package API;

/**
 * Interface class for External APi's.
 * @author Dillon. Last updated October 31, 2019.
 */
public interface ApiInterface {
    public abstract void searchActor(String _actor);
    
    public abstract void searchMovie(String _movie);
}
