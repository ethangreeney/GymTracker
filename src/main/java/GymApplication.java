import java.util.Scanner;

public class GymApplication implements Page {

    private Scanner scan = new Scanner(System.in);

    public void display() {

        String asciiArt = """
                  _____                _____                _
                 / ____|              |_   _|              | |
                | |  __ _   _ _ __ ___  | |  _ __ __ _  ___| | _____ _ __
                | | |_ | | | | '_ ` _ \\ | | | '__/ _` |/ __| |/ / _ \\ '__|
                | |__| | |_| | | | | | || |_| | | (_| | (__|   <  __/ |
                 \\_____|\\___, |_| |_| |_|_____|_|  \\__,_|\\___|_|\\_\\___|_|
                         __/ |
                        |___/
                """;

        System.out.println(asciiArt);

        System.out.println("Welcome to this excersise tracking application! Would you like to:");
        System.out.println("1: Login");
        System.out.println("2: Register");

        handleInput();
    }

    public void handleInput() {

        String userInput = scan.nextLine();

        while (!userInput.equals("1") && !userInput.equals("2")) {
            System.out.println("Invalid input, please enter either '1', or '2'");
            userInput = scan.nextLine();
        }

        int userInputInt = Integer.parseInt(userInput);

        scan.close();

        if (userInputInt == 1) {
            PageManager.navigate(Login.class);
        } else {
            PageManager.navigate(Register.class);
        }
    }

    public static void main(String[] args) {

        var mainApp = new GymApplication();
        mainApp.display();

    }

}
