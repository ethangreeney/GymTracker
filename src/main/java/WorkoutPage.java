public class WorkoutPage implements Page {

    @Override
    public void display() {

        System.out.println("======= Workout =======\n");
        handleInput();

    }

    @Override
    public void handleInput() {

        Workout currentWorkout = new Workout();
        System.out.println("input name for this workout session (x to return)");
        String input = GymApplication.scan.nextLine();

        if (input.toLowerCase().equals("x")) {
            PageManager.navigate(Home.class);
        }

        currentWorkout.setName(input);

        System.out.println("Select an Exercise: ");

        int count = 1;
        for (String preset : UserManager.currentUser.getExercisesList()) {
            System.out.println(count + ": " + preset);
        }

        int userExcerciseSelection = GymApplication.stringToInt(GymApplication.scan.nextLine());

        Exercise currentExercise = new Exercise(UserManager.currentUser.getExerciseAtIndex(userExcerciseSelection));

    }

}
