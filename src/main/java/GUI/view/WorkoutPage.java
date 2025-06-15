package GUI.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class WorkoutPage extends JPanel implements WorkoutPageInterface {
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
    private final JButton nextPage;

    private final JPanel landing;
    private final JTextArea workoutName;
    private final JLabel workoutNameLabel;

    private final Dimension textFieldSize = new Dimension(215, 35);

    private final JPanel selectExercise;

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
        topBar.setMaximumSize(Utilities.topBarGap(topBar));

        add(topBar);

        workoutArt = new JLabel(Utilities.toHtmlFormat(asciiArt));
        workoutArt.setAlignmentX(CENTER_ALIGNMENT);
        workoutArt.setHorizontalAlignment(SwingConstants.CENTER);

        add(workoutArt);

        landing = new JPanel();
        landing.setLayout(new BoxLayout(landing, BoxLayout.Y_AXIS));
        landing.setBackground(this.getBackground());

        workoutNameLabel = new JLabel("Workout name:");
        workoutNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        workoutNameLabel.setAlignmentX(CENTER_ALIGNMENT);
        landing.add(workoutNameLabel);

        landing.add(Box.createRigidArea(Utilities.buttonGap));

        workoutName = new JTextArea();
        workoutName.setAlignmentX(CENTER_ALIGNMENT);
        workoutName.setMinimumSize(textFieldSize);
        workoutName.setMaximumSize(textFieldSize);
        workoutName.setPreferredSize(textFieldSize);
        landing.add(workoutName);

        nextPage = new JButton("next");
        nextPage.setAlignmentX(CENTER_ALIGNMENT);
        landing.add(nextPage);
        add(landing);

        selectExercise = new JPanel();
        add(selectExercise);
        selectExercise.setVisible(false);

    }

    @Override
    public String getWorkoutName() {
        return workoutName.getText();
    }

    @Override
    public void addNextPageListener(ActionListener e) {
        nextPage.addActionListener(e);
    }

    @Override
    public void userExercises(List<String> StringList) {

    }

    @Override
    public void reset() {
        workoutName.setText("");
    }

    @Override
    public void addBackListener(ActionListener e) {
        back.addActionListener(e);
    }

}
