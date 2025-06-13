package GUI.controller;

import java.util.Date;

public class Goal {

    String goalDescription;
    Date startDate;
    Date endDate;
    Date timeToComplete;

    public Goal(String description) {
        goalDescription = description;
        startDate = new Date();
    }

    public void completeGoal() {
        endDate = new Date();
    }

    public String toString() {

        StringBuilder goalString = new StringBuilder();

        if (endDate == null) {
            goalString.append("Goal description: \n" + goalDescription);
            goalString.append("\nStart date: " + startDate);
            goalString.append("\nEnd date: not yet completed");
        } else {
            goalString.append("\nGoal description: \n" + goalDescription);
            goalString.append("\nStart date: " + startDate);
            goalString.append("\nEnd date: " + endDate);
        }

        return goalString.toString();
    }
}
