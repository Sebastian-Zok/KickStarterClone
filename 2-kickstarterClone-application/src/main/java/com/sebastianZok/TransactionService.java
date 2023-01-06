package com.sebastianZok;

import com.sebastianZok.Exceptions.PersistException;

import java.sql.Timestamp;
import java.util.ArrayList;

public class TransactionService implements TransactionServiceInterface {

    private TransactionRepoInterface  transactionRepo;


    public TransactionService(TransactionRepoInterface transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    public void createNewPledge(String title) throws PersistException {
        transactionRepo.createNewPledge(title, SessionService.loggedInUser);
    }

    public ArrayList<String> getUserPledges(String username){
        return transactionRepo.getUserPledges(username);
    }

    public ArrayList<String> getProjectPledgers(String title){
        return transactionRepo.getProjectPledgers(title);
    }

    public int getProjectPledgeCount(String title){
        return transactionRepo.getProjectPledgeCount(title);
    }

    public boolean isAlreadyPledged(String title){
        ArrayList<String> pledges = transactionRepo.getUserPledges(SessionService.loggedInUser);
        return pledges.contains(title);
    }

}
