public class Login implements Page {

    @Override
    public void display() {

        System.out.println("======= Log In =======\n");
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

            if (username.toLowerCase().equals("x")) {
                PageManager.navigate(Welcome.class);
            }

            UserManager.login(username, password);

            if (UserManager.currentUser == null) {
                System.out.println("Username or password was incorrect, (x to go back)\n");
            }

        }

        System.out.println("\nWelcome back, " + UserManager.currentUser.getName() + ".");
        PageManager.navigate(Home.class);

    }

}
