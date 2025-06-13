package GUI.view;

import java.awt.Color;

import javax.swing.*;

public class WelcomePage extends JPanel {
    private JLabel welcomeText;
    private JButton loginButton;
    private JButton registerButton;

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
        JLabel welcomeText = new JLabel(htmlFormattedArt);
        JButton loginbuButton = new JButton("Login");
        loginbuButton.setSize(150, 150);
        JButton registerButton = new JButton("Register");
        registerButton.setSize(150, 150);
        setSize(WIDTH, HEIGHT);
        setBackground(Color.LIGHT_GRAY);

        add(welcomeText);
        add(registerButton);
        add(loginButton);

    }
}
