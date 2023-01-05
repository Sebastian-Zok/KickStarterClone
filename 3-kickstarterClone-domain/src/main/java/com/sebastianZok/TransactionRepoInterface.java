package com.sebastianZok;

import com.sebastianZok.Exceptions.PersistException;

import java.util.ArrayList;
import java.util.LinkedList;

public interface TransactionRepoInterface {

    void createNewPledge(String title, String user) throws PersistException;

    ArrayList<String> getUserPledges(String username);

    ArrayList<String> getProjectPledgers(String projectTitle);

    int getProjectPledgeCount(String projectTitle);

}
