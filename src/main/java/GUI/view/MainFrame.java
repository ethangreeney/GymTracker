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
    public static final String GOAL_PAGE = "GoalPage";
    public static final String USER_INFO_PAGE = "UserInfoPage";
    public static final String WORKOUT_HISTORY_PAGE = "WorkoutHistoryPage";
    public static final String NEW_WORKOUT_PAGE = "NewWorkoutPage";

    public static final int FRAME_WIDTH = 600;
    public static final int FRAME_HEIGHT = 500;

    // main frame for program
    public MainFrame() {
        // setting constants for the program
        setTitle("GymTracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);

        // setting cardLayout so a page type program can be used
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