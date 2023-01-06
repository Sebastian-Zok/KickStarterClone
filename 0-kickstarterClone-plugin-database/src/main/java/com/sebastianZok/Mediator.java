package com.sebastianZok;

import java.io.IOException;
import java.util.ArrayList;

public class Mediator {

    public void mediate(){

        ProjectRepoInterface projectMapper = new ProjectRepo();
        ProjectServiceInterface projectService = new ProjectService(projectMapper);

        BalanceRepoInterface  balanceMapper = new BalanceRepo();
        BalanceService balanceService = new BalanceService(balanceMapper);

        TransactionRepoInterface transactionMapper = new TransactionRepo();
        TransactionServiceInterface transactionService = new TransactionService(transactionMapper);

        ArrayList<Project> activeProjects = projectService.getActiveProjects();

        activeProjects.forEach((project) -> {
            if(!projectService.isProjectActive(project.getTitle())){
                if( transactionService.getProjectPledgeCount(project.getTitle()) * project.getPledge() >= project.getGoal()){
                    // Success
                    try {
                        ArrayList<String> pledgers = transactionService.getProjectPledgers(project.getTitle());
                        for (String pledger : pledgers) {
                            balanceService.decreaseBalance(pledger, project.getPledge());
                        }
                        balanceService.addBalance(project.getOwner(), pledgers.size() * project.getPledge());
                        projectService.setProjectStatus(project, "success");
                    }catch(IOException e){
                        System.out.println(e);
                    }
                }else {
                    projectService.setProjectStatus(project, "failed");
                }
             }
        });

    }

}
