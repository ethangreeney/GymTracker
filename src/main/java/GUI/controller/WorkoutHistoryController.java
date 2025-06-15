package GUI.controller;

import javax.swing.JList;

import GUI.model.DatabaseManager;
import GUI.view.WorkoutHistoryPageInterface;

public class WorkoutHistoryController {

    public WorkoutHistoryController(DatabaseManager model, ApplicationController controller,
            WorkoutHistoryPageInterface view) {

        view.addBackListener(e -> controller.showHomePage(controller.getCurrentUser()));
        view.previousWorkoutsListener(e -> {

            JList<String> sourceList = (JList<String>) e.getSource();

            view.updateDisplay(view.getWorkoutAtIndex(sourceList.getSelectedIndex()).toString());

        });

    }

}
