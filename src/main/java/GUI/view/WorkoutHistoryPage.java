package GUI.view;

import java.awt.Dimension;

import javax.swing.*;

public class WorkoutHistoryPage extends JPanel {

    String ascii = """

            ██╗  ██╗██╗███████╗████████╗ ██████╗ ██████╗ ██╗   ██╗
            ██║  ██║██║██╔════╝╚══██╔══╝██╔═══██╗██╔══██╗╚██╗ ██╔╝
            ███████║██║███████╗   ██║   ██║   ██║██████╔╝ ╚████╔╝
            ██╔══██║██║╚════██║   ██║   ██║   ██║██╔══██╗  ╚██╔╝
            ██║  ██║██║███████║   ██║   ╚██████╔╝██║  ██║   ██║
            ╚═╝  ╚═╝╚═╝╚══════╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝   ╚═╝

            """;

    private JLabel historyArt;
    private JList<String> previousWorkouts;
    private JTextArea displayWorkout;
    private JButton back;
    private JButton deleteWorkout;

    private final Dimension textFieldSize = new Dimension(215, 20);

    private JPanel topBar;
    private JPanel bottomPanel;

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

        previousWorkouts = new JList<>();
        previousWorkouts.setAlignmentX(CENTER_ALIGNMENT);
        previousWorkouts.setMaximumSize(textFieldSize);
        previousWorkouts.setMinimumSize(textFieldSize);
        add(previousWorkouts);

    }

}
