public class Login implements Page {

    @Override
    public void display() {

        System.out.println("=====Log In=====");
        handleInput();

    }

    @Override
    public void handleInput() {

        String username;
        String password;

        System.out.println("Please enter username: ");
        username = GymApplication.scan.nextLine();
        System.out.println("Please enter password: ");
        password = GymApplication.scan.nextLine();

        while (!UserManager.login(username, password)) {

            if (username.toLowerCase().equals("x")) {
                PageManager.navigate(Welcome.class);
            }

            System.out.println("Username or password was incorrect, please enter username again (x to go back)");
            username = GymApplication.scan.nextLine();

        }

    }

}
