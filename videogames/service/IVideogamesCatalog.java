
package videogames.service;

//@author DAVIUS1

public interface IVideogamesCatalog {
    
    String FILE_NAME = "videogames.txt";
    
    void addVideogame(String videogameName);
    
    void VideogameList();
    
    void VideogameSearch(String search);
    
    void StartVideogameCatalog();
}
