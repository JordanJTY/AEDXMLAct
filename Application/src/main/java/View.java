import jakarta.xml.bind.JAXBException;

import javax.swing.*;

public class View extends JFrame {
    static Controller controller = new Controller();
    private JButton createXMLFileButton;
    private JButton clearXMLFileButton;
    private JButton deteteXMLFileButton;
    private JTextArea console;
    private JTextField nameGame;
    private JTextField genreGame;
    private JTextField priceGame;
    private JTextField pegiGame;
    private JButton submitGame;
    private JTextField nameFilm;
    private JTextField genreFilm;
    private JTextField priceFilm;
    private JButton submitFilm;
    private JPanel View;
    private JPanel gamePanel;
    private JPanel buttons;
    private JPanel filmPanel;

    public View() {
        super("Videoclub");
        setContentPane(View);
        deteteXMLFileButton.setVisible(false);
        String file = controller.readFile();
        if (file != "notexist") {
            console.setText(file);
            deteteXMLFileButton.setVisible(true);
        }
        submitFilm.addActionListener(e -> {
            if ((!nameFilm.getText().isEmpty() && !nameFilm.getText().isBlank()) &&
                    (!genreFilm.getText().isEmpty() && !genreFilm.getText().isBlank()) &&
                    (!priceFilm.getText().isEmpty() && !priceFilm.getText().isBlank() && priceFilm.getText().replace(".", "").chars().allMatch(Character::isDigit))) {
                System.out.println(nameFilm.getText() + " - " + genreFilm.getText() + " - " + priceFilm.getText());
                controller.addFilm(new Film(nameFilm.getText(), genreFilm.getText(), Double.parseDouble(priceFilm.getText())));
            } else {
                System.out.println("F Film");
            }
            try {
                console.setText(controller.updateConsole());
            } catch (JAXBException ex) {
                throw new RuntimeException(ex);
            }
        });
        submitGame.addActionListener(e -> {
            if (
                    (!nameGame.getText().isEmpty() && !nameGame.getText().isBlank()) &&
                            (!genreGame.getText().isEmpty() && !genreGame.getText().isBlank()) &&
                            (!priceGame.getText().isEmpty() && !priceGame.getText().isBlank() && priceGame.getText().replace(".", "").chars().allMatch(Character::isDigit)) &&
                            (!pegiGame.getText().isEmpty() && !pegiGame.getText().isBlank() && pegiGame.getText().chars().allMatch(Character::isDigit))) {
                System.out.println(nameGame.getText() + " - " + genreGame.getText() + " - " + priceGame.getText() + " - " + pegiGame.getText());
                controller.addGame(new Game(nameGame.getText(), genreGame.getText(), Double.parseDouble(priceGame.getText()), Integer.parseInt(pegiGame.getText())));
            } else {
                System.out.println("F Game");
            }
            try {
                console.setText(controller.updateConsole());
            } catch (JAXBException ex) {
                throw new RuntimeException(ex);
            }
        });
        createXMLFileButton.addActionListener(e -> {
            try {
                controller.createVideoclub();
                deteteXMLFileButton.setVisible(true);

            } catch (JAXBException ex) {
                throw new RuntimeException(ex);
            }
        });
        clearXMLFileButton.addActionListener(e -> {
            controller.clearXml();
            try {
                console.setText(controller.updateConsole());
            } catch (JAXBException ex) {
                throw new RuntimeException(ex);
            }
        });
        deteteXMLFileButton.addActionListener(e -> {
            controller.deleteFile();
            console.setText("");
            deteteXMLFileButton.setVisible(false);
        });
    }
}
