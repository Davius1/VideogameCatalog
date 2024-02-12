package videogames.data;

//@author DAVIUS1

import java.io.*;
import java.io.File;
import java.util.*;
import videogames.domain.VideoGames;
import videogames.exceptions.*;


public class DataAccessImpl implements IDataAccess {

    @Override
    public boolean exists(String fileName) throws DataAccessExceptions {
        File file = new File(fileName);
        return file.exists();
    }

    @Override
    public List<VideoGames> list(String fileName) throws ReadDataEX {
        File file = new File(fileName);
        List<VideoGames> videogames = new ArrayList<>();
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String line = null;
            line = input.readLine();
            while (line != null){
                VideoGames videogame = new VideoGames(line);
                videogames.add(videogame);
                line = input.readLine();
            }
            input.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new ReadDataEX("Exception when listing films:" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new ReadDataEX("Exception when listing films:" + ex.getMessage());
        }
        return videogames;
    }

    @Override
    public void write(VideoGames VideoGames, String fileName, boolean append) throws WriteDataEX {
    
    }

    @Override
    public String search(String fileName, String search) throws ReadDataEX {

    }

    @Override
    public void create(String fileName) throws DataAccessExceptions {

    }

    @Override
    public void delete(String fileName) throws DataAccessExceptions {

    }
    
}
