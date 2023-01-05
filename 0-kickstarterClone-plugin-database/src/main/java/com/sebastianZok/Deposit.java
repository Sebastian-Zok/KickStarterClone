package com.sebastianZok;

import com.sebastianZok.utils.CommandLineReader;

public class Deposit implements ControlPanelInterface{

    @Override
    public void inputAction()  throws  Exception {

        System.out.println("How much would you like to deposit?");
        int value = Integer.parseInt(CommandLineReader.readLine());
        if(!(value > 0)){
            System.out.println("Input can't be zero or negative");
        }else {
            BalanceRepo balanceMapper = new BalanceRepo();
            BalanceService balanceService = new BalanceService(balanceMapper);

            try {
                balanceService.addBalance(SessionService.loggedInUser, value);
                System.out.println("Deposit successfully!");
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
    }

}
