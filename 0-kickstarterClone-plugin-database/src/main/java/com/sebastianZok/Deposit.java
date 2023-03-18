package com.sebastianZok;

import com.sebastianZok.utils.CommandLineReader;
import com.sebastianZok.utils.CommandLineWriter;

public class Deposit implements ControlPanelInterface{

    @Override
    public void inputAction()  throws  Exception {

        CommandLineWriter.write("How much would you like to deposit?");
        int value = Integer.parseInt(CommandLineReader.readLine());
        if(!(value > 0)){
            CommandLineWriter.write("Input can't be zero or negative");
        }else {
            BalanceRepo balanceMapper = new BalanceRepo();
            BalanceService balanceService = new BalanceService(balanceMapper);

            try {
                balanceService.addBalance(SessionService.loggedInUser, value);
                CommandLineWriter.write("Deposit successfully!");
            } catch (Exception e) {
                CommandLineWriter.write(e.toString());
                e.printStackTrace();
            }
        }
    }

}
