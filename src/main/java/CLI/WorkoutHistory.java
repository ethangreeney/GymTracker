package CLI;

public class WorkoutHistory implements Page {

    @Override
    public void display() {
        System.out.println("======= Workout History =======\n");

        if (UserManager.currentUser.getWorkoutHistory() != null) {

            for (Workout workout : UserManager.currentUser.getWorkoutHistory()) {
                System.out.println(workout.toString());
            }

        }

        handleInput();

    }

    @Override
    public void handleInput() {

        String userInput = "";

        do {

            System.out.println("Input 'x' to return");
            userInput = GymApplication.scan.nextLine();

        } while (!userInput.equals("x"));

        PageManager.navigate(Home.class);

    }

}
