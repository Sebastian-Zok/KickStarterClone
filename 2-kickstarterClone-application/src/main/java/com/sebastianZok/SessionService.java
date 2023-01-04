package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidUsernameException;

import java.util.LinkedList;

public class SessionService implements SessionServiceInterface{

    private UserRepoInterface userRepo;
    public static String loggedInUser;

    public SessionService(UserRepoInterface userRepo) {
        this.userRepo = userRepo;
    }

    public void login(Username userName, Password password) {
        if (this.userRepo.checkUserPassword(userName, password)) {
            loggedInUser = userName.getUsername();
            System.out.println(loggedInUser + " you are now logged in!");
        }else {
            System.out.println("Password or Username incorrect");
        }
    }

    public static String getInstance(){
        return loggedInUser;
    }



}
