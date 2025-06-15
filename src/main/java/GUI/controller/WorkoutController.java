package GUI.controller;

import CLI.Exercise;
import GUI.model.DatabaseManager;
import GUI.model.Workout;
import GUI.view.WorkoutPageInterface;

public class WorkoutController {

    Exercise currentExercise;

    private int numberOfsets = 0;

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

            currentExercise = new Exercise(exerciseName);

            numberOfsets = view.getSetNumber();
            view.toThirdPage();

        });

        view.addThirdNextListener(e -> {

            if (numberOfsets == 0) {
                view.toSecondPage();
                return;
            }

            int reps;
            int weight;

            try {
                reps = Integer.parseInt(view.getReps());
            } catch (NumberFormatException exception) {
                view.invalidReps();
                return;
            }
            try {
                weight = Integer.parseInt(view.getWeight());
            } catch (NumberFormatException exception) {
                view.invalidWeight();
                return;
            }

            currentExercise.addSet(weight, reps);

            numberOfsets--;

            view.toThirdPage();

        });

    }
}
