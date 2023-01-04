package com.sebastianZok.utils;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class CSVWriter {

    public static void writeLine(String file, String line){
        try(FileWriter pw = new FileWriter(file,true);){
            pw.write(line+"\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateLine(String filePath, String oldRecord, String newRecord) throws IOException {
         Scanner scanner = new Scanner(new File(filePath));
         StringBuffer buffer = new StringBuffer();
         while (scanner.hasNextLine()) {
            buffer.append(scanner.nextLine()+System.lineSeparator());
        }
        String fileContents = buffer.toString();
        scanner.close();
        fileContents = fileContents.replaceAll(oldRecord, newRecord);
        FileWriter writer = new FileWriter(filePath);
        writer.append(fileContents);
        writer.flush();
    }
}
