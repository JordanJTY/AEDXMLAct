import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement
public class Videoclub {
    private String name;
    private ArrayList<Film> films;
    private ArrayList<Game> games;

    public Videoclub(String name, ArrayList<Film> films, ArrayList<Game> games) {
        this.name = name;
        this.films = films;
        this.games = games;
    }

    public Videoclub(){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
