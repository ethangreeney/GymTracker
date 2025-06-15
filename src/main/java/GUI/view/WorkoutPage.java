package GUI.view;

import java.awt.Color;
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
    private final JLabel warningText;
    private final JPanel topBar;
    private final JButton back;
    private final JButton firstNext;
    private final JButton secondNext;
    private final JButton thirdNext;

    private final JPanel landing;
    private final JTextArea workoutName;
    private final JLabel workoutNameLabel;

    private final Dimension textFieldSize = new Dimension(215, 20);

    private final JPanel selectExercise;
    private final JLabel exercisesLabel;
    private final JComboBox<String> exercises;
    private final JLabel setsLabel;
    private final JComboBox<Integer> sets;

    private final JPanel repsAndWeight;
    private final JLabel repsLabel;
    private final JTextArea reps;
    private final JLabel weightLabel;
    private final JTextArea weight;

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

        warningText = new JLabel(" ");
        warningText.setForeground(Color.red);
        warningText.setAlignmentX(CENTER_ALIGNMENT);
        warningText.setHorizontalAlignment(SwingConstants.CENTER);
        warningText.setAlignmentY(TOP_ALIGNMENT);
        add(warningText);

        landing = new JPanel();
        landing.setLayout(new BoxLayout(landing, BoxLayout.Y_AXIS));
        landing.setBackground(this.getBackground());

        // picking workout

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

        // picking exercise and sets

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
        selectExercise.add(exercises);

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

        selectExercise.add(Box.createRigidArea(Utilities.buttonGap));

        selectExercise.add(secondNext);

        // picking reps and weights

        repsAndWeight = new JPanel();
        repsAndWeight.setLayout(new BoxLayout(repsAndWeight, BoxLayout.Y_AXIS));
        repsAndWeight.setBackground(this.getBackground());

        repsLabel = new JLabel("Please enter number of reps: ");
        repsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        repsLabel.setAlignmentX(CENTER_ALIGNMENT);
        repsAndWeight.add(repsLabel);

        reps = new JTextArea();
        reps.setAlignmentX(CENTER_ALIGNMENT);
        reps.setMinimumSize(textFieldSize);
        reps.setMaximumSize(textFieldSize);
        reps.setPreferredSize(textFieldSize);
        repsAndWeight.add(reps);

        repsAndWeight.add(Box.createRigidArea(Utilities.buttonGap));

        weightLabel = new JLabel("Please enter the weight you are using: ");
        weightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        weightLabel.setAlignmentX(CENTER_ALIGNMENT);
        repsAndWeight.add(weightLabel);

        weight = new JTextArea();
        weight.setAlignmentX(CENTER_ALIGNMENT);
        weight.setMinimumSize(textFieldSize);
        weight.setMaximumSize(textFieldSize);
        weight.setPreferredSize(textFieldSize);
        repsAndWeight.add(weight);

        thirdNext = new JButton("next");
        thirdNext.setAlignmentX(CENTER_ALIGNMENT);

        repsAndWeight.add(Box.createRigidArea(Utilities.buttonGap));

        repsAndWeight.add(thirdNext);

        add(repsAndWeight);
        repsAndWeight.setVisible(false);

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
    public String getReps() {
        return reps.getText();
    }

    @Override
    public String getWeight() {
        return weight.getText();
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
    public void addThirdNextListener(ActionListener e) {
        thirdNext.addActionListener(e);
    }

    @Override
    public void reset() {
        warningText.setText(" ");
        workoutName.setText("");
        exercises.removeAllItems();
        sets.removeAllItems();
        reps.setText("");
        weight.setText("");
        selectExercise.setVisible(false);
        repsAndWeight.setVisible(false);
        landing.setVisible(true);
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
        warningText.setText(" ");
        landing.setVisible(false);
        repsAndWeight.setVisible(false);
        selectExercise.setVisible(true);
    }

    @Override
    public void toThirdPage() {
        warningText.setText(" ");
        reps.setText("");
        weight.setText("");
        landing.setVisible(false);
        selectExercise.setVisible(false);
        repsAndWeight.setVisible(true);
    }

    @Override
    public void SetNumber(int setNumber) {
        warningText.setText("Current set: " + setNumber);
        warningText.setForeground(Color.black);
    }

    @Override
    public void invalidWorkoutName() {
        warningText.setText("Invalid workout name!");
        warningText.setForeground(Color.red);
    }

    @Override
    public void invalidExerciseName() {
        warningText.setText("Invalid exercise name!");
        warningText.setForeground(Color.red);
    }

    @Override
    public void invalidReps() {
        warningText.setText("Invalid number of reps!");
        warningText.setForeground(Color.red);
    }

    @Override
    public void invalidWeight() {
        warningText.setText("Invalid weight!");
        warningText.setForeground(Color.red);
    }

}
