public class UserInfo implements Page {

    @Override
    public void display() {

        System.out.println("Name: " + UserManager.currentUser.getName());
        System.out.println("Age: " + UserManager.currentUser.getAge());
        System.out.println("Height (CM): " + UserManager.currentUser.getHeight());
        System.out.println("Weight (KG): " + UserManager.currentUser.getWeight());
        System.out.println();

        System.out.println("1: Change User Info");
        System.out.println("2: Main Menu");

        handleInput();

    }

    @Override
    public void handleInput() {

        int userChoice = GymApplication.stringToInt(GymApplication.scan.nextLine());

        switch (userChoice) {
            case 1:
                String input;
                System.out.println("Please enter name: ");
                input = GymApplication.scan.nextLine();
                UserManager.currentUser.setName(input);
                System.out.println("Please enter age: ");
                input = GymApplication.scan.nextLine();
                UserManager.currentUser.setAge(GymApplication.stringToInt(input));
                System.out.println("Please enter height: (cm)");
                input = GymApplication.scan.nextLine();
                UserManager.currentUser.setHeight(GymApplication.stringToInt(input));
                System.out.println("Please enter weight: (kg)");
                input = GymApplication.scan.nextLine();
                UserManager.currentUser.setWeight(GymApplication.stringToInt(input));

                PageManager.navigate(UserInfo.class);

                break;
            case 2:
                PageManager.navigate(Home.class);
                break;
            default:
                System.out.println("Unknown input, returning to home page");
                PageManager.navigate(Home.class);
                break;
        }

    }

}
