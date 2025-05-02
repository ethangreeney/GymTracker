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
        System.out.println();

        if (input.toLowerCase().equals("x")) {
            PageManager.navigate(Home.class);
            return;
        }

        currentWorkout.setName(input);

        String userInput = "";
        while (!userInput.toLowerCase().equals("x")) {

            int count = 1;
            for (String preset : UserManager.currentUser.getExercisesList()) {
                System.out.println(count + ": " + preset);
                count++;
            }

            System.out.println(count + ": Custom Exercise");

            System.out.println("\nSelect an Exercise: (x to finish workout)");

            userInput = GymApplication.scan.nextLine();

            if (userInput.toLowerCase().equals("x")) {
                break;
            }

            int userExerciseSelection = GymApplication.stringToInt(userInput);

            if (userExerciseSelection == Integer.MIN_VALUE) {
                break;
            }

            while (userExerciseSelection > count || userExerciseSelection < 1) {

                System.out.println("Please enter a whole number between 1 and " + count);
                userInput = GymApplication.scan.nextLine();
                userExerciseSelection = GymApplication.stringToInt(userInput);

            }

            if (userExerciseSelection == count) {
                System.out.println("Please enter name of custom exercise: ");
                String exerciseName = GymApplication.scan.nextLine();
                UserManager.currentUser.addCustomExercise(exerciseName);
                System.out.println("Successfully added " + exerciseName);

            }

            Exercise currentExercise = new Exercise(UserManager.currentUser.getExerciseAtIndex(userExerciseSelection));

            System.out.println("How many sets of " + currentExercise.getName() + " will you do?");
            int numberOfSets = GymApplication.stringToInt(GymApplication.scan.nextLine());

            int weightSelection;
            int repsSelection;

            for (int i = 1; i <= numberOfSets; i++) {

                System.out.println("Input weight (KG) for set " + i + ":");
                weightSelection = GymApplication.stringToInt(GymApplication.scan.nextLine());

                System.out.println("Input number of reps for set " + i + ":");
                repsSelection = GymApplication.stringToInt(GymApplication.scan.nextLine());

                currentExercise.addSet(weightSelection, repsSelection);

            }

            currentWorkout.addExercise(currentExercise);

        }

        if (currentWorkout.getExerciseInfo() == null) {
            PageManager.navigate(Home.class);
        }

        UserManager.currentUser.addWorkout(currentWorkout);
        System.out.println("Workout " + currentWorkout.getName() + " completed, returning to home page");
        PageManager.navigate(Home.class);

    }

}
