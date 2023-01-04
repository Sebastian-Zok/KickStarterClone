package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidUsernameException;
import com.sebastianZok.Exceptions.PersistException;

import java.util.UUID;

public class UserService {

    private UserRepoInterface userRepo;
    private BalanceRepoInterface balanceRepo;


    public UserService(UserRepoInterface userRepo, BalanceRepoInterface balanceRepo) {
        this.userRepo = userRepo;
        this.balanceRepo = balanceRepo;
    }

    public void createNewUser(Username username, Password password) throws InvalidUsernameException, PersistException {
         this.userRepo.createNewUser(username, password);
         this.balanceRepo.createNewBalance(username);
     }



}
