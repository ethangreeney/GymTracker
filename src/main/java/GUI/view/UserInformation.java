package GUI.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class UserInformation extends JPanel {
    private String asciiArt = "";

    private JLabel userInformation;
    private JLabel warningText;
    private JPanel topBar;
    private JButton back;
    private JButton edit;

    public UserInformation() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Utilities.backgroundColour);

    }

    public void addBackListener(ActionListener e) {
        back.addActionListener(e);

    }

}
