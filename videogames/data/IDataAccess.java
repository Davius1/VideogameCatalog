package videogames.data;

//@author DAVIUS1

import java.util.List;
import videogames.domain.VideoGames;
import videogames.exceptions.*;


public interface IDataAccess {
    boolean exists(String fileName) throws DataAccessExceptions;
    
    List<VideoGames> list(String fileName) throws ReadDataEX;
    
    void write (VideoGames VideoGames, String fileName, boolean append) throws WriteDataEX;
    
    String search(String fileName, String search) throws ReadDataEX;
    
    void create(String fileName) throws DataAccessExceptions;
    
    void delete(String fileName) throws DataAccessExceptions;
}
