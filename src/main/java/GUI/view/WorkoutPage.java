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
    private final JButton back;
    private final JButton firstNext;
    private final JButton secondNext;

    private final JPanel landing;
    private final JTextArea workoutName;
    private final JLabel workoutNameLabel;

    private final Dimension textFieldSize = new Dimension(215, 20);

    private final JPanel selectExercise;
    private final JLabel exercisesLabel;
    private final JComboBox<String> exercises;
    private final JLabel setsLabel;
    private final JComboBox<Integer> sets;

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

        firstNext = new JButton("next");
        firstNext.setAlignmentX(CENTER_ALIGNMENT);
        landing.add(firstNext);
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

        exercises = new JComboBox<>();
        exercises.setEditable(true);
        exercises.setMinimumSize(textFieldSize);
        exercises.setMaximumSize(textFieldSize);
        exercises.setAlignmentX(CENTER_ALIGNMENT);

        selectExercise.add(Box.createRigidArea(Utilities.buttonGap));

        setsLabel = new JLabel("Please enter number of sets: ");
        setsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        setsLabel.setAlignmentX(CENTER_ALIGNMENT);
        selectExercise.add(setsLabel);

        sets = new JComboBox<>();
        sets.setAlignmentX(CENTER_ALIGNMENT);
        sets.setMinimumSize(textFieldSize);
        sets.setMaximumSize(textFieldSize);
        sets.setPreferredSize(textFieldSize);
        selectExercise.add(sets);

        secondNext = new JButton("next");
        secondNext.setAlignmentX(CENTER_ALIGNMENT);

        selectExercise.add(exercises);
        selectExercise.add(secondNext);

    }

    @Override
    public String getWorkoutName() {
        return workoutName.getText();
    }

    @Override
    public String getExerciseChoice() {
        return (String) exercises.getSelectedItem();
    }

    @Override
    public Integer getSetNumber() {
        return (Integer) sets.getSelectedItem();
    }

    @Override
    public void addFirstNextListener(ActionListener e) {
        firstNext.addActionListener(e);
    }

    @Override
    public void addSecondNextListener(ActionListener e) {
        secondNext.addActionListener(e);
    }

    @Override
    public void reset() {
        workoutName.setText("");
        exercises.removeAllItems();
        sets.removeAllItems();
    }

    @Override
    public void addBackListener(ActionListener e) {
        back.addActionListener(e);
    }

    @Override
    public void addExercisesList(List<String> exerciseList) {
        for (String s : exerciseList) {
            exercises.addItem(s);
        }
    }

    @Override
    public void addSetList(List<Integer> setList) {
        for (Integer i : setList) {
            sets.addItem(i);
        }
    }

    @Override
    public void toSecondPage() {
        landing.setVisible(false);
        selectExercise.setVisible(true);
    }

}
