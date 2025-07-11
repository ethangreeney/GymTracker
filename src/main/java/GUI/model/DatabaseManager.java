package GUI.model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseManager {

    private final Connection conn;

    // establishing database connection
    public DatabaseManager(Connection connection) {
        this.conn = connection;
    }

    // getting user workout history
    public List<Workout> getWorkoutHistory(User user) {
        List<Workout> workoutHistory = new ArrayList<>();

        String workoutsSQL = "SELECT workout_id, workout_name, workout_date FROM WORKOUTS WHERE user_id = ? ORDER BY workout_date DESC";
        String exercisesSQL = "SELECT exercise_id, exercise_name FROM EXERCISES WHERE workout_id = ?";
        String setsSQL = "SELECT weight_kg, reps FROM SETS WHERE exercise_id = ?";

        try (PreparedStatement workoutsPstmt = conn.prepareStatement(workoutsSQL)) {
            workoutsPstmt.setInt(1, user.getUserID());
            ResultSet workoutsRs = workoutsPstmt.executeQuery();

            while (workoutsRs.next()) {
                int workoutId = workoutsRs.getInt("workout_id");
                Workout workout = new Workout();
                workout.setName(workoutsRs.getString("workout_name"));
                workout.setWorkoutDate(workoutsRs.getTimestamp("workout_date"));

                try (PreparedStatement exercisesPstmt = conn.prepareStatement(exercisesSQL)) {
                    exercisesPstmt.setInt(1, workoutId);
                    ResultSet exercisesRs = exercisesPstmt.executeQuery();

                    while (exercisesRs.next()) {
                        int exerciseId = exercisesRs.getInt("exercise_id");
                        Exercise exercise = new Exercise(exercisesRs.getString("exercise_name"));

                        try (PreparedStatement setsPstmt = conn.prepareStatement(setsSQL)) {
                            setsPstmt.setInt(1, exerciseId);
                            ResultSet setsRs = setsPstmt.executeQuery();

                            while (setsRs.next()) {
                                exercise.addSet(setsRs.getInt("weight_kg"), setsRs.getInt("reps"));
                            }
                        }
                        workout.addExercise(exercise);
                    }
                }
                workoutHistory.add(workout);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving workout history: " + e.getMessage());
        }
        return workoutHistory;
    }

    // used ai for goal database fuctionality
    public boolean saveGoal(User user, Goal goal) {
        String sql = "INSERT INTO GOALS(user_id, description, start_date, end_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, user.getUserID());
            pstmt.setString(2, goal.getGoalDescription());
            pstmt.setDate(3, new java.sql.Date(goal.getStartDate().getTime()));

            if (goal.getEndDate() != null) {
                pstmt.setDate(4, new java.sql.Date(goal.getEndDate().getTime()));
            } else {
                pstmt.setNull(4, java.sql.Types.DATE);
            }

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        goal.setGoalId(generatedKeys.getInt(1));
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error saving goal: " + e.getMessage());
        }
        return false;
    }

    // getting user goals
    public List<Goal> getGoals(User user) {
        List<Goal> goals = new ArrayList<>();
        String sql = "SELECT goal_id, description, start_date, end_date FROM GOALS WHERE user_id = ? ORDER BY start_date DESC";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, user.getUserID());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Goal goal = new Goal(rs.getString("description"));
                goal.setGoalId(rs.getInt("goal_id"));
                goal.setStartDate(rs.getDate("start_date"));
                goal.setEndDate(rs.getDate("end_date"));
                goals.add(goal);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving goals: " + e.getMessage());
        }
        return goals;
    }

    // updating user goals
    public boolean updateGoal(Goal goal) {
        String sql = "UPDATE GOALS SET description = ?, start_date = ?, end_date = ? WHERE goal_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, goal.getGoalDescription());
            pstmt.setDate(2, new java.sql.Date(goal.getStartDate().getTime()));

            if (goal.getEndDate() != null) {
                pstmt.setDate(3, new java.sql.Date(goal.getEndDate().getTime()));
            } else {
                pstmt.setNull(3, java.sql.Types.DATE);
            }

            pstmt.setInt(4, goal.getGoalId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error updating goal: " + e.getMessage());
        }
        return false;
    }

    // USED AI FOR THE FOLLOWING SAVEWORKOUT METHOD
    public boolean saveWorkout(User user, Workout workout) {

        String workoutSQL = "INSERT INTO WORKOUTS(user_id, workout_name, workout_date) VALUES (?, ?, ?)";
        String exerciseSQL = "INSERT INTO EXERCISES(workout_id, exercise_name) VALUES (?, ?)";
        String setSQL = "INSERT INTO SETS(exercise_id, weight_kg, reps) VALUES (?, ?, ?)";

        try {

            long workoutId;
            try (PreparedStatement pstmt = conn.prepareStatement(workoutSQL, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setInt(1, user.getUserID());
                pstmt.setString(2, workout.getName());
                pstmt.setTimestamp(3, new java.sql.Timestamp(workout.getWorkoutDate().getTime()));

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creating workout failed, no rows affected.");
                }

                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        workoutId = generatedKeys.getLong(1);
                    } else {
                        throw new SQLException("Creating workout failed, no ID obtained.");
                    }
                }
            }

            for (Exercise exercise : workout.getExerciseInfo()) {
                long exerciseId;
                try (PreparedStatement pstmt = conn.prepareStatement(exerciseSQL, Statement.RETURN_GENERATED_KEYS)) {
                    pstmt.setLong(1, workoutId);
                    pstmt.setString(2, exercise.getName());

                    int affectedRows = pstmt.executeUpdate();
                    if (affectedRows == 0) {
                        throw new SQLException("Creating exercise failed, no rows affected.");
                    }

                    try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            exerciseId = generatedKeys.getLong(1);
                        } else {
                            throw new SQLException("Creating exercise failed, no ID obtained.");
                        }
                    }
                }

                for (SetInfo set : exercise.getSets()) {
                    try (PreparedStatement pstmt = conn.prepareStatement(setSQL)) {
                        pstmt.setLong(1, exerciseId);
                        pstmt.setInt(2, set.getWeight());
                        pstmt.setInt(3, set.getReps());
                        pstmt.executeUpdate();
                    }
                }
            }

            return true;

        } catch (SQLException e) {
            System.err.println("Error saving workout to database: " + e.getMessage());
            return false;
        }
    }

    // AI CREATED THE FIRST TWO TABLES

    public void setupTables(Connection conn) {
        try {
            if (!tableExists(conn, "USERS")) {
                System.out.println("Creating table: USERS...");
                String createUsersSQL = "CREATE TABLE USERS (" +
                        "user_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                        "username VARCHAR(50) NOT NULL UNIQUE, " +
                        "password VARCHAR(50) NOT NULL, " +
                        "name VARCHAR(100), " +
                        "age INT, " +
                        "height_cm INT, " +
                        "weight_kg INT" +
                        ")";
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(createUsersSQL);
                    System.out.println("Table USERS created successfully.");
                }
            }

            if (!tableExists(conn, "GOALS")) {
                System.out.println("Creating table: GOALS...");
                String createGoalsSQL = "CREATE TABLE GOALS (" +
                        "goal_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                        "user_id INT NOT NULL, " +
                        "description VARCHAR(255) NOT NULL, " +
                        "start_date DATE, " +
                        "end_date DATE, " +
                        "FOREIGN KEY (user_id) REFERENCES USERS(user_id)" +
                        ")";
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(createGoalsSQL);
                    System.out.println("Table GOALS created successfully.");
                }
            }

            if (!tableExists(conn, "WORKOUTS")) {
                System.out.println("Creating table: WORKOUTS...");
                String createWorkoutsSQL = "CREATE TABLE WORKOUTS (" +
                        "workout_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                        "user_id INT NOT NULL, " +
                        "workout_name VARCHAR(100), " +
                        "workout_date TIMESTAMP, " +
                        "FOREIGN KEY (user_id) REFERENCES USERS(user_id)" +
                        ")";
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(createWorkoutsSQL);
                    System.out.println("Table WORKOUTS created successfully.");
                }
            }

            if (!tableExists(conn, "EXERCISES")) {
                System.out.println("Creating table: EXERCISES...");
                String createExercisesSQL = "CREATE TABLE EXERCISES (" +
                        "exercise_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                        "workout_id INT NOT NULL, " +
                        "exercise_name VARCHAR(100) NOT NULL, " +
                        "FOREIGN KEY (workout_id) REFERENCES WORKOUTS(workout_id)" +
                        ")";
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(createExercisesSQL);
                    System.out.println("Table EXERCISES created successfully.");
                }
            }

            if (!tableExists(conn, "SETS")) {
                System.out.println("Creating table: SETS...");
                String createSetsSQL = "CREATE TABLE SETS (" +
                        "set_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                        "exercise_id INT NOT NULL, " +
                        "weight_kg INT, " +
                        "reps INT, " +
                        "FOREIGN KEY (exercise_id) REFERENCES EXERCISES(exercise_id)" +
                        ")";
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(createSetsSQL);
                    System.out.println("Table SETS created successfully.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error setting up database tables.");
        }
    }

    // check if table exists
    private boolean tableExists(Connection conn, String tableName) throws SQLException {
        DatabaseMetaData meta = conn.getMetaData();
        try (ResultSet rs = meta.getTables(null, null, tableName.toUpperCase(), new String[] { "TABLE" })) {
            return rs.next();
        }
    }

    // predetermined exercises that every user has
    public List<String> getDefaultExercises() {
        return Arrays.asList(
                "Bench Press",
                "Incline Dumbbell Press",
                "Push Ups",
                "Overhead Press",

                "Dips",
                "Cable Tricep Extensions",
                "Skull Crushers",
                "Overhead Cable Tricep Extensions",

                "Dumbbell Side Delts",
                "Cable Side Delts",

                "Bicep Curls",
                "Preacher Curls",
                "Cable Curls",

                "Pull Ups",
                "Pull Downs",
                "Dumbbell Rows",
                "Barbell Rows",

                "Squats",
                "Deadlifts",
                "Lunges",
                "Leg Press");
    }

    // adding user
    public boolean addUser(User user) {
        String sql = "INSERT INTO USERS(username, password, name, age, height_cm, weight_kg) VALUES(?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setInt(4, user.getAge());
            pstmt.setInt(5, user.getHeight());
            pstmt.setInt(6, user.getWeight());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setUserID(generatedKeys.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error adding user: " + e.getMessage());
        }
        return false;
    }

    // checking if user exists
    public boolean userExists(String username) {
        String sql = "SELECT 1 FROM USERS WHERE username = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Error checking if user exists: " + e.getMessage());
        }
        return false;
    }

    // getting user informaiton
    public User getUser(String username, String password) {
        String sql = "SELECT * FROM USERS WHERE username = ? AND password = ?";
        User user = null;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setUserID(rs.getInt("user_id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setName(rs.getString("name"));
                    user.setAge(rs.getInt("age"));
                    user.setHeight(rs.getInt("height_cm"));
                    user.setWeight(rs.getInt("weight_kg"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting user: " + e.getMessage());
            return null;
        }
        return user;
    }

    // updating user information
    public boolean updateUser(User user) {
        String sql = "UPDATE USERS SET name = ?, age = ?, height_cm = ?, weight_kg = ? WHERE user_id = ?";

        if (user.getUserID() == 0) {
            System.err.println("Cannot update user: userID is missing.");
            return false;
        }

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setInt(2, user.getAge());
            pstmt.setInt(3, user.getHeight());
            pstmt.setInt(4, user.getWeight());
            pstmt.setInt(5, user.getUserID());

            int affectedRows = pstmt.executeUpdate();

            return affectedRows > 0;

        } catch (SQLException e) {
            System.err.println("Error updating user: " + e.getMessage());
        }
        return false;
    }
}
