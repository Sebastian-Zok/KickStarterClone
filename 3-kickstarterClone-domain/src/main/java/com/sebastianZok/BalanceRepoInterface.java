package com.sebastianZok;

import java.io.IOException;

public interface BalanceRepoInterface {

    void setBalance(String username, int newBalance) throws IOException;

    int getTotal(String username);

    int getAvailable(String username);



}
