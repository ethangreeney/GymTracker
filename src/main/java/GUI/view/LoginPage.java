package GUI.view;

import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPage extends JPanel {
    private JLabel usernameText;
    private JLabel passwordText;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton login;
    private JPanel userInterface;

    public LoginPage() {
        setBackground(Utilities.backgroundColour);

        userInterface = new JPanel();
        userInterface.setBackground(Utilities.backgroundColour);
        userInterface.setLayout(new BoxLayout(userInterface, BoxLayout.Y_AXIS));

        usernameField = new JTextField();
        passwordField = new JTextField();

        usernameText = new JLabel("Username:");
        passwordText = new JLabel("Password:");

        login = new JButton("LOG IN NOW");

        userInterface.add(usernameText);
        userInterface.add(usernameField);
        userInterface.add(Box.createRigidArea(Utilities.buttonGap));
        userInterface.add(passwordText);
        userInterface.add(passwordField);
        userInterface.add(login);

        add(userInterface);

    }

    public void addLoginListener(ActionListener e) {
        login.addActionListener(e);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }

}
