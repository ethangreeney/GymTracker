package GUI.view;

import java.awt.event.ActionListener;
import java.util.List;

public interface WorkoutPageInterface {

    String getWorkoutName();

    void addSecondNextListener(ActionListener e);

    void addBackListener(ActionListener e);

    void userExercises(List<String> StringList);

    void addFirstNextListener(ActionListener e);

    void reset();

}