import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;

public class Controller {
    private static final String VIDEOCLUB_XML = System.getProperty("user.home") + "/Desktop/videoclub.xml";
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

    public String updateConsole() throws JAXBException {
        videoclub.setGames(game);
        videoclub.setFilms(film);
        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Videoclub.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter sw = new StringWriter();
        // Write to System.out
        m.marshal(videoclub, sw);
        return sw.toString();
    }

    public void clearXml() {
        game = new ArrayList<Game>();
        film = new ArrayList<Film>();
    }

    public void createVideoclub() throws JAXBException {
        createFile();
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

    public String readFile() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            StringWriter sw = new StringWriter();
            Document document = builder.parse(new File(VIDEOCLUB_XML));
            Transformer tform = TransformerFactory.newInstance().newTransformer();
            tform.setOutputProperty(OutputKeys.INDENT, "yes");
            tform.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            tform.transform(new DOMSource(document), new StreamResult(sw));
            JAXBContext jaxbContext = JAXBContext.newInstance(Videoclub.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Videoclub videoclub1 = (Videoclub) jaxbUnmarshaller.unmarshal(new File(VIDEOCLUB_XML));
            if (videoclub1.getFilms() != null) {
                for (Film f : videoclub1.getFilms()) {
                    addFilm(f);
                }
            }
            if (videoclub1.getGames() != null) {
                for (Game g : videoclub1.getGames()) {
                    addGame(g);
                }
            }
            return sw.toString();
        } catch (Exception e) {
            System.out.println("No existe");
            return "notexist";
        }
    }

    public void modifyVideoclub() throws JAXBException {
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
