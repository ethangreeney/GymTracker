package GUI.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
    private final JButton back;<<<<<<<HEAD
    private final JButton nextPage;=======
    private final JButton next1;
    private final JButton next2;>>>>>>>3061350(Workoutpage progress)

    private final JPanel landing;
    private final JTextArea workoutName;
    private final JLabel workoutNameLabel;

    private final Dimension textFieldSize = new Dimension(215, 35);

    private final JPanel selectExercise;
    private final JLabel exercisesLabel;
    private final JComboBox<String> exercises;

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
        selectExercise.setLayout(new BoxLayout(selectExercise, BoxLayout.Y_AXIS));
        selectExercise.setBackground(this.getBackground());

        add(selectExercise);
        selectExercise.setVisible(false);

        exercisesLabel = new JLabel("Select your exercise, or enter a custom one: ");
        exercisesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        exercisesLabel.setAlignmentX(CENTER_ALIGNMENT);
        selectExercise.add(exercisesLabel);

        selectExercise.add(Box.createRigidArea(Utilities.buttonGap));

        exercises = new JComboBox<String>();
        exercises.setEditable(true);
        exercises.setMinimumSize(textFieldSize);
        exercises.setMaximumSize(textFieldSize);
        exercises.setAlignmentX(CENTER_ALIGNMENT);

        next2 = new JButton("next");
        next2.setAlignmentX(CENTER_ALIGNMENT);

        selectExercise.add(exercises);
        selectExercise.add(next2);

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

    public void next2Listener(ActionListener e) {
        next2.addActionListener(e);
    }

    @Override
    public void reset() {
        workoutName.setText("");
    }

    @Override
    public void addBackListener(ActionListener e) {
        back.addActionListener(e);

    public void addExercisesList(List<String> exerciseList) {
        for (String s : exerciseList) {
            exercises.addItem(s);
        }
    }

}
