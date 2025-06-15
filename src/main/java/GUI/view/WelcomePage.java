package GUI.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WelcomePage extends JPanel implements WelcomePageInterface {
    private final JLabel welcomeText;
    private final JLabel welcomeText2;
    private final JButton loginButton;
    private final JButton registerButton;

    JPanel buttonPanel;

    private final Dimension buttonSize = new Dimension(200, 60);

    private final String asciiArt = """


             ██████╗██╗   ██╗███╗   ███╗
            ██╔════╝╚██╗ ██╔╝████╗ ████║
            ██║  ███╗╚████╔╝ ██╔████╔██║
            ██║   ██║ ╚██╔╝  ██║╚██╔╝██║
            ╚██████╔╝  ██║   ██║ ╚═╝ ██║
             ╚═════╝   ╚═╝   ╚═╝     ╚═╝
            """;

    private final String asciiArt2 = """
            ████████╗██████╗  █████╗  ██████╗██╗  ██╗███████╗██████╗
            ╚══██╔══╝██╔══██╗██╔══██╗██╔════╝██║ ██╔╝██╔════╝██╔══██╗
               ██║   ██████╔╝███████║██║     █████╔╝ █████╗  ██████╔╝
               ██║   ██╔══██╗██╔══██║██║     ██╔═██╗ ██╔══╝  ██╔══██╗
               ██║   ██║  ██║██║  ██║╚██████╗██║  ██╗███████╗██║  ██║
               ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝
            """;

    public WelcomePage() {

        String htmlFormattedArt = Utilities.toHtmlFormat(asciiArt);
        this.welcomeText = new JLabel(htmlFormattedArt);

        String htmlFormattedArt2 = Utilities.toHtmlFormat(asciiArt2);
        this.welcomeText2 = new JLabel(htmlFormattedArt2);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Utilities.backgroundColour);

        add(welcomeText);
        this.welcomeText.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.welcomeText.setHorizontalAlignment(SwingConstants.CENTER);

        add(welcomeText2);
        this.welcomeText2.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.welcomeText2.setHorizontalAlignment(SwingConstants.CENTER);

        this.loginButton = new JButton("Login");
        loginButton.setPreferredSize(buttonSize);
        loginButton.setMinimumSize(buttonSize);
        loginButton.setMaximumSize(buttonSize);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.registerButton = new JButton("Register");
        registerButton.setPreferredSize(buttonSize);
        registerButton.setMinimumSize(buttonSize);
        registerButton.setMaximumSize(buttonSize);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(this.getBackground());

        buttonPanel.add(loginButton);
        buttonPanel.add(Box.createRigidArea(Utilities.buttonGap));
        buttonPanel.add(registerButton);

        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createRigidArea(Utilities.buttonGap));
        add(buttonPanel);

    }

    @Override
    public void addLoginListener(ActionListener action) {
        loginButton.addActionListener(action);
    }

    @Override
    public void addRegisterListener(ActionListener action) {
        registerButton.addActionListener(action);
    }

}
