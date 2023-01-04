package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidPasswordException;
import com.sebastianZok.Exceptions.InvalidUsernameException;
import com.sebastianZok.utils.CommandLineReader;

import java.util.ArrayList;

public class CreateAccount implements ControlPanelInterface{


    @Override
    public void inputAction()  throws  Exception {

            System.out.println("Enter username");
            Username username = new Username(CommandLineReader.readLine());
            System.out.println("Enter password");
            Password password = new Password(CommandLineReader.readLine());

            UserRepoInterface userMapper = new UserRepo();
            UserService userService = new UserService(userMapper);

            try {
                if (userMapper.getUsernames().contains(username.getUsername())) {
                    System.out.println("Username already taken");
                } else {
                    userService.createNewUser(username, password);
                    System.out.println("User created successfully!");
                }
            }catch (InvalidUsernameException e) {
                System.out.println(e);
                e.printStackTrace();
            }

    }
}
