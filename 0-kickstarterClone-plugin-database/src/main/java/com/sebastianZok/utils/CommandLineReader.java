package com.sebastianZok.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandLineReader {
    public static String readLine(){
        try{
            BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
            return buffer.readLine();
        }catch (Exception e){
            System.out.println("Error while reading command line input");
            System.exit(1);
        }
        return null;
    }
}
