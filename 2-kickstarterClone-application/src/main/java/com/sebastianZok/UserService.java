package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidUsernameException;
import com.sebastianZok.Exceptions.PersistException;

import java.util.UUID;

public class UserService {

    private UserRepoInterface userRepo;


    public UserService(UserRepoInterface userRepo) {
        this.userRepo = userRepo;
    }

    public String createNewUser(Username userName, Password password) throws InvalidUsernameException, PersistException {
         this.userRepo.createNewUser(userName, password);
         return null;
     }
}
