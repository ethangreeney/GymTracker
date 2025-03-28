import java.util.Scanner;

public class GymApplication {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Saving user data before shutting down...");
            UserManager.saveUsers();
        }));

        UserManager.loadUsers();
        PageManager.navigate(Welcome.class);

        scan.close();
    }

}
