import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkoutTest {
    
    private Workout workout;
    private List<Exercise> exercises;
    
    @BeforeEach
    public void setUp() {
        workout = new Workout();
        workout.setName("Push Day");
        
        exercises = new ArrayList<>();
        
        Exercise benchPress = new Exercise("Bench Press");
        benchPress.addSet(100, 10);
        benchPress.addSet(110, 8);
        
        Exercise overheadPress = new Exercise("Overhead Press");
        overheadPress.addSet(60, 10);
        overheadPress.addSet(65, 8);
        
        exercises.add(benchPress);
        exercises.add(overheadPress);
        
        workout.setExerciseInfo(exercises);
    }
    
    @Test
    public void testWorkoutCreation() {
        assertNotNull(workout);
        assertEquals("Push Day", workout.getName());
        assertNotNull(workout.getWorkoutDate());
        assertNotNull(workout.getExerciseInfo());
    }
    
    @Test
    public void testWorkoutDate() {
        // Verify the workout date is set to current date
        Date now = new Date();
        long timeDifferenceMs = Math.abs(now.getTime() - workout.getWorkoutDate().getTime());
        
        // Ensure the workout date is within 5 seconds of current time
        assertTrue(timeDifferenceMs < 5000);
    }
    
    @Test
    public void testExerciseList() {
        List<Exercise> workoutExercises = workout.getExerciseInfo();
        
        // Verify the number of exercises
        assertEquals(2, workoutExercises.size());
        
        // Verify the exercise names
        assertEquals("Bench Press", workoutExercises.get(0).getName());
        assertEquals("Overhead Press", workoutExercises.get(1).getName());
    }
    
    @Test
    public void testExerciseSets() {
        List<Exercise> workoutExercises = workout.getExerciseInfo();
        
        // Verify the bench press sets
        Exercise benchPress = workoutExercises.get(0);
        List<SetInfo> benchSets = benchPress.getSets();
        
        assertEquals(2, benchSets.size());
        assertEquals(100, benchSets.get(0).getWeight());
        assertEquals(10, benchSets.get(0).getReps());
        assertEquals(110, benchSets.get(1).getWeight());
        assertEquals(8, benchSets.get(1).getReps());
        
        // Verify the overhead press sets
        Exercise overheadPress = workoutExercises.get(1);
        List<SetInfo> ohpSets = overheadPress.getSets();
        
        assertEquals(2, ohpSets.size());
        assertEquals(60, ohpSets.get(0).getWeight());
        assertEquals(10, ohpSets.get(0).getReps());
        assertEquals(65, ohpSets.get(1).getWeight());
        assertEquals(8, ohpSets.get(1).getReps());
    }
}
