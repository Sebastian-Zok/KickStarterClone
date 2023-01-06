package com.sebastianZok;

import com.sebastianZok.Exceptions.PersistException;

import java.util.ArrayList;

public interface ProjectServiceInterface {

       ArrayList<Project> getProjects();
        ArrayList<Project> getProjectsOfUser(String username);

     Project getProject(String title);
     long getRemainingDays(String title);

    boolean isProjectActive(String title);

    void createNewProject(String title, int goal, int pledge) throws PersistException;

}
