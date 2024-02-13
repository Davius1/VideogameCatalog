package videogames.domain;

//@author DAVIUS

public class VideoGames {
    private String name;
    
    public VideoGames() {  
    }

    public VideoGames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
}
