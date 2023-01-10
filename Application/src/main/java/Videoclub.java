import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement
public class Videoclub {
    private final String name = "Sergio y Jordan";
    private ArrayList<Film> films;
    private ArrayList<Game> games;

    public Videoclub(ArrayList<Film> films, ArrayList<Game> games) {
        this.films = films;
        this.games = games;
    }

    public Videoclub(){
        super();
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }
}
