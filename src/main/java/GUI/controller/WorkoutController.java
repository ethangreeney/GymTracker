package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.model.Exercise;
import GUI.model.Workout;
import GUI.view.WorkoutPageInterface;

public class WorkoutController {

    Exercise currentExercise;
    Workout currentWorkout;

    private int numberOfsets = 0;

    public WorkoutController(DatabaseManager model, ApplicationController controller, WorkoutPageInterface view) {

        currentWorkout = new Workout();

        view.addExercisesList(model.getDefaultExercises());
        view.addBackListener(e -> controller.showHomePage(controller.getCurrentUser()));

        view.addFirstNextListener(e -> {

            // check that workout name is not blank

            String workoutName = view.getWorkoutName().trim();

            if (workoutName.equals("")) {
                view.invalidWorkoutName();
                return;
            }

            currentWorkout.setName(view.getWorkoutName());
            // navigate to next panel of the gui page
            view.toSecondPage();

        });

        view.addSecondNextListener(e -> {

            // ensure that exercise choice is not just white space

            String exerciseName = view.getExerciseChoice().trim();

            if (exerciseName.equals("")) {
                view.invalidExerciseName();
                return;
            }

            // create a new exercise to populate with a list of <Weight, Rep> pairs
            currentExercise = new Exercise(exerciseName);

            numberOfsets = view.getSetNumber();
            view.toThirdPage(numberOfsets);

        });

        view.addThirdNextListener(e -> {

            int reps;
            int weight;

            // ensure that weight and reps can be parsed as ints

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

            if (--numberOfsets == 0) {
                currentWorkout.addExercise(currentExercise);
                view.toSecondPage();
                view.showFinishWorkout();
            } else {
                view.toThirdPage(numberOfsets);
            }

        });

        view.addFinishWorkoutListener(e -> {
            model.saveWorkout(controller.getCurrentUser(), currentWorkout);
            controller.showHomePage(controller.getCurrentUser());
        });

    }

    public void reset() {

        // this method gets called when the workout page gets reopened

        currentWorkout = new Workout();
        currentExercise = null;
        numberOfsets = 0;
    }

}
