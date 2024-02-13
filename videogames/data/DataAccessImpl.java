package videogames.data;

//@author DAVIUS1
import java.io.*;
import java.io.File;
import java.util.*;
import videogames.domain.VideoGames;
import videogames.exceptions.*;

public class DataAccessImpl implements IDataAccess {

    @Override
    public boolean exists(String fileName) {
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
            while (line != null) {
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
    public void write(VideoGames videogame, String fileName, boolean append) throws WriteDataEX {
        File file = new File(fileName);
        try {
            PrintWriter output = new PrintWriter(new FileWriter(file, append));
            output.println(videogame.toString());
            output.close();
            System.out.println("New information has been writen to the file:" + videogame);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new WriteDataEX("Exception when writing films:" + ex.getMessage());
        }
    }

    @Override
    public String search(String fileName, String search) throws ReadDataEX {
        File file = new File(fileName);
        String result = null;
        try {
            var input = new BufferedReader(new FileReader(file));
            String line = null;
            line = input.readLine();
            int index = 1;
            while (line != null) {
                if (search != null && search.equalsIgnoreCase(line)) {
                    result = "Videogame" + line + " found in the index " + index;
                    break;
                }
                line = input.readLine();
                index++;
            }
            input.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new ReadDataEX("Exception when searching films:" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new ReadDataEX("Exception when searching films:" + ex.getMessage());
        }
        return result;

    }

    @Override
    public void create(String fileName) throws DataAccessExceptions {
        File file = new File(fileName);
        try {
            var output = new PrintWriter(new FileWriter(file));
            output.close();
            System.out.println("The file has been created");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new DataAccessExceptions("Exception when creating a file:" + ex.getMessage());

        }
    }

    @Override
    public void delete(String fileName) {
        var file = new File(fileName);
        if (file.exists()) {
            file.delete();
            System.out.println("The file has been deleted");
        }

    }

}
