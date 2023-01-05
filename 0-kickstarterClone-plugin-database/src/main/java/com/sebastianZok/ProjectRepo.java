package com.sebastianZok;

import com.sebastianZok.Exceptions.PersistException;
import com.sebastianZok.utils.CSVReader;
import com.sebastianZok.utils.CSVWriter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;

public class ProjectRepo implements ProjectRepoInterface {


    public static String USER_FILEPATH = "Data/Projects.csv";
    public ProjectRepo() {}

    public void createNewProject(String title, String owner, int goal, int pledge, Timestamp timestamp) throws PersistException {
        StringBuilder sb = new StringBuilder();
        sb.append(title+";").append(owner+";").append(goal+";").append(pledge+";").append(timestamp);
        CSVWriter.writeLine(USER_FILEPATH, sb.toString());
    }



    public ArrayList<Project> getProjects(){
        ArrayList<Project> projects = new ArrayList<Project>();
        try{
            LinkedList<String> data = CSVReader.read(USER_FILEPATH);
            for(String row : data){
                if(!row.equals("Title;Owner;Goal;Pledge;Timestamp")){
                String[] rowData = row.split(";");
                Timestamp ts = Timestamp.valueOf(rowData[4]);
                projects.add(new Project(rowData[0], rowData[1], Integer.parseInt(rowData[2]), Integer.parseInt(rowData[3]), ts));
            }
            }
            return projects;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

}
