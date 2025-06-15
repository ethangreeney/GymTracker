package GUI.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GUI.model.User;

public class HomePage extends JPanel {
    private final String asciiArt = """


            ██╗  ██╗ ██████╗ ███╗   ███╗███████╗
            ██║  ██║██╔═══██╗████╗ ████║██╔════╝
            ███████║██║   ██║██╔████╔██║█████╗
            ██╔══██║██║   ██║██║╚██╔╝██║██╔══╝
            ██║  ██║╚██████╔╝██║ ╚═╝ ██║███████╗
            ╚═╝  ╚═╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝

            """;

    private final JLabel userGreeting;
    private final JLabel homeArt;

    private JPanel buttonPanel;
    private JButton workout;
    private JButton workoutHistory;
    private JButton userInfo;
    private JButton goals;

    public HomePage() {
        setBackground(Utilities.backgroundColour);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        userGreeting = new JLabel("Welcome *insert username");
        userGreeting.setHorizontalAlignment(SwingConstants.CENTER);
        userGreeting.setAlignmentX(CENTER_ALIGNMENT);
        userGreeting.setAlignmentY(TOP_ALIGNMENT);

        homeArt = new JLabel(Utilities.toHtmlFormat(asciiArt));
        homeArt.setHorizontalAlignment(SwingConstants.CENTER);
        homeArt.setAlignmentX(CENTER_ALIGNMENT);

        add(Box.createRigidArea(Utilities.buttonGap));

        add(userGreeting);
        add(homeArt);

        buttonPanel = new JPanel();
        buttonPanel.setBackground(this.getBackground());
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 80, 30, 80));

        workout = new JButton("Workout 🏃");

        workoutHistory = new JButton("Workout History 📖");

        userInfo = new JButton("User Information 📊");

        goals = new JButton("Goals 🌟");

        buttonPanel.add(workout);
        buttonPanel.add(workoutHistory);
        buttonPanel.add(userInfo);
        buttonPanel.add(goals);

        add(buttonPanel);
    }

    public void setWelcomeMessage(User user) {
        userGreeting.setText("Welcome " + user.getUsername());
    }

    public void addWorkoutListener(ActionListener e) {
        workout.addActionListener(e);
    }

    public void addWorkoutHistoryListener(ActionListener e) {
        workoutHistory.addActionListener(e);
    }

    public void addUserInfoListener(ActionListener e) {
        userInfo.addActionListener(e);
    }

    public void addGoalListener(ActionListener e) {
        goals.addActionListener(e);
    }

}