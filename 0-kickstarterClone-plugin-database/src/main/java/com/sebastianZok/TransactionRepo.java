package com.sebastianZok;

import com.sebastianZok.Exceptions.PersistException;
import com.sebastianZok.utils.CSVReader;
import com.sebastianZok.utils.CSVWriter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;

public class TransactionRepo implements TransactionRepoInterface{

    public static String Transactions_FILEPATH = "Data/Transactions.csv";
    public TransactionRepo() {}

    public void createNewPledge(String title, String user) throws PersistException {
        StringBuilder sb = new StringBuilder();
        sb.append(title+";").append(user);
        CSVWriter.writeLine(Transactions_FILEPATH, sb.toString());
    }

    public ArrayList<String> getUserPledges(String username){
        ArrayList<String> projects = new ArrayList<String>();
        try{
            LinkedList<String> data = CSVReader.read(Transactions_FILEPATH);
            for(String row : data){
                if(!row.equals("Title;User")){
                    String[] rowData = row.split(";");
                     if(rowData[1].equals(username)){
                    projects.add(rowData[0]);
                     }
                }
            }
            return projects;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<String> getProjectPledgers(String projectTitle){
        ArrayList<String> users = new ArrayList<String>();
        try{
            LinkedList<String> data = CSVReader.read(Transactions_FILEPATH);
            for(String row : data){
                if(!row.equals("Title;User")){
                    String[] rowData = row.split(";");
                    if(rowData[0].equals(projectTitle)){
                        users.add(rowData[1]);
                    }
                }
            }
            return users;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public int getProjectPledgeCount(String projectTitle){
        int count = 0;

        try{
            LinkedList<String> data = CSVReader.read(Transactions_FILEPATH);
            for(String row : data){
                if(!row.equals("Title;User")){
                    String[] rowData = row.split(";");
                    if(rowData[0].equals(projectTitle)){
                    count++;
                    }
                }
            }
            return count;
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }

    public void setTransactions_FILEPATH(String transactions_FILEPATH) {
        Transactions_FILEPATH = transactions_FILEPATH;
    }

}