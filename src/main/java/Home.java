public class Home implements Page {

    @Override
    public void display() {

        System.out.println("======= Home =======\n");
        System.out.println("""
                1. Start Workout
                2. View Workout History
                3. Set and View Goals
                4. User Info
                5. Save Info and Log Out
                """);

        handleInput();
    }

    @Override
    public void handleInput() {

        String input = GymApplication.scan.nextLine();

        int pageNum = GymApplication.stringToInt(input);

        switch (pageNum) {
            case 1:
                PageManager.navigate(WorkoutPage.class);
                break;
            case 2:
                PageManager.navigate(WorkoutHistory.class);
                break;

            case 3:
                PageManager.navigate(GoalsPage.class);
                break;

            case 4:
                PageManager.navigate(UserInfo.class);
                break;

            case 5:
                PageManager.navigate(Shutdown.class);
                break;

            default:
                System.out.println("Invalid Input");
                PageManager.navigate(Home.class);
                break;

        }

    }

}
