package GUI.controller;

import CLI.Exercise;
import GUI.model.DatabaseManager;
import GUI.model.Workout;
import GUI.view.WorkoutPageInterface;

public class WorkoutController {

    public WorkoutController(DatabaseManager model, ApplicationController controller, WorkoutPageInterface view) {

        Workout currentWorkout = new Workout();

        view.addExercisesList(model.getDefaultExcercises());
        view.addBackListener(e -> controller.showHomePage(null));

        view.addFirstNextListener(e -> {

            String workoutName = view.getWorkoutName().trim();

            if (workoutName.equals("")) {
                view.invalidWorkoutName();
                return;
            }

            currentWorkout.setName(view.getWorkoutName());
            view.toSecondPage();

        });

        view.addSecondNextListener(e -> {

            String exerciseName = view.getExerciseChoice().trim();

            if (exerciseName.equals("")) {
                view.invalidExerciseName();
                return;
            }

            Exercise currentExercise = new Exercise(exerciseName);

        });

    }
}
