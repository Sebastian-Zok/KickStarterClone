package com.sebastianZok;

import java.util.ArrayList;

public class ManageProjects implements ControlPanelInterface {

    @Override
    public void inputAction() {

        ProjectRepoInterface  projectMapper = new ProjectRepo();
        ProjectService projectService = new ProjectService(projectMapper);

        ArrayList<Project> userProjects = projectService.getProjectsOfUser(SessionService.loggedInUser);

        System.out.println("Your projects: ");

userProjects.forEach((project) ->
        System.out.println(project.getGoal()));



        BalanceRepoInterface  balanceMapper = new BalanceRepo();
        BalanceService balanceService = new BalanceService(balanceMapper);
        System.out.println("Your total balance is " + balanceService.getBalance(SessionService.loggedInUser) );
        System.out.println(balanceService.getAvailable(SessionService.loggedInUser) + " is still available");
        System.out.println((balanceService.getBalance(SessionService.loggedInUser) - balanceService.getAvailable(SessionService.loggedInUser)) + " is pledged");

    }
}
