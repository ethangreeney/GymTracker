package GUI.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseManagerTest {

    private DatabaseManager dbManager;
    private Connection conn;

    // before each and after each methods written with the help of AI

    @BeforeEach
    @SuppressWarnings("unused")
    void setUp() throws SQLException {
        String dbURL = "jdbc:derby:memory:testDB;create=true";
        conn = DriverManager.getConnection(dbURL);
        dbManager = new DatabaseManager(conn);

        dbManager.setupTables(conn);
    }

    @AfterEach
    @SuppressWarnings("unused")
    void tearDown() throws SQLException {
        try {
            DriverManager.getConnection("jdbc:derby:memory:testDB;drop=true");
        } catch (SQLException e) {
            if (!"08006".equals(e.getSQLState())) {
                throw e;
            }
        } finally {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
    }

    @Test
    void testAddAndGetUserSuccessfully() {
        User newUser = new User();
        newUser.setUsername("jdoe");
        newUser.setPassword("password123");
        newUser.setName("John Doe");
        newUser.setAge(30);
        newUser.setHeight(180);
        newUser.setWeight(80);

        boolean added = dbManager.addUser(newUser);

        assertTrue(added, "addUser should return true on success");
        assertTrue(newUser.getUserID() > 0, "User ID should be generated and set after adding");

        User retrievedUser = dbManager.getUser("jdoe", "password123");

        assertNotNull(retrievedUser, "getUser should find the newly created user");
        assertEquals("jdoe", retrievedUser.getUsername(), "Retrieved username should match");
        assertEquals("John Doe", retrievedUser.getName(), "Retrieved name should match");
        assertEquals(80, retrievedUser.getWeight(), "Retrieved weight should match");
    }

    @Test
    void testAddUserFailsWithDuplicateUsername() {
        User user1 = new User();
        user1.setUsername("unique_user");
        user1.setPassword("pass1");
        dbManager.addUser(user1);

        User duplicateUser = new User();
        duplicateUser.setUsername("unique_user");
        duplicateUser.setPassword("pass2");

        boolean added = dbManager.addUser(duplicateUser);
        assertFalse(added, "Should not be able to add a user with a duplicate username");
    }

    @Test
    void testUserExists() {
        User user = new User();
        user.setUsername("existing_user");
        user.setPassword("pass");
        dbManager.addUser(user);

        assertTrue(dbManager.userExists("existing_user"), "userExists should return true for an existing user");
        assertFalse(dbManager.userExists("non_existing_user"),
                "userExists should return false for a non-existing user");
    }

    @Test
    void testGetUserWithIncorrectPasswordReturnsNull() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("correct_password");
        dbManager.addUser(user);

        User retrievedUser = dbManager.getUser("testuser", "wrong_password");

        assertNull(retrievedUser, "getUser should return null for incorrect password");
    }

    @Test
    void testUpdateUser() {
        User user = new User();
        user.setUsername("update_test");
        user.setPassword("pass");
        user.setName("Original Name");
        user.setWeight(75);
        dbManager.addUser(user);

        user.setName("Updated Name");
        user.setWeight(77);
        boolean updated = dbManager.updateUser(user);

        assertTrue(updated, "updateUser should return true on success");

        User verifiedUser = dbManager.getUser("update_test", "pass");
        assertNotNull(verifiedUser);
        assertEquals("Updated Name", verifiedUser.getName(), "Name should have been updated");
        assertEquals(77, verifiedUser.getWeight(), "Weight should have been updated");
    }

    @Test
    void testSaveFullWorkout() {
        User user = new User();
        user.setUsername("workout_user");
        user.setPassword("pass");
        dbManager.addUser(user);

        Workout workout = new Workout();
        workout.setName("Full Body Day 1");

        Exercise squats = new Exercise("Squats");
        squats.addSet(100, 5);
        squats.addSet(100, 5);

        Exercise bench = new Exercise("Bench Press");
        bench.addSet(80, 8);

        workout.addExercise(squats);
        workout.addExercise(bench);

        boolean saved = dbManager.saveWorkout(user, workout);

        assertTrue(saved, "saveWorkout should return true when successfully saving a complex workout");
    }
}