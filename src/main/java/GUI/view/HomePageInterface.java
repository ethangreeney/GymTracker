package GUI.view;

import java.awt.event.ActionListener;

import GUI.model.User;

//home page interface for model use
public interface HomePageInterface {

    void setWelcomeMessage(User user);

    void addNewWorkoutListener(ActionListener e);

    void addWorkoutHistoryListener(ActionListener e);

    void addUserInfoListener(ActionListener e);

    void addGoalListener(ActionListener e);

    void addLogoutListener(ActionListener e);

}