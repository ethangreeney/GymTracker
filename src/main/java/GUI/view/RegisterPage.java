package GUI.view;

import java.awt.Color;
import java.awt.Dimension;

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
    private Dimension textFieldSize = new Dimension(215, 35);

    private JPanel userInfo;
    private JTextField name;
    private JTextField age;
    private JTextField height;
    private JTextField weight;

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

        add(Box.createRigidArea(new Dimension(0, 35)));

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

        add(registerArea);

    }

}
