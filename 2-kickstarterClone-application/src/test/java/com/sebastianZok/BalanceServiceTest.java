package com.sebastianZok;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BalanceServiceTest {

    private BalanceRepoInterface mockedBalanceRepository;

    @BeforeEach
    void init() {
        this.mockedBalanceRepository = mock(BalanceRepoInterface.class);
        //when(mockedBalanceRepository.getUserFrom(accountIDofIssuer)).thenReturn(mockedIssuer);
    }


    public static class ProjectServiceTest {
    }
}
