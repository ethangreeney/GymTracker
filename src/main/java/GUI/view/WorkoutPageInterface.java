package GUI.view;

import java.awt.event.ActionListener;
import java.util.List;

public interface WorkoutPageInterface {

    String getWorkoutName();

    String getExerciseChoice();

    Integer getSetNumber();

    String getReps();

    String getWeight();

    void addFirstNextListener(ActionListener e);

    void addSecondNextListener(ActionListener e);

    void addThirdNextListener(ActionListener e);

    void reset();

    void addBackListener(ActionListener e);

    void addExercisesList(List<String> exerciseList);

    void addSetList(List<Integer> setList);

    void toSecondPage();

    void toThirdPage();

    void invalidWorkoutName();

    void invalidExerciseName();

    void invalidReps();

    void invalidWeight();

    void SetNumber(int setNumber);

}