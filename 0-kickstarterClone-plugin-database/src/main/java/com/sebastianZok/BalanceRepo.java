package com.sebastianZok;

import com.sebastianZok.Exceptions.PersistException;
import com.sebastianZok.utils.CSVReader;
import com.sebastianZok.utils.CSVWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class BalanceRepo implements BalanceRepoInterface{

    public static String USER_FILEPATH = "Data/Balances.csv";
    public BalanceRepo() {}

   public void setBalance(String username, int newBalance) throws IOException {
        int oldBalance = getTotal(username);
        CSVWriter.updateLine("Data/Balances.csv", username+";"+oldBalance, username+";"+newBalance);
   }

    public int getTotal(String username){
        int total = 0;
         try{
            LinkedList<String> data = CSVReader.read(USER_FILEPATH);
            for(String row : data){
                String[] rowData = row.split(";");
                if(username.equals(rowData[0])){
                    total = Integer.parseInt(rowData[1]);
                }
            }
            return total;
        }catch (Exception e){
            System.out.println(e);
        }
        return total;
    }


    public int getAvailable(String username){
        try{
            LinkedList<String> data = CSVReader.read(USER_FILEPATH);
            for(String row : data){
                String[] rowData = row.split(";");
                if(username == rowData[0]) return Integer.parseInt(rowData[1]);
            }
            return 0;
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }
}
