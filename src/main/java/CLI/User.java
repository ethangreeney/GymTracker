package CLI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    private String username;
    private String password;

    private String name;
    private int height;
    private int age;
    private int weight;

    private List<String> exercisesList;

    private List<Workout> workoutHistory;

    private List<Goal> userGoals;

    public List<Goal> getUserGoals() {
        if (this.userGoals == null) {
            userGoals = new ArrayList<Goal>();
        }

        return userGoals;
    }

    public void addGoal(String goalDescription) {
        userGoals.add(new Goal(goalDescription));
    }

    public List<String> getExercisesList() {
        if (this.exercisesList == null) {
            exercisesList = new ArrayList<>(Arrays.asList(
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
                    "Leg Press"));
        }
        return exercisesList;
    }

    public List<Workout> getWorkoutHistory() {
        if (this.workoutHistory == null) {
            workoutHistory = new ArrayList<>();
        }
        return workoutHistory;
    }

    public void addWorkout(Workout currentWorkout) {
        if (this.workoutHistory == null) {
            workoutHistory = new ArrayList<Workout>();
        }
        workoutHistory.add(currentWorkout);
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getExerciseAtIndex(int index) {
        return this.exercisesList.get(index - 1);
    }

    public void addCustomExercise(String userInput) {
        this.exercisesList.add(userInput);
    }

}
