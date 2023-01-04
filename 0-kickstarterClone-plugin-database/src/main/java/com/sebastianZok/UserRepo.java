package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidUsernameException;
import com.sebastianZok.Exceptions.PersistException;
import  com.sebastianZok.utils.CSVReader;
import com.sebastianZok.utils.CSVWriter;

import java.util.LinkedList;


public class UserRepo implements UserRepoInterface {

    public static String USER_FILEPATH = "Data/Users.csv";
    public UserRepo() {}

    public void createNewUser(Username username, Password password) throws PersistException {
        StringBuilder sb = new StringBuilder();
        sb.append(username.getUsername()).append(";").append(password.getPassword());
        CSVWriter.writeLine(USER_FILEPATH, sb.toString());
     }

    public boolean checkUserPassword(Username username, Password password){
        try{
            LinkedList<String> data = CSVReader.read(USER_FILEPATH);
            for(String row : data){
                String[] rowData = row.split(";");
                if(rowData[0].equals(username.getUsername()) && rowData[1].equals(password.getPassword())) {
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}

