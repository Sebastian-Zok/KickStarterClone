package com.sebastianZok.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;


public class CSVReader {
    public static LinkedList<String> read(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        scanner.useDelimiter("\r\n");

        LinkedList<String> data = new LinkedList<String>();

        while (scanner.hasNext()) {
            data.add(scanner.next());
        }
        scanner.close();
        return data;
    }



    public static String getFirstRowStringFromCSV(String value, int position, String file){
        try{
            LinkedList<String> csvData = read(file);
            for(String row : csvData){
                String[] rowData = row.split(";");
                if(rowData[position].equals(value)) {
                    return row;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }


}
