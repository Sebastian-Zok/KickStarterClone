package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidPasswordException;
import com.sebastianZok.Exceptions.InvalidUsernameException;
import com.sebastianZok.utils.CommandLineReader;

import java.util.ArrayList;
import com.sebastianZok.utils.CommandLineWriter;

public class CreateAccount implements ControlPanelInterface{


    @Override
    public void inputAction()  throws  Exception {

            CommandLineWriter.write("Enter username");
            Username username = new Username(CommandLineReader.readLine());
            CommandLineWriter.write("Enter password");
            Password password = new Password(CommandLineReader.readLine());

            UserRepoInterface userMapper = new UserRepo();
            BalanceRepoInterface balanceMapper = new BalanceRepo();
            UserService userService = new UserService(userMapper, balanceMapper);

            try {
                if (userMapper.getUsernames().contains(username.getUsername())) {
                    CommandLineWriter.write("Username already taken");
                } else {
                    userService.createNewUser(username, password);
                    CommandLineWriter.write("User created successfully!");
                }
            }catch (InvalidUsernameException e) {
                CommandLineWriter.write(e.toString());
                e.printStackTrace();
            }

    }
}
