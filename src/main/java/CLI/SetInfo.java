package CLI;

public class SetInfo {
    private int weight;
    private int reps;

    public SetInfo(int w, int r) {
        this.weight = w;
        this.reps = r;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

}
