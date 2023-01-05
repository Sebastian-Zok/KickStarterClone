package com.sebastianZok;

import com.sebastianZok.Exceptions.PersistException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;

public class ProjectService implements ProjectServiceInterface {

    private ProjectRepoInterface projectRepo;

    public ProjectService(ProjectRepoInterface projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public void createNewProject(String title, int goal, int pledge) throws PersistException {
        projectRepo.createNewProject(title, SessionService.loggedInUser, goal, pledge, new Timestamp(System.currentTimeMillis()));
    }

    public ArrayList<Project> getProjects(){
      return projectRepo.getProjects();
    }

    public ArrayList<Project> getProjectsOfUser(String username){
        return projectRepo.getProjectsOfUser(username);
    }

}
