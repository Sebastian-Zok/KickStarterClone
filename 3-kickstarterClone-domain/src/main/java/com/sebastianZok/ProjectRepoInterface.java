package com.sebastianZok;

import com.sebastianZok.Exceptions.PersistException;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface ProjectRepoInterface {

    void createNewProject(String title, String owner, int goal, int pledge, Timestamp timestamp) throws PersistException;

    ArrayList<Project> getProjects();
}
