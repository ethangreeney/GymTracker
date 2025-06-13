package GUI;

<<<<<<< HEAD
public class DatabaseManager {

}
=======
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private Connection conn;

    public DatabaseManager(Connection connection) {
        this.conn = connection;
    }

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
            e.printStackTrace();
        }
    }

    private boolean tableExists(Connection conn, String tableName) throws SQLException {
        DatabaseMetaData meta = conn.getMetaData();
        try (ResultSet rs = meta.getTables(null, null, tableName.toUpperCase(), new String[] { "TABLE" })) {
            return rs.next();
        }
    }

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
        }
        return user;
    }

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
>>>>>>> 913522df7ff42cc4b1a08e704d12e66a0b47d52f
