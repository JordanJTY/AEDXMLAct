import javax.swing.*;

public class View extends JFrame {
    private JButton createXMLFileButton;
    private JButton modifyXMLFileButton;
    private JButton deleteXMLFileButton;
    private JTextArea Console;
    private JTextField nameGame;
    private JTextField genreField;
    private JTextField priceField;
    private JTextField pegiField;
    private JButton submitGame;
    private JTextField nameFilm;
    private JTextField genreFieldFilm;
    private JTextField priceFieldFilm;
    private JButton submitFilm;
    private JPanel View;
    private JPanel gamePanel;
    private JPanel buttons;
    private JPanel filmPanel;

    public View() {
        super("Videoclub");
        setContentPane(View);
    }
}
