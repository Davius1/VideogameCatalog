package videogames.service;

//author DAVIUS
import java.util.logging.Level;
import java.util.logging.Logger;
import videogames.data.DataAccessImpl;
import videogames.data.IDataAccess;
import videogames.domain.VideoGames;
import videogames.exceptions.DataAccessExceptions;
import videogames.exceptions.ReadDataEX;

public class VideogameCatalogImpl implements IVideogamesCatalog {

    private final IDataAccess data;

    public VideogameCatalogImpl() {
        this.data = new DataAccessImpl();
    }

    @Override
    public void addVideogame(String videogameName) {
        VideoGames videogames = new VideoGames(videogameName);
        boolean append = false;
        try {
            append = data.exists(FILE_NAME);
            data.write(videogames, FILE_NAME, append);
        } catch (DataAccessExceptions ex) {
            System.out.println("Data access error");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void VideogameList() {
        try {
            var videogames = this.data.list(FILE_NAME);
            for (var videogame : videogames) {
            }
        } catch (DataAccessExceptions ex) {
            System.out.println("Data access error");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void VideogameSearch(String search) {
        String result = null;
        try {
            result = this.data.search(FILE_NAME, search);
        } catch (DataAccessExceptions ex) {
            System.out.println("Data access error searching a videogame");
            ex.printStackTrace(System.out);
        }
        System.out.println("result = " + result);

    }

    @Override
    public void StartVideogameCatalog() {
        try {
            if (this.data.exists(FILE_NAME)) {
                data.delete(FILE_NAME);
                data.create(FILE_NAME);
            } else {
                data.create(FILE_NAME);
            }
        } catch (DataAccessExceptions ex) {
            System.out.println("Error loading videogame catalog");
            ex.printStackTrace(System.out);

        }
    }

}
