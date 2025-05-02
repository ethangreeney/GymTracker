import java.util.Scanner;

public class GymApplication {

    public static Scanner scan = new Scanner(System.in);

    public static int stringToInt(String input) {

        int intInput = Integer.MAX_VALUE;

        while (intInput == Integer.MAX_VALUE) {

            try {
                intInput = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Not a valid integer input, try again:");
                input = GymApplication.scan.nextLine();
            }

        }
        return intInput;
    }

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
