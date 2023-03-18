package com.sebastianZok;
import com.sebastianZok.utils.CommandLineWriter;

public class ViewBalance implements ControlPanelInterface{

    @Override
    public void inputAction() {

        BalanceRepoInterface  balanceMapper = new BalanceRepo();
        BalanceService balanceService = new BalanceService(balanceMapper);
        CommandLineWriter.write("Your total balance is " + balanceService.getBalance(SessionService.loggedInUser) );
        CommandLineWriter.write(balanceService.getAvailable(SessionService.loggedInUser) + " is still available");
        CommandLineWriter.write((balanceService.getBalance(SessionService.loggedInUser) - balanceService.getAvailable(SessionService.loggedInUser)) + " is pledged");

    }
}
