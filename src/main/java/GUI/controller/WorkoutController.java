package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.view.WorkoutPageInterface;

public class WorkoutController {
    public WorkoutController(DatabaseManager model, ApplicationController controller, WorkoutPageInterface view) {

        view.addExercisesList(model.getDefaultExcercises());
        view.addBackListener(e -> controller.showHomePage(null));
    }
}
