package GUI.controller;

import javax.swing.JList;

import GUI.model.DatabaseManager;
import GUI.model.Workout;
import GUI.view.WorkoutHistoryPageInterface;

public class WorkoutHistoryController {

    public WorkoutHistoryController(DatabaseManager model, ApplicationController controller,
            WorkoutHistoryPageInterface view) {

        view.addBackListener(e -> controller.showHomePage(controller.getCurrentUser()));
        view.previousWorkoutsListener(e -> {
            // get the list of workouts that the user is selecting from in the GUI
            @SuppressWarnings("unchecked")
            JList<Workout> sourceList = (JList<Workout>) e.getSource();

            int selectedIndex = sourceList.getSelectedIndex();

            if (selectedIndex != -1) {
                view.updateDisplay(view.getWorkoutAtIndex(selectedIndex).toWorkoutContents());
            }

        });

    }

}
