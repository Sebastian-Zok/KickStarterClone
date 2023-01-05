package com.sebastianZok;


import java.io.IOException;

public class BalanceService implements BalanceServiceInterface{

    private BalanceRepoInterface balanceRepo;

    public BalanceService(BalanceRepoInterface balanceRepo) {
        this.balanceRepo = balanceRepo;
    }

    public int getBalance(String username){
       return this.balanceRepo.getTotal(username);
    }
    public int getAvailable(String username){
        return this.balanceRepo.getAvailable(username);
    }



    public void addBalance(String username, int value) throws IOException {
        int oldBalance = getBalance(username);
        this.balanceRepo.setBalance(username, oldBalance + value);
    }

}
