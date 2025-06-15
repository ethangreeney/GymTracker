package GUI.view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.apache.derby.impl.jdbc.Util;

public class HomePage extends JPanel {
    private String asciiArt = """


            ██╗  ██╗ ██████╗ ███╗   ███╗███████╗
            ██║  ██║██╔═══██╗████╗ ████║██╔════╝
            ███████║██║   ██║██╔████╔██║█████╗
            ██╔══██║██║   ██║██║╚██╔╝██║██╔══╝
            ██║  ██║╚██████╔╝██║ ╚═╝ ██║███████╗
            ╚═╝  ╚═╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝

            """;

    private JLabel userGreeting;
    private JLabel homeArt;

    private JPanel buttonPanel;
    private JButton workout;
    private JButton workoutHistory;
    private JButton userInfo;
    private JButton logOut;

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

        add(userGreeting);
        add(homeArt);

        buttonPanel = new JPanel();
        buttonPanel.setBackground(this.getBackground());
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        workout = new JButton("Workout");
        workoutHistory = new JButton("Workout History");
        userInfo = new JButton("userInfo");
        logOut = new JButton("Logout");

        buttonPanel.add(workout);
        buttonPanel.add(workoutHistory);
        buttonPanel.add(userInfo);
        buttonPanel.add(logOut);

        add(buttonPanel);
    }

}