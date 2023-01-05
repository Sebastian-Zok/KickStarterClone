package com.sebastianZok;

import com.sebastianZok.utils.CommandLineReader;

import java.util.ArrayList;

public class Browse implements ControlPanelInterface {

    @Override
    public void inputAction()  throws  Exception {

        ProjectRepoInterface projectMapper = new ProjectRepo();
        ProjectServiceInterface projectService = new ProjectService(projectMapper);
        ArrayList<Project> projects = projectService.getProjects();
        int index = 0;

        try{
            do {

                Project project = projects.get(index);


                System.out.println("############################################");
                System.out.println(project.getTitle());
                System.out.println("Owner: "+project.getOwner());
                System.out.println("Goal: "+project.getGoal());
                System.out.println("Pledge: "+ project.getPledge());
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
                        break;
                    default:
                        break;
                }

                if(input == 4){
                    break;
                }
            } while (true);
        }catch(Exception e){
            System.out.println("You have seen all Projects");
        }

    }

    }