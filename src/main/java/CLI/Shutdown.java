package CLI;

public class Shutdown implements Page {

    @Override
    public void display() {
        System.exit(0);

    }

    @Override
    public void handleInput() {

    }

}
