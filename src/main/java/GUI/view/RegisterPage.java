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

public class RegisterPage extends JPanel implements RegisterPageInterface {

    private final String asciiArt = """



            ██████╗ ███████╗ ██████╗ ██╗███████╗████████╗███████╗██████╗
            ██╔══██╗██╔════╝██╔════╝ ██║██╔════╝╚══██╔══╝██╔════╝██╔══██╗
            ██████╔╝█████╗  ██║  ███╗██║███████╗   ██║   █████╗  ██████╔╝
            ██╔══██╗██╔══╝  ██║   ██║██║╚════██║   ██║   ██╔══╝  ██╔══██╗
            ██║  ██║███████╗╚██████╔╝██║███████║   ██║   ███████╗██║  ██║
            ╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═╝╚══════╝   ╚═╝   ╚══════╝╚═╝  ╚═╝
            """;

    private final JLabel registerText;
    private final JLabel duplicate;

    private final JPanel registerArea;
    private final JTextField username;
    private final JTextField password;
    private final JLabel usernameLabel;
    private final JLabel passwordLabel;
    private final JButton registerButton;

    private final JPanel userInfo;

    private final JLabel nameLabel;
    private final JLabel ageLabel;
    private final JLabel heightLabel;
    private final JLabel weightLabel;

    private final JTextField name;
    private final JTextField age;
    private final JTextField height;
    private final JTextField weight;
    private final JButton confirm;

    private final Dimension textFieldSize = new Dimension(215, 35);
    private final Dimension mediumGap = new Dimension(0, 15);
    private final Dimension largerGap = new Dimension(0, 35);

    public RegisterPage() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Utilities.backgroundColour);

        registerText = new JLabel(Utilities.toHtmlFormat(asciiArt));
        registerText.setAlignmentX(CENTER_ALIGNMENT);
        registerText.setHorizontalAlignment(SwingConstants.CENTER);
        add(registerText);

        add(Box.createRigidArea(Utilities.buttonGap));
        duplicate = new JLabel(" ");
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

    }

    @Override
    public void addRegisterListener(ActionListener e) {
        registerButton.addActionListener(e);
    }

    @Override
    public void addConfirmListener(ActionListener e) {
        confirm.addActionListener(e);
    }

    @Override
    public void duplicateUsername() {
        duplicate.setText("Duplicate username, please enter a different username");
    }

    @Override
    public String getUsername() {
        return username.getText();
    }

    @Override
    public String getPassword() {
        return password.getText();
    }

    @Override
    public String getInfoName() {
        return name.getText();
    }

    @Override
    public String getInfoAge() {
        return age.getText();
    }

    @Override
    public String getInfoWeight() {
        return weight.getText();
    }

    @Override
    public String getInfoHeight() {
        return height.getText();
    }

    @Override
    public void validDetail() {
        duplicate.setVisible(false);
        remove(registerArea);
        add(userInfo);
    }

    @Override
    public void invalidUserInfo(String s) {
        duplicate.setText("Invalid " + s);
        duplicate.setVisible(true);
    }

}
