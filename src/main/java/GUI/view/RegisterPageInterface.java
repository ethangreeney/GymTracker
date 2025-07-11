package GUI.view;

import java.awt.event.ActionListener;

// Registerpage interface for model use
public interface RegisterPageInterface {

    void addRegisterListener(ActionListener e);

    void addConfirmListener(ActionListener e);

    void duplicateUsername();

    String getUsername();

    String getPassword();

    String getInfoName();

    String getInfoAge();

    String getInfoWeight();

    String getInfoHeight();

    void validDetail();

    void invalidUserInfo(String s);

    void failedToSaveData();

    void reset();

    void emptyInfo();

    public void addBackListener(ActionListener e);

}