package com.sebastianZok;

public class ViewBalance implements ControlPanelInterface{

    @Override
    public void inputAction() {

        BalanceRepoInterface  balanceMapper = new BalanceRepo();
        BalanceService balanceService = new BalanceService(balanceMapper);
        System.out.println("Your current balance is: " + balanceService.getBalance(SessionService.loggedInUser) );

    }
}
