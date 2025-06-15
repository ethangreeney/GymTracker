package GUI.model;

import java.util.ArrayList;
import java.util.List;

public class Exercise {

    private final String name;
    private List<SetInfo> sets;

    public Exercise(String exerciseName) {
        this.name = exerciseName;
    }

    public String getName() {
        return name;
    }

    public List<SetInfo> getSets() {
        if (this.sets == null) {
            sets = new ArrayList<>();
        }
        return sets;
    }

    public void addSet(int w, int r) {
        this.getSets().add(new SetInfo(w, r));
    }

    @Override
    public String toString() {

        String returnInformation = getName();

        int count = 1;

        for (SetInfo set : sets) {
            returnInformation += "\n   Set " + count++ + ": [Weight: " + set.getWeight() + " KG] [Reps: "
                    + set.getReps() + "]";
        }

        return returnInformation;

    }

}
