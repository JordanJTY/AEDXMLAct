import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {
    static Controller controller = new Controller();

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {
        controller.readFile();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new View();
            frame.setSize(800, 600);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}