package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidUsernameException;
import com.sebastianZok.Exceptions.PersistException;
import  com.sebastianZok.utils.CSVReader;
import com.sebastianZok.utils.CSVWriter;


public class UserRepo implements UserRepoInterface {

    public static String USER_FILEPATH = "Data/Users.csv";
    public UserRepo() {}

    public void createNewUser(Username username, Password password) throws PersistException {
        StringBuilder sb = new StringBuilder();
        sb.append(username.getUsername()).append(";").append(password.getPassword());
        CSVWriter.writeLine(USER_FILEPATH, sb.toString());
     }

}

