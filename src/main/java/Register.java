public class Register implements Page {

    @Override
    public void display() {

        System.out.println("======= User Sign Up =======\n");

        handleInput();

    }

    @Override
    public void handleInput() {

        String username;
        String password;
        String input;

        System.out.println("Please enter username: ");
        username = getValidUsername();

        while (UserManager.getUsers().containsKey(username)) {

            System.out.println("User already exists in the database, please enter username again (x to go back)");
            username = GymApplication.scan.nextLine();

            if (username.equals("x")) {
                UserManager.currentUser = null;
                PageManager.navigate(Welcome.class);
            }

        }

        UserManager.currentUser = new User();
        UserManager.currentUser.setUsername(username);
        System.out.println("Please enter password: ");
        password = getValidPassword();

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

    public String getValidPassword() {

        String password = GymApplication.scan.nextLine();

        while (password.equals("x") || password.equals("") || password.contains(" ")) {

            if (password.equals("x")) {

                System.out.println("Invalid password: your password cannot be 'x'");
                System.out.println("Please enter a new password: ");

                password = GymApplication.scan.nextLine();

            }

            if (password.equals("") || password.contains(" ")) {

                System.out.println("password may not contain a space, or be empty");
                System.out.println("Please enter a new password: ");

                password = GymApplication.scan.nextLine();

            }

        }
        return password;
    }

    public String getValidUsername() {

        String username = GymApplication.scan.nextLine();

        while (username.equals("x") || username.equals("") || username.contains(" ")) {

            if (username.equals("x")) {

                System.out.println("Invalid username: your username cannot be 'x'");
                System.out.println("Please enter a new username: ");

                username = GymApplication.scan.nextLine();

            }

            if (username.equals("") || username.contains(" ")) {

                System.out.println("username may not contain a space, or be empty");
                System.out.println("Please enter a new username: ");

                username = GymApplication.scan.nextLine();

            }

        }

        return username;
    }

}
