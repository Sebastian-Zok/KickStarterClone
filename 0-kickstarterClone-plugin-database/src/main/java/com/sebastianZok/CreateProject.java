package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidUsernameException;
import com.sebastianZok.utils.CommandLineReader;

public class CreateProject implements ControlPanelInterface {

    @Override
    public void inputAction()  throws  Exception {

        System.out.println("What is the name of your Project?");
        String title = CommandLineReader.readLine();
        System.out.println("How much would you like to raise? (integer)");
        int goal = Integer.parseInt(CommandLineReader.readLine());
        System.out.println("How much is the pledge? (integer)");
        int pledge = Integer.parseInt(CommandLineReader.readLine());

        ProjectRepoInterface projectMapper = new ProjectRepo();
        ProjectServiceInterface projectService = new ProjectService(projectMapper);

        try {
            projectService.createNewProject(title, goal, pledge);
            System.out.println("Project successfully created. You have now 30 days to reach your goal!");
        }catch (Exception e) {
             System.out.println(e);
            e.printStackTrace();
        }
    }
}
