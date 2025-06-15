package GUI.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class WorkoutHistoryPage extends JPanel {

    String ascii = """

            ██╗  ██╗██╗███████╗████████╗ ██████╗ ██████╗ ██╗   ██╗
            ██║  ██║██║██╔════╝╚══██╔══╝██╔═══██╗██╔══██╗╚██╗ ██╔╝
            ███████║██║███████╗   ██║   ██║   ██║██████╔╝ ╚████╔╝
            ██╔══██║██║╚════██║   ██║   ██║   ██║██╔══██╗  ╚██╔╝
            ██║  ██║██║███████║   ██║   ╚██████╔╝██║  ██║   ██║
            ╚═╝  ╚═╝╚═╝╚══════╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝   ╚═╝

            """;

    private final JLabel historyArt;
    private final JList<String> previousWorkouts;
    private final JTextArea displayWorkout;
    private final JButton back;

    private final Dimension textFieldSize = new Dimension(215, 20);

    private final JPanel topBar;
    private final JPanel bottomPanel;
    private final JScrollPane scrollPane;
    private final JScrollPane scrollPane2;

    public WorkoutHistoryPage() {
        setBackground(Utilities.backgroundColour);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createRigidArea(Utilities.buttonGap));

        topBar = new JPanel();
        topBar.setBackground(this.getBackground());
        topBar.setLayout(new BoxLayout(topBar, BoxLayout.X_AXIS));

        back = new JButton("Back");
        topBar.add(Box.createHorizontalGlue());
        topBar.add(back);
        topBar.add(Box.createHorizontalStrut(20));
        topBar.setMaximumSize(Utilities.topBarGap(topBar));

        add(topBar);

        historyArt = new JLabel(Utilities.toHtmlFormat(ascii));
        historyArt.setAlignmentX(CENTER_ALIGNMENT);
        historyArt.setHorizontalAlignment(SwingConstants.CENTER);
        add(historyArt);

        add(Box.createRigidArea(Utilities.buttonGap));

        bottomPanel = new JPanel();
        bottomPanel.setBackground(this.getBackground());

        bottomPanel.setLayout(new GridLayout(1, 2, 10, 0));

        String[] workoutHistoryData = {
                "bench",
                "Interprative steph curry dancing",
                "Watching Lebron James",
                "Gaming and Gooning",
                "Morning Run",
                "Coaching the youngest person ever",
                "Fighting Lions",
                "Learning to be a F student",
                "Morning Meditation",
                "Afternoon Yoga",
                "Hustlers university workout",
                "Buying a new tesla"
        };

        String testString = """
                "bench",
                "Interprative steph curry dancing",
                "Watching Lebron James",
                "Gaming and Gooning",
                "Morning Run",
                "Coaching the youngest person ever",
                "Fighting Lions",
                "Learning to be a F student",
                "Morning Meditation",
                "Afternoon Yoga",
                "Hustlers university workout",
                "Buying a new tesla"
                "bench",
                "Interprative steph curry dancing",
                "Watching Lebron James",
                "Gaming and Gooning",
                "Morning Run",
                "Coaching the youngest person ever",
                "Fighting Lions",
                "Learning to be a F student",
                "Morning Meditation",
                "Afternoon Yoga",
                "Hustlers university workout",
                "Buying a new tesla"
                "bench",
                "Interprative steph curry dancing",
                "Watching Lebron James",
                "Gaming and Gooning",
                "Morning Run",
                "Coaching the youngest person ever",
                "Fighting Lions",
                "Learning to be a F student",
                "Morning Meditation",
                "Afternoon Yoga",
                "Hustlers university workout",
                "Buying a new tesla"
                """;

        previousWorkouts = new JList<>(workoutHistoryData);
        previousWorkouts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        previousWorkouts.setAlignmentX(LEFT_ALIGNMENT);

        scrollPane = new JScrollPane(previousWorkouts);
        scrollPane.setPreferredSize(new Dimension(250, 150));
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        displayWorkout = new JTextArea();
        displayWorkout.setAlignmentX(RIGHT_ALIGNMENT);
        displayWorkout.setEditable(false);
        displayWorkout.setLineWrap(true);
        displayWorkout.setWrapStyleWord(true);

        scrollPane2 = new JScrollPane(displayWorkout);
        scrollPane.setPreferredSize(new Dimension(250, 150));

        displayWorkout.setText(testString);
        bottomPanel.add(scrollPane2);

        bottomPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        add(bottomPanel);

    }

}
