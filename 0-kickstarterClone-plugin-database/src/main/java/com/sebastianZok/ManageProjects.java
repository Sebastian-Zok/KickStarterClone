package com.sebastianZok;

import java.util.ArrayList;

public class ManageProjects implements ControlPanelInterface {

    @Override
    public void inputAction() {

        ProjectRepoInterface  projectMapper = new ProjectRepo();
        ProjectService projectService = new ProjectService(projectMapper);

        TransactionRepoInterface transactionMapper = new TransactionRepo();
        TransactionServiceInterface transactionService = new TransactionService(transactionMapper);

        ArrayList<Project> userProjects = projectService.getProjectsOfUser(SessionService.loggedInUser);

        System.out.println("######################################################");
        System.out.println("Your projects: ");
        System.out.println("######################################################");

        userProjects.forEach((project) -> {
        System.out.println("" +
                        "Title: "+project.getTitle() + "\n" +
                        "Status: "+project.getStatus() + "\n" +
                        "Days Left: "+ projectService.getRemainingDays(project.getTitle())+ "\n" +
                        "Goal: "+project.getGoal() + "\n" +
                        "Pledge: "+project.getPledge() + "\n" +
                        "Raised sum: "+ transactionService.getProjectPledgeCount(project.getTitle()) * project.getPledge() + "\n" +
                        "Pledgers: "+   String.join(", ", transactionService.getProjectPledgers(project.getTitle()))
                );
        System.out.println("######################################################"); }
        );

        System.out.println("Projects you pledged for: ");
        System.out.println("######################################################");

        ArrayList<String> pledges = transactionService.getUserPledges(SessionService.loggedInUser);

        pledges.forEach((pledge) -> {
            Project project = projectService.getProject(pledge);
            System.out.println("" +
                    "Title: "+project.getTitle() + "\n" +
                    "Status: "+project.getStatus() + "\n" +
                    "Days Left: "+ projectService.getRemainingDays(project.getTitle())+ "\n" +
                    "Goal: "+project.getGoal() + "\n" +
                    "Raised sum: "+ transactionService.getProjectPledgeCount(project.getTitle()) * project.getPledge() + "\n" +
                    "Pledge: "+project.getPledge()
            );
            System.out.println("######################################################"); }
        );


    }
}
