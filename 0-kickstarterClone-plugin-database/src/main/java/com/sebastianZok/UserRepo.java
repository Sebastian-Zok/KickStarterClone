package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidUsernameException;
import com.sebastianZok.Exceptions.PersistException;
import  com.sebastianZok.utils.CSVReader;
import com.sebastianZok.utils.CSVWriter;

import java.util.ArrayList;
import java.util.LinkedList;

import com.sebastianZok.utils.CommandLineWriter;

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
                    CommandLineWriter.write(username.getUsername() + " you are now logged in!");
                    return true;
                }
            }
        }catch (Exception e){
            CommandLineWriter.write(e.toString());
        }
        CommandLineWriter.write("Password or Username incorrect");

        return false;
    }

    public ArrayList<String> getUsernames(){
        ArrayList<String> usernames = new ArrayList<String>();
        try{
            LinkedList<String> data = CSVReader.read(USER_FILEPATH);
            for(String row : data){
                String[] rowData = row.split(";");
               usernames.add(rowData[0]);
            }
            return usernames;
        }catch (Exception e){
            CommandLineWriter.write(e.toString());
        }
        return null;
    }
}

