package com.sebastianZok;

import java.util.ArrayList;
import com.sebastianZok.utils.CommandLineWriter;

public class ManageProjects extends CreateProject implements ControlPanelInterface {

    @Override
    public void inputAction() {

        ProjectRepoInterface  projectMapper = new ProjectRepo();
        ProjectService projectService = new ProjectService(projectMapper);

        TransactionRepoInterface transactionMapper = new TransactionRepo();
        TransactionServiceInterface transactionService = new TransactionService(transactionMapper);

        ArrayList<Project> userProjects = projectService.getProjectsOfUser(SessionService.loggedInUser);

        CommandLineWriter.spacer();
        CommandLineWriter.write("Your projects: ");
        CommandLineWriter.spacer();

        userProjects.forEach((project) -> {
        CommandLineWriter.write("" +
                        "Title: "+project.getTitle() + "\n" +
                        "Status: "+project.getStatus() + "\n" +
                        "Days Left: "+ projectService.getRemainingDays(project.getTitle())+ "\n" +
                        "Goal: "+project.getGoal() + "\n" +
                        "Pledge: "+project.getPledge() + "\n" +
                        "Raised sum: "+ transactionService.getProjectPledgeCount(project.getTitle()) * project.getPledge() + "\n" +
                        "Pledgers: "+   String.join(", ", transactionService.getProjectPledgers(project.getTitle()))
                );
        CommandLineWriter.spacer(); }
        );

        CommandLineWriter.write("Projects you pledged for: ");
        CommandLineWriter.spacer();

        ArrayList<String> pledges = transactionService.getUserPledges(SessionService.loggedInUser);

        pledges.forEach((pledge) -> {
            Project project = projectService.getProject(pledge);
            CommandLineWriter.write("" +
                    "Title: "+project.getTitle() + "\n" +
                    "Status: "+project.getStatus() + "\n" +
                    "Days Left: "+ projectService.getRemainingDays(project.getTitle())+ "\n" +
                    "Goal: "+project.getGoal() + "\n" +
                    "Raised sum: "+ transactionService.getProjectPledgeCount(project.getTitle()) * project.getPledge() + "\n" +
                    "Pledge: "+project.getPledge()
            );
            CommandLineWriter.spacer(); }
        );


    }
}
