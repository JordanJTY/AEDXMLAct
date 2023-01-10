import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "game")
public class Game {
    private String name;
    private String genre;
    private double price;
    private int pegi;

    public Game(String name, String genre, double price, int pegi) {
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.pegi = pegi;
    }

    public Game(){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPegi() {
        return pegi;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", pegi=" + pegi +
                '}';
    }
}
