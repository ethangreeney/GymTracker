import java.util.ArrayList;
import java.util.List;

public class Exercise {

    private String name;
    private List<SetInfo> sets;

    public Exercise(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public List<SetInfo> getSets() {
        if (this.sets == null) {
            sets = new ArrayList<SetInfo>();
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
            returnInformation += "\n   Set " + count++ + ": [Weight: " + set.getWeight() + " kg] [Reps: "
                    + set.getReps() + "]";
        }

        return returnInformation;

    }

}
