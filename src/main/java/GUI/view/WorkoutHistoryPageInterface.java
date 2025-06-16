package GUI.view;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionListener;

import GUI.model.Workout;

//workouthistory interface for model use

public interface WorkoutHistoryPageInterface {

    void populateWorkouts(List<Workout> workouts);

    void previousWorkoutsListener(ListSelectionListener e);

    void addBackListener(ActionListener e);

    void updateDisplay(String s);

    Workout getWorkoutAtIndex(int i);
}