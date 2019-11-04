package UserModels;

import Events.AppBase;
import java.util.ArrayList;

/**
 * Actor class that includes information such as Name, Gender, Movies acted in, ect.
 * @author Dillon. Last updated October 30, 2019.
 */
public class Actor extends AppBase{
    // Data fields for actors.
    private int id;
    private String department;
    private ArrayList<String> movies;
    // Constructor for Actor object with no arguments passed in.
    public Actor() {}
    // Constructor for Actor Object.    
    public Actor(int _id, String _department, ArrayList<String> _movies) {
        this.id = _id;
        this.department = _department;
        this.movies = _movies;
    }
    
    // =============== SETTERS ===============// 
    public void setId(int _id) {
        this.id = _id;
    }
    
    public void setDepartment(String _department) {
        this.department = _department;
    }
    
    public void setMovies(ArrayList<String> _movies) {
        this.movies = _movies;
    }
    
    // ================ GETTERS ===============//
    
    public int getId() {
        return this.id;
    }
    
    public String getDepartment() {
        return this.department;
    }
    
    public ArrayList<String> getMovies() {
        return this.movies;
    }
    
    
}
