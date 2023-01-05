package com.sebastianZok;

import java.sql.Timestamp;

public class Project {

    public String title;
    public int goal;
    public String owner;
    public int pledge;
    public Timestamp timestamp;

    public Project(String title, String owner,  int goal, int pledge, Timestamp timestamp) {
        this.title = title;
        this.goal = goal;
        this.owner = owner;
        this.pledge = pledge;
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public int getGoal() {
        return goal;
    }

    public String getOwner() {
        return owner;
    }

    public int getPledge() {
        return pledge;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
