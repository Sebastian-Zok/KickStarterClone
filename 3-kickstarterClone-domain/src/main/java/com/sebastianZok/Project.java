package com.sebastianZok;

import java.sql.Timestamp;

public class Project {

    public String title;
    public int goal;
    public String owner;
    public int pledge;
    public Timestamp timestamp;
    public String status;


    public Project(String title, String owner,int goal, int pledge, Timestamp timestamp, String status) {
        this.title = title;
        this.goal = goal;
        this.owner = owner;
        this.pledge = pledge;
        this.timestamp = timestamp;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
