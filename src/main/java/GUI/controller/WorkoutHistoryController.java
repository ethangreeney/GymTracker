package GUI.controller;

import javax.swing.JList;

import GUI.model.DatabaseManager;
import GUI.view.WorkoutHistoryPageInterface;

public class WorkoutHistoryController {

    public WorkoutHistoryController(DatabaseManager model, ApplicationController controller,
            WorkoutHistoryPageInterface view) {

        view.addBackListener(e -> controller.showHomePage(controller.getCurrentUser()));
        view.previousWorkoutsListener(e -> {

            @SuppressWarnings("unchecked")
            JList<String> sourceList = (JList<String>) e.getSource();

            int selectedIndex = sourceList.getSelectedIndex();

            if (selectedIndex != -1) {
                view.updateDisplay(view.getWorkoutAtIndex(selectedIndex).toString());
            }

        });

    }

}
