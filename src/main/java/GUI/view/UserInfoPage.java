package GUI.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class UserInfoPage extends JPanel {
    private String asciiArt = "";

    private JLabel userInformation;
    private JLabel warningText;
    private JPanel topBar;
    private JButton back;
    private JButton edit;

    public UserInfoPage() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Utilities.backgroundColour);

        add(Box.createRigidArea(Utilities.buttonGap));

        topBar = new JPanel();
        topBar.setBackground(this.getBackground());
        topBar.setLayout(new BoxLayout(topBar, BoxLayout.X_AXIS));

        back = new JButton("Back");
        topBar.add(Box.createHorizontalGlue());
        topBar.add(back);
        topBar.add(Box.createHorizontalStrut(20));
        topBar.setMaximumSize(Utilities.topBarGap(topBar));

        add(topBar);

    }

    public void addBackListener(ActionListener e) {
        back.addActionListener(e);

    }

}
