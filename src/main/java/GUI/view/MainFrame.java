package GUI.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    private final CardLayout cardLayout;
    private final JPanel cardPanelContainer;

    public static final String WELCOME_PAGE = "WelcomePanel";
    public static final String LOGIN_PAGE = "LoginPanel";
    public static final String HOME_PAGE = "HomePanel";
    public static final String REGISTER_PAGE = "RegisterPanel";

    public static final int FRAME_WIDTH = 600;
    public static final int FRAME_HEIGHT = 500;

    public MainFrame() {
        setTitle("GymTracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
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