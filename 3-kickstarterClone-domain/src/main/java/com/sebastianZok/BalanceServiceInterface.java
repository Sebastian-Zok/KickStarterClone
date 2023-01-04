package com.sebastianZok;

import java.io.IOException;

public interface BalanceServiceInterface {


    public int getBalance(String username);

    public void addBalance(String username, int value) throws IOException;
}
