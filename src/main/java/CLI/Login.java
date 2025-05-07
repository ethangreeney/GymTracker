package CLI;

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

            System.out.println("Please enter username: (input 'x' to return to login)");
            username = GymApplication.scan.nextLine();

            if (username.toLowerCase().equals("x")) {
                System.out.println("User inputted : 'x' returning to login page");
                PageManager.navigate(Welcome.class);
            }

            System.out.println("Please enter password: (input 'x' to return to login)");
            password = GymApplication.scan.nextLine();

            if (password.toLowerCase().equals("x")) {
                System.out.println("User inputted : 'x' returning to login page");
                PageManager.navigate(Welcome.class);
            }

            UserManager.login(username, password);

            if (UserManager.currentUser == null) {
                System.out.println("\nUsername or password was incorrect, please try again\n");
            }

        }

        System.out.println("\nWelcome back, " + UserManager.currentUser.getName() + ".");
        PageManager.navigate(Home.class);

    }

}
