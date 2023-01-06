package com.sebastianZok;

import java.util.ArrayList;

public class Mediator {

    public void mediate(){

        ProjectRepoInterface projectMapper = new ProjectRepo();
        ProjectServiceInterface projectService = new ProjectService(projectMapper);

        BalanceRepoInterface  balanceMapper = new BalanceRepo();
        BalanceService balanceService = new BalanceService(balanceMapper);

        TransactionRepoInterface transactionMapper = new TransactionRepo();
        TransactionServiceInterface transactionService = new TransactionService(transactionMapper);

       /* ArrayList<Project> activeProjects = getActiveProjects();
        activeProjects.forEach((project) -> {
            if(projecthasDeadline){
                if is project success;
                than transact;

                set project status;
            }
        });
*/

    }

}
