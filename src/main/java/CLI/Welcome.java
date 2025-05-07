package CLI;

public class Welcome implements Page {

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

        System.out.println("Welcome to this exercise tracking application! Would you like to:");
        System.out.println("1: Login");
        System.out.println("2: Register");
        System.out.println("3: Exit");

        handleInput();
    }

    public void handleInput() {

        String userInput = GymApplication.scan.nextLine();

        while (!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3")) {
            System.out.println("Invalid input, please enter either '1', '2', or '3'");
            userInput = GymApplication.scan.nextLine();
        }

        if (userInput.equals("1")) {
            PageManager.navigate(Login.class);
        } else if (userInput.equals("2")) {
            PageManager.navigate(Register.class);
        } else {
            PageManager.navigate(Shutdown.class);
        }
    }

}
