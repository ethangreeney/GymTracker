package GUI.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    // User object class, has get methods and set methods
    private String username;
    private String password;

    private String name;
    private int height;
    private int age;
    private int weight;
    private int userID;

    private List<Workout> workoutHistory;

    private List<Goal> userGoals;

    public List<Goal> getUserGoals() {
        if (this.userGoals == null) {
            userGoals = new ArrayList<>();
        }

        return userGoals;
    }

    public void addGoal(String goalDescription) {
        userGoals.add(new Goal(goalDescription));
    }

    public void addWorkout(Workout currentWorkout) {
        if (this.workoutHistory == null) {
            workoutHistory = new ArrayList<>();
        }
        workoutHistory.add(currentWorkout);
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUserGoals(List<Goal> userGoals) {
        this.userGoals = userGoals;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getBMI() {
        return weight / (((double) height / 100) * ((double) height / 100));
    }

}
