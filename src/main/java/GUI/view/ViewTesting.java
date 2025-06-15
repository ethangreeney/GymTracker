package GUI.view;

public class ViewTesting {
    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        LoginPageInterface lp = new LoginPage();
        RegisterPage rp = new RegisterPage();
        HomePage hp = new HomePage();
        WelcomePage wp = new WelcomePage();
        WorkoutPage wop = new WorkoutPage();
        WorkoutHistoryPage wh = new WorkoutHistoryPage();

        mf.add(wh);
        mf.setVisible(true);

    }

}
