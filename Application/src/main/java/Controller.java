import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static final String VIDEOCLUB_XML = "C:/Users/darkj/Desktop/Clases/AED/actEv2_1_JordanJaredTejeraYanez/resources/videoclub.xml";

    public void createFile() {
        try {
            // Creo una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Creo un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Creo un DOMImplementation
            DOMImplementation implementation = builder.getDOMImplementation();

            // Creo un documento con un elemento raiz
            Document documento = implementation.createDocument("C:/Users/darkj/Desktop/Clases/AED/actEv2_1_JordanJaredTejeraYanez/resources/", "videoclub", null);
            documento.setXmlVersion("1.0");
            System.out.println("Listo master");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initializer() throws JAXBException, IOException {
        ArrayList game = new ArrayList<Game>();
        ArrayList film = new ArrayList<Film>();
        Game game1 = new Game("Nier:AUTOOOOOOOmata", "Sex", 39.99, 16);
        Film film1 = new Film("Titanic", "Sex", 16);
        Game game2 = new Game("Nier:AUTOOOOOOmata", "Sex", 39.99, 16);
        Film film2 = new Film("Titanic2", "Sex", 16);
        Game game3 = new Game("Nier:AUTOOOOOmata", "Sex", 39.99, 16);
        Film film3 = new Film("Titanic3", "Sex", 16);
        Game game4 = new Game("Nier:AUTOOOOmata", "Sex", 39.99, 16);
        Game game5 = new Game("Nier:AUTOOOmata", "Sex", 39.99, 16);
        game.add(game1);
        game.add(game2);
        game.add(game3);
        game.add(game4);
        game.add(game5);
        film.add(film1);
        film.add(film2);
        film.add(film3);

        Videoclub videoclub = new Videoclub();
        videoclub.setGames(game);
        videoclub.setFilms(film);

        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Videoclub.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(videoclub, System.out);

        // Write to File
        m.marshal(videoclub, new
                File(VIDEOCLUB_XML));

        // get variables from our xml file, created before
        System.out.println();
        System.out.println("Output from our XML File: ");
        Unmarshaller um = context.createUnmarshaller();
        Videoclub videoclub2 = (Videoclub) um.unmarshal(new FileReader(
                VIDEOCLUB_XML));
        List<Game> gamelist = videoclub2.getGames();
        List<Film> filmlist = videoclub2.getFilms();
        for (Game cada : gamelist) {
            System.out.println(cada.toString());
        }
        for (Film cada : filmlist) {
            System.out.println(cada.toString());
        }
    }


}
