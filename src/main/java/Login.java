public class Login implements Page {

    @Override
    public void display() {

        System.out.println("=====Log In=====");
        handleInput();

    }

    @Override
    public void handleInput() {

        String username = null;
        String password = null;

        while (UserManager.currentUser == null) {

            System.out.println("Please enter username: ");
            username = GymApplication.scan.nextLine();
            System.out.println("Please enter password: ");
            password = GymApplication.scan.nextLine();

            UserManager.login(username, password);

            if (UserManager.currentUser == null) {
                System.out.println("Username or password was incorrect, please enter username again (x to go back)");
                username = GymApplication.scan.nextLine();
                if (username.toLowerCase().equals("x")) {
                    PageManager.navigate(Welcome.class);
                }
            }

        }

        System.out.println("\nWelcome back, " + UserManager.currentUser.getName() + ".");
        PageManager.navigate(Home.class);

    }

}
