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

    public static final String LOGIN_PANEL = "LOGIN";
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 800;

    public MainFrame() {
        setTitle("GymTracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        this.cardLayout = new CardLayout();
        this.cardPanelContainer = new JPanel(cardLayout);

        LoginPage login = new LoginPage();
        cardPanelContainer.add(login, LOGIN_PANEL);

        add(cardPanelContainer, BorderLayout.CENTER);

        showPanel(LOGIN_PANEL);

    }

    public void showPanel(String panelName) {
        cardLayout.show(cardPanelContainer, panelName);
    }

}