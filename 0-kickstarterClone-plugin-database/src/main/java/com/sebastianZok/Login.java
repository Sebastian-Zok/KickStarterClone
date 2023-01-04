package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidUsernameException;
import com.sebastianZok.utils.CommandLineReader;

public class Login implements ControlPanelInterface{

    @Override
    public void inputAction()  throws  Exception {

        System.out.println("Enter username");
        Username username = new Username(CommandLineReader.readLine());
        System.out.println("Enter password");
        Password password = new Password(CommandLineReader.readLine());

        UserRepoInterface userMapper = new UserRepo();
        SessionService sessionServiceService = new SessionService(userMapper);

        try {
            sessionServiceService.login(username, password);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }
}