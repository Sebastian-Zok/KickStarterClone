package com.sebastianZok;

import com.sebastianZok.utils.CommandLineReader;
import com.sebastianZok.utils.CommandLineWriter;


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
                CommandLineWriter.spacer();
                CommandLineWriter.write(project.getTitle());
                CommandLineWriter.write("");
                CommandLineWriter.write("Owner: "+project.getOwner());
                CommandLineWriter.write("Goal: "+project.getGoal());
                CommandLineWriter.write("Pledge: "+ project.getPledge());
                CommandLineWriter.write("Days Left: "+ projectService.getRemainingDays(project.getTitle()));
                CommandLineWriter.write("Raised sum: "+ transactionService.getProjectPledgeCount(project.getTitle()) * project.getPledge());
                CommandLineWriter.spacer();
                CommandLineWriter.write("1| Back");
                CommandLineWriter.write("2| Next");
                CommandLineWriter.write("3| Pledge");
                CommandLineWriter.write("4| Exit");


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
                          CommandLineWriter.write("You already pledged for this project");
                          CommandLineWriter.write("Enter to continue");
                          String awaitEnter = CommandLineReader.readLine();
                          break;
                        }
                        if(!projectService.isProjectActive(project.getTitle())){
                            CommandLineWriter.write("Sorry but the deadline is already over");
                            String awaitEnter = CommandLineReader.readLine();
                            break;
                        }
                        if(balanceService.getAvailable(SessionService.loggedInUser)<project.getPledge()){
                            CommandLineWriter.write("You don't have enough liquidity");
                            String awaitEnter = CommandLineReader.readLine();
                            break;
                        }
                        transactionService.createNewPledge(project.getTitle());
                        CommandLineWriter.write("Pledge successful!");
                        CommandLineWriter.write("Enter to continue");
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
            CommandLineWriter.write("404 - You have seen all projects :(");
        }

    }

    }