package UserModels;

/**
 * USer class that defines user attributes and methods defining what users can do.
 * @author Dillon, Amina, Kumar. Last updated: October 5, 2019.
 */
public class User {
    private String email;
    private String username;
    private String password;
    
    public User(String _email, String _username, String _password) {
        this.email = _email;
        this.username = _username;
        this.password = _password;
    }
    
    private void searchMovies() {
        // Will be implemented by External API.
    }
    
    private void searchMovieGenre() {
        // Will be implemented by External API.
    }
    
    private void searchMovieActors() {
        // Will be implemented by External API.
    }
    
    private void searchMovieRating() {
        // Will be implemented by External API.
    }
    
    // =========== SETTERS ============= //
    public void setEmail(String _email) {
        this.email = _email;
    }
    
    public void setUsername(String _username) {
        this.username = _username;
    }
    
    public void setPassword(String _password) {
        this.password = _password;
    }
    
    // ============ GETTERS ============ //
    public String getEmail() {
        return this.email;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
}
