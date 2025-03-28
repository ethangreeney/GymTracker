public class Register implements Page {

    @Override
    public void display() {

        System.out.println("=====User Sign Up=====");

        handleInput();

    }

    @Override
    public void handleInput() {

        String username;
        String password;
        String input;

        System.out.println("Please enter username: ");
        username = GymApplication.scan.nextLine();

        while (UserManager.getUsers().containsKey(username)) {

            if (username.equals("x")) {
                PageManager.navigate(Welcome.class);
            }

            System.out.println("User already exists in the database, please enter username again (x to go back)");
            username = GymApplication.scan.nextLine();

        }

        UserManager.currentUser = new User();

        UserManager.currentUser.setUsername(username);

        System.out.println("Please enter password: ");
        password = GymApplication.scan.nextLine();
        UserManager.currentUser.setPassword(password);

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

        PageManager.navigate(Home.class);

    }

}
