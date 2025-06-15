package GUI.view;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class WorkoutPage extends JPanel {
    private final String asciiArt = """

            ██╗    ██╗ ██████╗ ██████╗ ██╗  ██╗ ██████╗ ██╗   ██╗████████╗
            ██║    ██║██╔═══██╗██╔══██╗██║ ██╔╝██╔═══██╗██║   ██║╚══██╔══╝
            ██║ █╗ ██║██║   ██║██████╔╝█████╔╝ ██║   ██║██║   ██║   ██║
            ██║███╗██║██║   ██║██╔══██╗██╔═██╗ ██║   ██║██║   ██║   ██║
            ╚███╔███╔╝╚██████╔╝██║  ██║██║  ██╗╚██████╔╝╚██████╔╝   ██║
             ╚══╝╚══╝  ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝  ╚═════╝    ╚═╝


            """;

    private final JLabel workoutArt;
    private final JPanel topBar;
    private final JButton back;

    private final JPanel landing;
    private final JTextArea exerciseName;
    private final JLabel exerciseNameLabel;

    /*
     * 
     * private final JPanel Landing;
     * private final JPanel page1;
     * private final JPanel page2;
     */

    public WorkoutPage() {
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

        add(topBar);

        workoutArt = new JLabel(Utilities.toHtmlFormat(asciiArt));
        workoutArt.setAlignmentX(CENTER_ALIGNMENT);
        workoutArt.setHorizontalAlignment(SwingConstants.CENTER);

        add(workoutArt);

        landing = new JPanel();
        landing.setLayout(new BoxLayout(landing, BoxLayout.Y_AXIS));

        exerciseNameLabel = new JLabel("Exercise name:");
        exerciseNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        exerciseNameLabel.setAlignmentX(CENTER_ALIGNMENT);
        landing.add(exerciseNameLabel);

        exerciseName = new JTextArea();
        exerciseName.setAlignmentX(CENTER_ALIGNMENT);
        landing.add(exerciseName);

        add(landing);

    }

}
