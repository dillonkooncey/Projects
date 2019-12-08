package Backups;

import Api.ApiTranslator;
import DataBase.DataBaseTranslator;
import java.util.ArrayList;

/**
 * Backup Model controller class.
 *
 * @author Dillon. Last updated: December 5, 2019.
 */
public class BackupModelController {

    private BackupUser user;
    private final DataBaseTranslator dbTranslate = new DataBaseTranslator();
    private final ApiTranslator apiTranslate = new ApiTranslator();

    public BackupModelController() {

    }
    
    public double findMovieRating(String _movieName) {
        return this.apiTranslate.findMovieRating(_movieName);
    }
    
    public ArrayList<String> findActorList(String _actorName) {
        return this.apiTranslate.findMovieList(_actorName);
    }
}
