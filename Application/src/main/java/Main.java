import jakarta.xml.bind.JAXBException;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        Controller controller = new Controller();
        controller.createFile();
        controller.initializer();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new View();
                frame.setSize(300, 300);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}