package GUI.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WelcomePage extends JPanel {
    private JLabel welcomeText;
    private JButton loginButton;
    private JButton registerButton;

    JPanel buttonPanel;

    private Dimension buttonSize = new Dimension(200, 60);

    public final String asciiArt = """
              _____                _____                _
             / ____|              |_   _|              | |
            | |  __ _   _ _ __ ___  | |  _ __ __ _  ___| | _____ _ __
            | | |_ | | | | '_ ` _ \\ | | | '__/ _` |/ __| |/ / _ \\ '__|
            | |__| | |_| | | | | | || |_| | | (_| | (__|   <  __/ |
             \\_____|\\___, |_| |_| |_|_____|_|  \\__,_|\\___|_|\\_\\___|_|
                     __/ |
                    |___/
            """;

    public WelcomePage() {
        String htmlFormattedArt = "<html><pre><font face='Monospaced'>" + asciiArt + "</font></pre></html>";
        this.welcomeText = new JLabel(htmlFormattedArt);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.LIGHT_GRAY);

        this.welcomeText.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.welcomeText.setHorizontalAlignment(SwingConstants.CENTER);

        // 3. Create the buttons
        this.loginButton = new JButton("Login");
        loginButton.setPreferredSize(buttonSize); // A bit wider for better centering feel
        loginButton.setMinimumSize(buttonSize);
        loginButton.setMaximumSize(buttonSize);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center it horizontally

        this.registerButton = new JButton("Register");
        registerButton.setPreferredSize(buttonSize);
        registerButton.setMinimumSize(buttonSize);
        registerButton.setMaximumSize(buttonSize);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center it horizontally

        this.buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Stack buttons vertically
        buttonPanel.setBackground(this.getBackground()); // Match WelcomePage background (or make transparent)
        // buttonPanel.setOpaque(false); // Alternative: make panel transparent

        // Add buttons and gap to the buttonPanel
        buttonPanel.add(loginButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // 10px vertical gap
        buttonPanel.add(registerButton);

        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button panel itself

        // 5. Add components to the main WelcomePage panel
        add(this.welcomeText);
        add(Box.createRigidArea(new Dimension(0, 30))); // Space between text and button panel
        add(buttonPanel);

    }

}
