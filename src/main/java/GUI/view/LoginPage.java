package GUI.view;

import java.awt.Color;

import javax.swing.*;

public class LoginPage extends JPanel {

    private JLabel welcome;

    public LoginPage() {
        JLabel welcome = new JLabel();
        welcome.setText("Welcome to the Gym Tracker Application");
        setSize(WIDTH, HEIGHT);
        setBackground(Color.lightGray);
        add(welcome);

    }

}
