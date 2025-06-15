package GUI.view;

public class ViewTesting {
    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        LoginPageInterface lp = new LoginPage();
        RegisterPage rp = new RegisterPage();
        mf.add(rp);
        mf.setVisible(true);

    }

}
