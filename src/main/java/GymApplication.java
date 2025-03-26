import java.util.Scanner;

public class GymApplication {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        PageManager.navigate(Welcome.class);
        scan.close();
    }

}
