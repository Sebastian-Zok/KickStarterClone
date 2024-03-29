package com.sebastianZok;

import com.sebastianZok.Exceptions.PersistException;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface ProjectRepoInterface {

    void createNewProject(String title, String owner, int goal, int pledge, Timestamp timestamp) throws PersistException;

    ArrayList<Project> getProjects();

     Project getProject(String title);

    String getProjectStatus(String title);

    int getProjectPledge(String title);

    ArrayList<Project> getProjectsOfUser(String username);

    ArrayList<Project> getActiveProjects();

    void setProjectStatus(Project project, String status);
}
