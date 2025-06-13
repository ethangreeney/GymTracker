package GUI.view;

public class ViewTesting {
    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        LoginPage lp = new LoginPage();
        mf.add(lp);
        mf.setVisible(true);

    }

}
