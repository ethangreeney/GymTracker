import java.time.LocalDateTime;
import java.util.List;

public class Workout {
    
    private LocalDateTime start;
    private LocalDateTime end;
    private LocalDateTime date;
    
    private String name;

    private List<Exercise> exerciseInfo;

    public void showExercises(){
        for(Exercise exercise : exerciseInfo){
            System.out.println(exercise);
        }
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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
