package com.sebastianZok;

public class ViewBalance implements ControlPanelInterface{

    @Override
    public void inputAction() {

        BalanceRepoInterface  balanceMapper = new BalanceRepo();
        BalanceService balanceService = new BalanceService(balanceMapper);
        System.out.println("Your total balance is " + balanceService.getBalance(SessionService.loggedInUser) );
        System.out.println(balanceService.getAvailable(SessionService.loggedInUser) + " is still available");
        System.out.println((balanceService.getBalance(SessionService.loggedInUser) - balanceService.getAvailable(SessionService.loggedInUser)) + " is pledged");

    }
}
