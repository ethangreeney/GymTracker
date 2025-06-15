package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.model.Workout;
import GUI.view.WorkoutPageInterface;

public class WorkoutController {
    public WorkoutController(DatabaseManager model, ApplicationController controller, WorkoutPageInterface view) {

        Workout currentWorkout = new Workout();

        view.addExercisesList(model.getDefaultExcercises());
        view.addBackListener(e -> controller.showHomePage(null));

        view.addFirstNextListener(e -> {

            currentWorkout.setName(view.getWorkoutName());
            view.toSecondPage();

        });

    }
}
