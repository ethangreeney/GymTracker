package CLI;

public class GoalsPage implements Page {

    @Override
    public void display() {

        System.out.println("===== Goals =====\n");
        int count = 1;
        for (Goal goal : UserManager.currentUser.getUserGoals()) {
            System.out.println("Goal " + count++ + ": ");
            System.out.println(goal);
            System.out.println();
        }

        System.out.println(count++ + ": Set new goal\n");
        System.out.println("Enter goal number to complete goal, or 'x' to return: ");

        handleInput();
    }

    @Override
    public void handleInput() {

        String userInput = GymApplication.scan.nextLine();

        if (userInput.toLowerCase().equals("x")) {
            PageManager.navigate(Home.class);
        }

        int intUserInput = GymApplication.stringToInt(userInput);
        int noOfGoals = UserManager.currentUser.getUserGoals().size();

        if (intUserInput > 0 && intUserInput <= noOfGoals) {
            Goal selectedGoal = UserManager.currentUser.getUserGoals().get(intUserInput - 1);
            if (selectedGoal.endDate == null) {
                selectedGoal.completeGoal();
            }
        } else if (intUserInput == UserManager.currentUser.getUserGoals().size() + 1) {
            System.out.println("Enter description of Goal: ");
            String goalDescription = GymApplication.scan.nextLine();
            UserManager.currentUser.addGoal(goalDescription);
        }

        PageManager.navigate(GoalsPage.class);

    }

}
