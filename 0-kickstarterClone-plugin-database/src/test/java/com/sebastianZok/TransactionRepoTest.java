package com.sebastianZok;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TransactionRepoTest {

    private TransactionRepoInterface mockedTransactionRepo = new TransactionRepo();
    String transactions_FILEPATH = "../Data/MockData/MockTransactions.csv";
     @BeforeEach
    void init() {
       mockedTransactionRepo.setTransactions_FILEPATH(transactions_FILEPATH);
     }

    @Test
    @DisplayName("Correct output for getProjectPledgeCount function")
    public void getProjectPledgeCountTest()  {
        assertDoesNotThrow(() -> {
            assertEquals(mockedTransactionRepo.getProjectPledgeCount("test"), 2);
        });
     }

    @Test
    @DisplayName("Correct output for getProjectPledgeCount function")
    public void getProjectPledgersTest()  {
        assertDoesNotThrow(() -> {
            ArrayList<String> expectedOutput = new ArrayList<String>();
            expectedOutput.add("asdf");
            expectedOutput.add("buyer");
            assertEquals(mockedTransactionRepo.getProjectPledgers("test"), expectedOutput);
        });
    }

}
