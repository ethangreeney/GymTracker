package GUI.model;

import java.util.Date;

public class Goal {

    String goalDescription;
    Date startDate;
    Date endDate;
    // Date timeToComplete;

    public Goal(String description) {
        goalDescription = description;
        startDate = new Date();
    }

    public void completeGoal() {
        endDate = new Date();
    }

    @Override
    public String toString() {

        StringBuilder goalString = new StringBuilder();

        if (endDate == null) {
            goalString.append("Goal description: \n").append(goalDescription);
            goalString.append("\nStart date: ").append(startDate);
            goalString.append("\nEnd date: not yet completed");
        } else {
            goalString.append("\nGoal description: \n").append(goalDescription);
            goalString.append("\nStart date: ").append(startDate);
            goalString.append("\nEnd date: ").append(endDate);
        }

        return goalString.toString();
    }
}
