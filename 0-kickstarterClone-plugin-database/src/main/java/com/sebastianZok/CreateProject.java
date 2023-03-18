package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidUsernameException;
import com.sebastianZok.utils.CommandLineReader;
import com.sebastianZok.utils.CommandLineWriter;

public class CreateProject implements ControlPanelInterface {

    @Override
    public void inputAction()  throws  Exception {

        CommandLineWriter.write("What is the name of your Project?");
        String title = CommandLineReader.readLine();
        CommandLineWriter.write("How much would you like to raise? (integer)");
        int goal = Integer.parseInt(CommandLineReader.readLine());
        CommandLineWriter.write("How much is the pledge? (integer)");
        int pledge = Integer.parseInt(CommandLineReader.readLine());

        ProjectRepoInterface projectMapper = new ProjectRepo();
        ProjectServiceInterface projectService = new ProjectService(projectMapper);

        try {
            projectService.createNewProject(title, goal, pledge);
            CommandLineWriter.write("Project successfully created. You have now 30 days to reach your goal!");
        }catch (Exception e) {
             CommandLineWriter.write(e.toString());
            e.printStackTrace();
        }
    }
}
