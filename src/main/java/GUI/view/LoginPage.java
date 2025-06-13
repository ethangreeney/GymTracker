package GUI.view;

import java.awt.*;
import javax.swing.*;

public class LoginPage extends JPanel {

    private JTextField username;
    private JTextField password;
    private JButton login;
    private JPanel userInterface;

    private String asciiArt = "h";

    public LoginPage() {

        setBackground(Utilities.backgroundColour);
        this.userInterface = new JPanel();

        userInterface.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }

}
