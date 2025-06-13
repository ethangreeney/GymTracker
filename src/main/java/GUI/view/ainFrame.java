package GUI.view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanelContainer;

    private omePage home;
    private oginPage login;
    private egisterPage register;
    private WorkoutHistoryPage history;
    private WorkoutPage workout;

    public ainFrame() {
        setTitle("GymTracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
    }

}
