package com.sebastianZok;

import com.sebastianZok.Exceptions.PersistException;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.ChronoUnit.DAYS;

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

    public Project getProject(String title){
        return projectRepo.getProject(title);
    }

    public ArrayList<Project>   getActiveProjects(){
        return projectRepo.getActiveProjects();
    }

    public long getRemainingDays(String title) {
        Project project = projectRepo.getProject(title);
        Calendar cal = Calendar.getInstance();
        cal.setTime(project.getTimestamp());
        cal.add(Calendar.DATE, 30);
        Date deadline = cal.getTime();
        Date today = new Date();
        long diffInMillies =  deadline.getTime() - today.getTime();
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        if(diffInDays > 0){
            return diffInDays;
        }
        return 0;
    }

    public boolean isProjectActive(String title){
        if(getRemainingDays(title)> 0){
            return true;
        }
        return false;
    }

    public void setProjectStatus(Project project, String status){
        projectRepo.setProjectStatus(project, status);
     }

    public ArrayList<Project> getProjectsOfUser(String username){
        return projectRepo.getProjectsOfUser(username);
    }

}
