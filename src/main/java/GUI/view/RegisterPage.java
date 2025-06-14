package GUI.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RegisterPage extends JPanel {

    private String asciiArt = """



            ██████╗ ███████╗ ██████╗ ██╗███████╗████████╗███████╗██████╗
            ██╔══██╗██╔════╝██╔════╝ ██║██╔════╝╚══██╔══╝██╔════╝██╔══██╗
            ██████╔╝█████╗  ██║  ███╗██║███████╗   ██║   █████╗  ██████╔╝
            ██╔══██╗██╔══╝  ██║   ██║██║╚════██║   ██║   ██╔══╝  ██╔══██╗
            ██║  ██║███████╗╚██████╔╝██║███████║   ██║   ███████╗██║  ██║
            ╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═╝╚══════╝   ╚═╝   ╚══════╝╚═╝  ╚═╝
            """;

    private JLabel registerText;
    private JLabel duplicate;

    private JPanel registerArea;
    private JTextField username;
    private JTextField password;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton registerButton;

    private JPanel userInfo;
    private JTextField name;
    private JTextField age;
    private JTextField height;
    private JTextField weight;

    private Dimension textFieldSize = new Dimension(215, 35);
    private Dimension mediumGap = new Dimension(0, 15);
    private Dimension largerGap = new Dimension(0, 35);

    public RegisterPage() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Utilities.backgroundColour);

        registerText = new JLabel(Utilities.toHtmlFormat(asciiArt));
        registerText.setAlignmentX(CENTER_ALIGNMENT);
        registerText.setHorizontalAlignment(SwingConstants.CENTER);
        add(registerText);

        add(Box.createRigidArea(Utilities.buttonGap));
        duplicate = new JLabel("PLACEHOLDER");
        duplicate.setForeground(Color.RED);
        duplicate.setAlignmentX(CENTER_ALIGNMENT);
        add(duplicate);

        add(Box.createRigidArea(largerGap));

        registerArea = new JPanel();
        registerArea.setBackground(this.getBackground());
        registerArea.setLayout(new BoxLayout(registerArea, BoxLayout.Y_AXIS));

        usernameLabel = new JLabel("Username: ");
        usernameLabel.setAlignmentX(CENTER_ALIGNMENT);
        registerArea.add(usernameLabel);

        username = new JTextField();
        username.setPreferredSize(textFieldSize);
        username.setMaximumSize(textFieldSize);
        username.setMinimumSize(textFieldSize);
        username.setAlignmentX(CENTER_ALIGNMENT);
        registerArea.add(username);

        registerArea.add(Box.createRigidArea(mediumGap));

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setAlignmentX(CENTER_ALIGNMENT);
        registerArea.add(passwordLabel);

        password = new JTextField();
        password.setPreferredSize(textFieldSize);
        password.setMaximumSize(textFieldSize);
        password.setMinimumSize(textFieldSize);
        password.setAlignmentX(CENTER_ALIGNMENT);
        registerArea.add(password);

        registerButton = new JButton("Register");
        registerButton.setAlignmentX(CENTER_ALIGNMENT);
        registerArea.add(registerButton);

        add(registerArea);

    }

    public void registerListener(ActionListener e) {
        registerButton.addActionListener(e);
    }

    public void duplicateUsername() {
        duplicate.setText("Duplicate username, please enter a different username");
    }

    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public void validDetail() {
        registerArea.setVisible(false);
        userInfo.setVisible(true);
    }

}
