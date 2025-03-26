public class Login implements Page {

    @Override
    public void display() {

        String username;
        String password;

        System.out.println("=====Log In=====");

        // if userManager.login returns true then print this
        System.out.println("Successful login. Welcome back " + UserManager.currentUser.getName() + "!");

    }

    @Override
    public void handleInput() {
    }

}
