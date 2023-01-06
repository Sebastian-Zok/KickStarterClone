package com.sebastianZok;

import java.io.IOException;

public interface BalanceServiceInterface {


      int getBalance(String username);
      int getAvailable(String username);
      void addBalance(String username, int value) throws IOException;

      void decreaseBalance(String username, int value) throws IOException;

}
