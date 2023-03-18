package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidUsernameException;
import com.sebastianZok.utils.CommandLineReader;
import com.sebastianZok.utils.CommandLineWriter;

public class Login implements ControlPanelInterface{

    @Override
    public void inputAction()  throws  Exception {

        CommandLineWriter.write("Enter username");
        Username username = new Username(CommandLineReader.readLine());
        CommandLineWriter.write("Enter password");
        Password password = new Password(CommandLineReader.readLine());

        UserRepoInterface userMapper = new UserRepo();
        SessionService sessionService = new SessionService(userMapper);

        try {
            sessionService.login(username, password);
            System.out.println(username + " you are now logged in!");
        } catch (Exception e) {
            CommandLineWriter.write(e.toString());
            e.printStackTrace();
        }

    }
}