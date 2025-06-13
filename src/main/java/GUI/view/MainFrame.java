package GUI.view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanelContainer;

    private HomePage home;
    private LoginPage login;
    private RegisterPage register;
    private WorkoutHistoryPage history;
    private WorkoutPage workout;
    private WelcomePage welcome;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public MainFrame() {
        setTitle("GymTracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        this.cardLayout = new CardLayout();
        this.cardPanelContainer = new JPanel(cardLayout);

        WelcomePage welcome = new WelcomePage();
        cardPanelContainer.add(welcome, "WelcomePanel");

        add(cardPanelContainer, BorderLayout.CENTER);

        showPanel("WelcomePanel");

    }

    public void showPanel(String panelName) {
        cardLayout.show(cardPanelContainer, panelName);
    }

    public void addPanel(JPanel toAdd) {
        cardPanelContainer.add(toAdd);
    }

}