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

    public void setExerciseInfo(List<Exercise> exerciseInfo) {
        this.exerciseInfo = exerciseInfo;
    }

}
