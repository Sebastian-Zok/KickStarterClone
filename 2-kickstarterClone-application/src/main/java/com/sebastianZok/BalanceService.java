package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidUsernameException;
import com.sebastianZok.Exceptions.PersistException;

import java.io.IOException;

public class BalanceService implements BalanceServiceInterface{

    private BalanceRepoInterface balanceRepo;

    public BalanceService(BalanceRepoInterface balanceRepo) {
        this.balanceRepo = balanceRepo;
    }


    public int getBalance(String username){
       return this.balanceRepo.getTotal(username);
    }

    public void addBalance(String username, int value) throws IOException {
        int oldBalance = getBalance(username);
        this.balanceRepo.setBalance(username, oldBalance + value);
    }

}
