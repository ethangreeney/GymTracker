package GUI.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginPage extends JPanel implements LoginPageInterface {
    private final JLabel loginText;
    private final JLabel usernameText;
    private final JLabel passwordText;
    private final JLabel loginFailed;
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JButton login;
    private final JPanel userInterface;
    private final Dimension textFieldSize = new Dimension(215, 35);

    private final String asciiArt = """



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
        loginFailed = new JLabel(" ");
        loginFailed.setAlignmentX(CENTER_ALIGNMENT);
        add(loginFailed);
        add(Box.createRigidArea(new Dimension(0, 35)));

        userInterface = new JPanel();
        userInterface.setBackground(Utilities.backgroundColour);
        userInterface.setLayout(new BoxLayout(userInterface, BoxLayout.Y_AXIS));

        usernameField = new JTextField();
        usernameField.setPreferredSize(textFieldSize);
        usernameField.setMaximumSize(textFieldSize);
        usernameField.setAlignmentX(CENTER_ALIGNMENT);

        passwordField = new JPasswordField();
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

    @Override
    public void addLoginListener(ActionListener e) {
        login.addActionListener(e);
    }

    @Override
    public String getUsername() {
        return usernameField.getText();
    }

    @Override
    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    @Override
    public void invalidLogin() {
        loginFailed.setForeground(Color.red);
        loginFailed.setText("Invalid Username/Password");
    }

    public Dimension getTextFieldSize() {
        return textFieldSize;
    }

    @Override
    public void reset() {
        usernameField.setText("");
        passwordField.setText("");
        loginFailed.setText("");
    }

}
