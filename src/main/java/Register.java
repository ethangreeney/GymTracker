public class Register implements Page {

    @Override
    public void display() {

        System.out.println("=====User Sign Up=====");

        handleInput();

        // before registering, check if a user with that name already exists, if it does
        // tell the user that an account with that username already exists,
        // and ask them to please return to the previous page and log in

        // as the user is registering, if no account with that username exists,
        // start setting the variables: UserManager.currentUser.setAge

    }

    @Override
    public void handleInput() {

        String username;
        String password;

        System.out.println("Please enter username: ");
        username = GymApplication.scan.nextLine();
        System.out.println("Please enter password: ");
        password = GymApplication.scan.nextLine();

        while (UserManager.getUsers().containsKey(username)) {

            if (username.equals("x")) {
                PageManager.navigate(Welcome.class);
            }

            System.out.println("User already exists in the database, please enter username again (x to go back)");
            username = GymApplication.scan.nextLine();

        }

    }

}
