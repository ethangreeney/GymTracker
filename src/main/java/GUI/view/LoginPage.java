package GUI.view;

import java.awt.*;
import javax.swing.*;

public class LoginPage extends JPanel {
    private JLabel usernameText;
    private JLabel passwordText;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton login;
    private JPanel userInterface;

    private String asciiArt = "h";

    public LoginPage() {
        setBackground(Utilities.backgroundColour);

        userInterface = new JPanel();
        userInterface.setBackground(Utilities.backgroundColour);
        userInterface.setLayout(new BoxLayout(userInterface, BoxLayout.Y_AXIS));

        usernameField = new JTextField();
        passwordField = new JTextField();

        usernameText = new JLabel("Username :");
        passwordText = new JLabel("Password:");

        userInterface.add(usernameText);
        userInterface.add(usernameField);
        userInterface.add(Box.createRigidArea(Utilities.buttonGap));
        userInterface.add(passwordText);
        userInterface.add(passwordField);

        add(userInterface);

    }

}
