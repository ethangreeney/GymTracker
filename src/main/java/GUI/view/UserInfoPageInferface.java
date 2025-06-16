package GUI.view;

import java.awt.event.ActionListener;

import GUI.model.User;

public interface UserInfoPageInferface {

    void addBackListener(ActionListener e);

    void addEditListener(ActionListener e);

    void addConfirmListener(ActionListener e);

    String getNewName();

    String getNewAge();

    String getNewHeight();

    String getNewWeight();

    void toDisplayPanel();

    void toEditPanel();

    void updateUserInfo(User user);

    void invalidUpdateInfo(String s);

}