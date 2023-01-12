import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "film")
public class Film {
    private String name;
    private String genre;
    private double price;

    public Film(String name, String genre, double price) {
        this.name = name;
        this.genre = genre;
        this.price = price;
    }

    public Film(){
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

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                '}';
    }
}
