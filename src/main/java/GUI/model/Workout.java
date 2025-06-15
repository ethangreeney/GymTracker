package GUI.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Workout {

    private String name;
    private Date workoutDate;

    private List<Exercise> exerciseInfo;

    Workout() {
        workoutDate = new Date();
    }

    public void showExercises() {
        for (Exercise exercise : exerciseInfo) {
            System.out.println(exercise);
        }
    }

    public Date getWorkoutDate() {
        return workoutDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exercise> getExerciseInfo() {
        return exerciseInfo;
    }

    public void addExercise(Exercise currentExercise) {
        if (this.exerciseInfo == null) {
            this.exerciseInfo = new ArrayList<>();
        }

        exerciseInfo.add(currentExercise);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (exerciseInfo == null) {
        } else {
            sb.append("Workout: ").append(name).append("\nDate: ").append(workoutDate).append("\n\n");
            for (Exercise exercise : exerciseInfo) {
                sb.append(exercise).append("\n");
            }
        }
        return sb.toString();
    }

}
