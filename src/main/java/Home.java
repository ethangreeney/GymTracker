public class Home implements Page {

    @Override
    public void display() {
        System.out.println("""
                1. Start Workout
                2. Veiw workout History
                3. Set and Veiw Goals
                4. User Info
                5. Save Info and Log Out
                """);
    }

    @Override
    public void handleInput() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleInput'");
    }

}
