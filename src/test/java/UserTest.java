import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class UserTest {
    
    private User user;
    
    @BeforeEach
    public void setUp() {
        user = new User();
        user.setUsername("testUser");
        user.setPassword("password123");
        user.setName("Test User");
        user.setAge(25);
        user.setHeight(175);
        user.setWeight(70);
    }
    
    @Test
    public void testUserCreation() {
        assertEquals("testUser", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertEquals("Test User", user.getName());
        assertEquals(25, user.getAge());
        assertEquals(175, user.getHeight());
        assertEquals(70, user.getWeight());
    }
    
    @Test
    public void testDefaultExercisesList() {
        List<String> exercises = user.getExercisesList();
        
        // Verify the exercise list is not null
        assertNotNull(exercises);
        
        // Verify the list contains expected default exercises
        assertTrue(exercises.contains("Bench Press"));
        assertTrue(exercises.contains("Squat"));
        assertTrue(exercises.contains("Deadlift"));
        
        // Verify the size of the default list
        assertEquals(21, exercises.size());
    }
    
    @Test
    public void testWorkoutHistoryInitiallyEmpty() {
        List<Workout> workoutHistory = user.getWorkoutHistory();
        
        // Verify the workout history is not null
        assertNotNull(workoutHistory);
        
        // Verify the workout history is initially empty
        assertTrue(workoutHistory.isEmpty());
    }
    
    @Test
    public void testUserUpdateInformation() {
        // Update user information
        user.setAge(30);
        user.setHeight(180);
        user.setWeight(75);
        
        // Verify the updates were applied
        assertEquals(30, user.getAge());
        assertEquals(180, user.getHeight());
        assertEquals(75, user.getWeight());
    }
}
