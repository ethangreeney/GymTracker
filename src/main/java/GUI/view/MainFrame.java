package GUI.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanelContainer;

    private HomePage home;
    private LoginPageInterface login;
    private RegisterPageInterface register;
    private WorkoutHistoryPage history;
    private WorkoutPage workout;
    private WelcomePageInterface welcome;

    public static final String WELCOME_PAGE = "WelcomePanel";
    public static final String LOGIN_PAGE = "LoginPanel";
    public static final String HOME_PAGE = "HomePanel";
    public static final String REGISTER_PAGE = "RegisterPanel";

    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;

    public MainFrame() {
        setTitle("GymTracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        this.cardLayout = new CardLayout();
        this.cardPanelContainer = new JPanel(cardLayout);

        add(cardPanelContainer, BorderLayout.CENTER);

    }

    public void showPanel(String panelName) {
        cardLayout.show(cardPanelContainer, panelName);
    }

    public void addPanel(JPanel toAdd, String panelName) {
        cardPanelContainer.add(toAdd, panelName);
    }

}