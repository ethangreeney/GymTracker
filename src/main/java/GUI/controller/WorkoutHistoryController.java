package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.view.WorkoutHistoryPageInterface;

public class WorkoutHistoryController {

    public WorkoutHistoryController(DatabaseManager model, ApplicationController controller,
            WorkoutHistoryPageInterface view) {

        view.addBackListener(e -> controller.showHomePage(controller.getCurrentUser()));
        view.previousWorkoutsListener(e -> view.updateDisplay(e.toString()));

    }

}
