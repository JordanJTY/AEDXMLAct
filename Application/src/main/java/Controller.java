import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private static final String VIDEOCLUB_XML = "C:/Users/darkj/Desktop/Clases/AED/actEv2_1_JordanJaredTejeraYanez/resources/videoclub.xml";
    static ArrayList game = new ArrayList<Game>();
    static ArrayList film = new ArrayList<Film>();
    static Videoclub videoclub = new Videoclub();

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFilm(Film f) {
        film.add(f);
    }

    public void addGame(Game g) {
        game.add(g);
    }

    public void createVideoclub() throws JAXBException {
        createFile();
        Film f = new Film("Si", "Si", 69.99);
        film.add(f);
        Game g = new Game("Si", "Si", 20, 12);
        game.add(g);
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
    }

    public void readFile() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(VIDEOCLUB_XML));
        Transformer tform = TransformerFactory.newInstance().newTransformer();
        tform.setOutputProperty(OutputKeys.INDENT, "yes");
        tform.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        tform.transform(new DOMSource(document), new StreamResult(System.out));
    }

    public void modifyVideoclub() throws JAXBException {
        Film f = new Film("Si", "Si", 69.99);
        film.add(f);
        Game g = new Game("Si", "Si", 20, 12);
        game.add(g);
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
    }
}
