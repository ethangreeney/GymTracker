package CLI;

public class UserInfo implements Page {

    @Override
    public void display() {

        System.out.println("======= User Info =======\n");
        System.out.println("Name:   " + UserManager.currentUser.getName());
        System.out.println("Age:    " + UserManager.currentUser.getAge());
        System.out.println("Height: " + UserManager.currentUser.getHeight() + "cm");
        System.out.println("Weight: " + UserManager.currentUser.getWeight() + "kg");
        System.out.printf("BMI:    " + "%.1f" + " (" + bmiClassification() + ")", calculateBMI());
        System.out.println("\n");

        System.out.println("1: Change User Info");
        System.out.println("Enter 'x' to Return");

        handleInput();

    }

    @Override
    public void handleInput() {

        String userChoice = GymApplication.scan.nextLine();

        if (userChoice.equalsIgnoreCase("x")) {
            PageManager.navigate(Home.class);
        }

        int intUserChoice = GymApplication.stringToInt(userChoice);

        switch (intUserChoice) {
            case 1:
                changeUserInfo();
                break;
            default:
                System.out.println("Unknown input, returning to home page");
                PageManager.navigate(Home.class);
                break;
        }

    }

    private double calculateBMI() {

        double heightMeters = UserManager.currentUser.getHeight() / 100.0;
        return UserManager.currentUser.getWeight() / Math.pow(heightMeters, 2);

    }

    private String bmiClassification() {

        double userBMI = calculateBMI();

        if (userBMI < 18.5) {
            return "Underweight";
        } else if (userBMI < 25) {
            return "Healthy Weight";
        } else if (userBMI < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }

    }

    private void changeUserInfo() {

        String input;

        System.out.println("""

                What would you like to edit:

                1. Name
                2. Height
                3. Weight
                4. Age""");
        int choice = GymApplication.stringToInt(GymApplication.scan.nextLine());

        switch (choice) {
            case 1:
                System.out.println("Please enter name: ");
                input = GymApplication.scan.nextLine();
                UserManager.currentUser.setName(input);
                break;

            case 2:
                System.out.println("Please enter height: (cm)");
                input = GymApplication.scan.nextLine();
                UserManager.currentUser.setHeight(GymApplication.stringToInt(input));
                break;

            case 3:
                System.out.println("Please enter weight: (kg)");
                input = GymApplication.scan.nextLine();
                UserManager.currentUser.setWeight(GymApplication.stringToInt(input));
                break;

            case 4:
                System.out.println("Please enter age: ");
                input = GymApplication.scan.nextLine();
                UserManager.currentUser.setAge(GymApplication.stringToInt(input));
                break;

            default:
                System.out.println("Incorrect input, please select 1 to 4");
                changeUserInfo();
        }

        PageManager.navigate(UserInfo.class);

    }

}
