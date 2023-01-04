package com.sebastianZok;

import com.sebastianZok.Exceptions.PersistException;

import java.util.ArrayList;


public interface UserRepoInterface {



        void createNewUser(Username username, Password password) throws PersistException;

        boolean checkUserPassword(Username username, Password password);

        public ArrayList<String> getUsernames();






}
