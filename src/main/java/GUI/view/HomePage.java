package GUI.view;

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

public class HomePage extends JPanel implements HomePageInterface {
    private final String asciiArt = """


            ██╗  ██╗ ██████╗ ███╗   ███╗███████╗
            ██║  ██║██╔═══██╗████╗ ████║██╔════╝
            ███████║██║   ██║██╔████╔██║█████╗
            ██╔══██║██║   ██║██║╚██╔╝██║██╔══╝
            ██║  ██║╚██████╔╝██║ ╚═╝ ██║███████╗
            ╚═╝  ╚═╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝

            """;

    private final JLabel homeArt;

    private final JLabel userGreeting;
    private final JPanel topBar;
    private final JButton logout;

    private final JPanel buttonPanel;
    private final JButton workout;
    private final JButton workoutHistory;
    private final JButton userInfo;
    private final JButton goals;

    public HomePage() {
        setBackground(Utilities.backgroundColour);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createRigidArea(Utilities.buttonGap));

        topBar = new JPanel();
        topBar.setBackground(this.getBackground());
        topBar.setLayout(new BoxLayout(topBar, BoxLayout.X_AXIS));

        userGreeting = new JLabel("Welcome *insert username");
        userGreeting.setHorizontalAlignment(SwingConstants.CENTER);
        userGreeting.setAlignmentX(CENTER_ALIGNMENT);
        topBar.add(Box.createHorizontalStrut(95));
        topBar.add(Box.createHorizontalGlue());
        topBar.add(userGreeting);

        logout = new JButton("Logout");
        topBar.add(Box.createHorizontalGlue());
        topBar.add(logout);
        topBar.add(Box.createHorizontalStrut(20));

        add(topBar);

        topBar.setMaximumSize(Utilities.topBarGap(topBar));

        homeArt = new JLabel(Utilities.toHtmlFormat(asciiArt));
        homeArt.setHorizontalAlignment(SwingConstants.CENTER);
        homeArt.setAlignmentX(CENTER_ALIGNMENT);

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

    @Override
    public void setWelcomeMessage(User user) {
        userGreeting.setText("Welcome, " + user.getName());
    }

    @Override
    public void addNewWorkoutListener(ActionListener e) {
        workout.addActionListener(e);
    }

    @Override
    public void addWorkoutHistoryListener(ActionListener e) {
        workoutHistory.addActionListener(e);
    }

    @Override
    public void addUserInfoListener(ActionListener e) {
        userInfo.addActionListener(e);
    }

    @Override
    public void addGoalListener(ActionListener e) {
        goals.addActionListener(e);
    }

    @Override
    public void addLogoutListener(ActionListener e) {
        logout.addActionListener(e);
    }

}