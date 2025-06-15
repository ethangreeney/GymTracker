package GUI.model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class ModelTest {

    @Test
    void testAddSetToExercise() {
        Exercise benchPress = new Exercise("Bench Press");

        benchPress.addSet(100, 8);
        benchPress.addSet(105, 5);

        assertNotNull(benchPress.getSets(), "Sets list should not be null");
        assertEquals(2, benchPress.getSets().size(), "Exercise should have 2 sets");

        SetInfo firstSet = benchPress.getSets().get(0);
        assertEquals(100, firstSet.getWeight(), "Weight of the first set should be 100.");
        assertEquals(8, firstSet.getReps(), "Reps of the first set should be 8");
    }

    @Test
    void testAddExerciseToWorkout() {
        Workout chestDay = new Workout();
        chestDay.setName("Chest Day");
        Exercise benchPress = new Exercise("Bench Press");
        Exercise dips = new Exercise("Dips");

        chestDay.addExercise(benchPress);
        chestDay.addExercise(dips);

        List<Exercise> exercises = (List<Exercise>) chestDay.getExerciseInfo();
        assertNotNull(exercises, "Exercise list should not be null");
        assertEquals(2, exercises.size(), "Workout should contain 2 exercises");
        assertEquals("Bench Press", exercises.get(0).getName(), "First exercise should be Bench Press");
    }

    @Test
    void testAddWorkoutToUser() {
        User testUser = new User();
        testUser.setUsername("test");
        Workout chestDay = new Workout();
        chestDay.setName("Chest Day");

        testUser.addWorkout(chestDay);

        assertNotNull(testUser.getWorkoutHistory(), "Workout history should not be null");
        assertEquals(1, testUser.getWorkoutHistory().size(), "User should have 1 workout in history");
        assertEquals("Chest Day", testUser.getWorkoutHistory().get(0).getName(), "The workout name should match");
    }
}