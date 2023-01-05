package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidUsernameException;

import java.util.ArrayList;

public class UserAggregate {

    private Username username;
    private int balance;
    private ArrayList<String> transactions;
    private ArrayList<String> projects;

    public UserAggregate(BalanceRepoInterface balanceRepo) throws InvalidUsernameException {
        username = new Username(SessionService.loggedInUser);
      }


}
