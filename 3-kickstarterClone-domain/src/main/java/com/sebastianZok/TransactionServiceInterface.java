package com.sebastianZok;

import com.sebastianZok.Exceptions.PersistException;

import java.util.ArrayList;

public interface TransactionServiceInterface {
    void createNewPledge(String title) throws PersistException;
    ArrayList<String> getUserPledges(String username);
    ArrayList<String> getProjectPledgers(String title);

    int getProjectPledgeCount(String projectTitle);

    boolean isAlreadyPledged(String title);
}
