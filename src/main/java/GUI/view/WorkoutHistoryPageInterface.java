package GUI.view;

import java.util.List;

import javax.swing.event.ListSelectionListener;

import GUI.model.Workout;

public interface WorkoutHistoryPageInterface {

    void populateWorkouts(List<Workout> workouts);

    void previousWorkoutsListener(ListSelectionListener e);
}