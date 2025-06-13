package GUI.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class LoginPage extends JPanel {
    private JLabel loginText;
    private JLabel usernameText;
    private JLabel passwordText;
    private JLabel loginFailed;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton login;
    private JPanel userInterface;
    private Dimension textFieldSize = new Dimension(250, 35);

    private String asciiArt = """



            ██╗      ██████╗  ██████╗ ██╗███╗   ██╗
            ██║     ██╔═══██╗██╔════╝ ██║████╗  ██║
            ██║     ██║   ██║██║  ███╗██║██╔██╗ ██║
            ██║     ██║   ██║██║   ██║██║██║╚██╗██║
            ███████╗╚██████╔╝╚██████╔╝██║██║ ╚████║
            ╚══════╝ ╚═════╝  ╚═════╝ ╚═╝╚═╝  ╚═══╝
            """;

    public LoginPage() {

        loginText = new JLabel(Utilities.toHtmlFormat(asciiArt));
        loginText.setAlignmentX(CENTER_ALIGNMENT);
        loginText.setHorizontalAlignment(SwingConstants.CENTER);

        setBackground(Utilities.backgroundColour);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(loginText);

        add(Box.createRigidArea(Utilities.buttonGap));
        loginFailed = new JLabel("Invalid Username/Password");
        loginFailed.setForeground(Color.red);
        loginFailed.setAlignmentX(CENTER_ALIGNMENT);
        add(loginFailed);
        loginFailed.setVisible(false);
        add(Box.createRigidArea(new Dimension(0, 35)));

        userInterface = new JPanel();
        userInterface.setBackground(Utilities.backgroundColour);
        userInterface.setLayout(new BoxLayout(userInterface, BoxLayout.Y_AXIS));

        usernameField = new JTextField();
        usernameField.setPreferredSize(textFieldSize);
        usernameField.setMaximumSize(textFieldSize);
        usernameField.setAlignmentX(CENTER_ALIGNMENT);

        passwordField = new JTextField();
        passwordField.setPreferredSize(textFieldSize);
        passwordField.setMinimumSize(textFieldSize);
        passwordField.setMaximumSize(textFieldSize);
        passwordField.setAlignmentX(CENTER_ALIGNMENT);

        usernameText = new JLabel("Username:");
        usernameText.setAlignmentX(CENTER_ALIGNMENT);
        passwordText = new JLabel("Password:");
        passwordText.setAlignmentX(CENTER_ALIGNMENT);

        login = new JButton("LOG IN NOW");
        login.setAlignmentX(CENTER_ALIGNMENT);

        userInterface.add(usernameText);
        userInterface.add(usernameField);
        userInterface.add(Box.createRigidArea(Utilities.buttonGap));
        userInterface.add(passwordText);
        userInterface.add(passwordField);
        userInterface.add(login);
        userInterface.setAlignmentX(Component.CENTER_ALIGNMENT);

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

    public void invalidLogin() {
        this.loginFailed.setVisible(true);
    }

}
