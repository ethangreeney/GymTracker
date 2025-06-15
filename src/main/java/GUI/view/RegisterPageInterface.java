package GUI.view;

import java.awt.event.ActionListener;

public interface RegisterPageInterface {

    void addRegisterListener(ActionListener e);

    void addConfirmListener(ActionListener e);

    void duplicateUsername();

    String getUsername();

    String getPassword();

    String getUserName();

    String getUserAge();

    String getUserWeight();

    String getUserHeight();

    void validDetail();

    void invalidUserInfo(String s);

}