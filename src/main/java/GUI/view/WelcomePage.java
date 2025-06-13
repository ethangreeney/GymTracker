package GUI.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.Border;

public class WelcomePage extends JPanel {
    private JLabel welcomeText;
    private JButton loginButton;
    private JButton registerButton;

    JPanel buttonPanel;

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
        this.loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(120, 40));
        this.registerButton = new JButton("Register");
        registerButton.setPreferredSize(new Dimension(120, 40));
        setSize(MainFrame.WIDTH, MainFrame.HEIGHT);
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        add(welcomeText, BorderLayout.NORTH);
        add(registerButton, BorderLayout.CENTER);
        add(loginButton, BorderLayout.CENTER);

    }

    private void setButtonPanel() {
        this.buttonPanel = new JPanel();
        this.buttonPanel.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }
}
