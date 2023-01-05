package com.sebastianZok;

import com.sebastianZok.utils.CommandLineReader;

import java.util.ArrayList;
import java.util.Collections;

public class Browse implements ControlPanelInterface {

    @Override
    public void inputAction()  throws  Exception {

        ProjectRepoInterface projectMapper = new ProjectRepo();
        ProjectServiceInterface projectService = new ProjectService(projectMapper);

        TransactionRepoInterface transactionMapper = new TransactionRepo();
        TransactionServiceInterface transactionService = new TransactionService(transactionMapper);

        BalanceRepoInterface balanceMapper = new  BalanceRepo();
        BalanceServiceInterface balanceService = new BalanceService(balanceMapper);

        ArrayList<Project> projects = projectService.getProjects();
        Collections.shuffle(projects);
        int index = 0;

        try{
            do {

                Project project = projects.get(index);


                System.out.println("############################################");
                System.out.println(project.getTitle());
                System.out.println("Owner: "+project.getOwner());
                System.out.println("Goal: "+project.getGoal());
                System.out.println("Pledge: "+ project.getPledge());
                System.out.println("Raised sum: "+ transactionService.getProjectPledgeCount(project.getTitle()) * project.getPledge());
                System.out.println("############################################");

                System.out.println("1| Back");
                System.out.println("2| Next");
                System.out.println("3| Pledge");
                System.out.println("4| Exit");


                int input = Integer.parseInt(CommandLineReader.readLine());
                switch (input){
                    case 1:
                        if(index > 0){
                            index--;
                        }
                        break;
                    case 2:
                        if(index < projects.size()){
                            index++;
                        }
                       break;
                    case 3:
                        if(transactionService.isAlreadyPledged(project.getTitle())){
                          System.out.println("You already pledged for this project");
                          System.out.println("Enter to continue");
                          String awaitEnter = CommandLineReader.readLine();
                          break;
                        }
                        if(balanceService.getAvailable(SessionService.loggedInUser)>project.getPledge()){
                            transactionService.createNewPledge(project.getTitle());
                            System.out.println("Pledge successful!");
                            System.out.println("Enter to continue");
                            String awaitEnter = CommandLineReader.readLine();
                            break;
                        }
                        System.out.println("You don't have enough liquidity");
                        String awaitEnter = CommandLineReader.readLine();
                        break;
                    default:
                        break;
                }

                if(input == 4){
                    break;
                }
            } while (true);
        }catch(Exception e){
            System.out.println("404 - You have seen all projects :(");
        }

    }

    }