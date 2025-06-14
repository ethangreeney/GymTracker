package GUI.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegisterPage extends JPanel {

    private String asciiArt = """



            ██████╗ ███████╗ ██████╗ ██╗███████╗████████╗███████╗██████╗
            ██╔══██╗██╔════╝██╔════╝ ██║██╔════╝╚══██╔══╝██╔════╝██╔══██╗
            ██████╔╝█████╗  ██║  ███╗██║███████╗   ██║   █████╗  ██████╔╝
            ██╔══██╗██╔══╝  ██║   ██║██║╚════██║   ██║   ██╔══╝  ██╔══██╗
            ██║  ██║███████╗╚██████╔╝██║███████║   ██║   ███████╗██║  ██║
            ╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═╝╚══════╝   ╚═╝   ╚══════╝╚═╝  ╚═╝
            """;

    private JLabel registerText;
    private JLabel duplicate;

    private JPanel registerArea;
    private JTextField username;
    private JTextField password;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton registerButton;

    private JPanel userInfo;

    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel heightLabel;
    private JLabel weightLabel;

    private JTextField name;
    private JTextField age;
    private JTextField height;
    private JTextField weight;
    private JButton confirm;

    private Dimension textFieldSize = new Dimension(215, 35);
    private Dimension mediumGap = new Dimension(0, 15);
    private Dimension largerGap = new Dimension(0, 35);

    public RegisterPage() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Utilities.backgroundColour);

        registerText = new JLabel(Utilities.toHtmlFormat(asciiArt));
        registerText.setAlignmentX(CENTER_ALIGNMENT);
        registerText.setHorizontalAlignment(SwingConstants.CENTER);
        add(registerText);

        add(Box.createRigidArea(Utilities.buttonGap));
        duplicate = new JLabel("PLACEHOLDER");
        duplicate.setForeground(Color.RED);
        duplicate.setAlignmentX(CENTER_ALIGNMENT);
        add(duplicate);

        add(Box.createRigidArea(largerGap));

        registerArea = new JPanel();
        registerArea.setBackground(this.getBackground());
        registerArea.setLayout(new BoxLayout(registerArea, BoxLayout.Y_AXIS));

        usernameLabel = new JLabel("Username: ");
        usernameLabel.setAlignmentX(CENTER_ALIGNMENT);
        registerArea.add(usernameLabel);

        username = new JTextField();
        username.setPreferredSize(textFieldSize);
        username.setMaximumSize(textFieldSize);
        username.setMinimumSize(textFieldSize);
        username.setAlignmentX(CENTER_ALIGNMENT);
        registerArea.add(username);

        registerArea.add(Box.createRigidArea(mediumGap));

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setAlignmentX(CENTER_ALIGNMENT);
        registerArea.add(passwordLabel);

        password = new JTextField();
        password.setPreferredSize(textFieldSize);
        password.setMaximumSize(textFieldSize);
        password.setMinimumSize(textFieldSize);
        password.setAlignmentX(CENTER_ALIGNMENT);
        registerArea.add(password);

        registerButton = new JButton("Register");
        registerButton.setAlignmentX(CENTER_ALIGNMENT);
        registerArea.add(registerButton);

        add(registerArea);

        userInfo = new JPanel();
        userInfo.setLayout(new BoxLayout(userInfo, BoxLayout.Y_AXIS));
        userInfo.setBackground(this.getBackground());

        nameLabel = new JLabel("Name: ");
        nameLabel.setAlignmentX(CENTER_ALIGNMENT);
        userInfo.add(nameLabel);

        name = new JTextField();
        name.setPreferredSize(textFieldSize);
        name.setMaximumSize(textFieldSize);
        name.setMinimumSize(textFieldSize);
        name.setAlignmentX(CENTER_ALIGNMENT);
        userInfo.add(name);

        ageLabel = new JLabel("Age: ");
        ageLabel.setAlignmentX(CENTER_ALIGNMENT);
        userInfo.add(ageLabel);

        age = new JTextField();
        age.setPreferredSize(textFieldSize);
        age.setMaximumSize(textFieldSize);
        age.setMinimumSize(textFieldSize);
        age.setAlignmentX(CENTER_ALIGNMENT);
        userInfo.add(age);

        heightLabel = new JLabel("Height: ");
        heightLabel.setAlignmentX(CENTER_ALIGNMENT);
        userInfo.add(heightLabel);

        height = new JTextField();
        height.setPreferredSize(textFieldSize);
        height.setMaximumSize(textFieldSize);
        height.setMinimumSize(textFieldSize);
        height.setAlignmentX(CENTER_ALIGNMENT);
        userInfo.add(height);

        weightLabel = new JLabel("Weight: ");
        weightLabel.setAlignmentX(CENTER_ALIGNMENT);
        userInfo.add(weightLabel);

        weight = new JTextField();
        weight.setPreferredSize(textFieldSize);
        weight.setMaximumSize(textFieldSize);
        weight.setMinimumSize(textFieldSize);
        weight.setAlignmentX(CENTER_ALIGNMENT);
        userInfo.add(weight);

        confirm = new JButton("Confirm Details");
        confirm.setAlignmentX(CENTER_ALIGNMENT);

        userInfo.add(confirm);

        add(userInfo);

    }

    public void addRegisterListener(ActionListener e) {
        registerButton.addActionListener(e);
    }

    public void duplicateUsername() {
        duplicate.setText("Duplicate username, please enter a different username");
    }

    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public void validDetail() {
        duplicate.setVisible(false);
        registerArea.setVisible(false);
        userInfo.setVisible(true);
    }

}
