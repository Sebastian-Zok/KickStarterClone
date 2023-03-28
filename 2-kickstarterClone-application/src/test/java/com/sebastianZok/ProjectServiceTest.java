package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidUsernameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ProjectServiceTest {

    private ProjectRepoInterface mockedProjectRepository;
    String projectTitle = "test";
    Project mockedProject = new Project(projectTitle, "owner", 1,1, new Timestamp(System.currentTimeMillis()),"active");
    @BeforeEach
    void init() {
        this.mockedProjectRepository = mock(ProjectRepoInterface.class);
        when(mockedProjectRepository.getProject(projectTitle)).thenReturn(mockedProject);
     }

    @Test
    @DisplayName("Correct output for get RemainingDays function")
    public void getRemainingDaysTest()  {
        assertDoesNotThrow(() -> {
            ProjectServiceInterface projectService = new ProjectService(mockedProjectRepository);
            assertEquals(projectService.getRemainingDays(projectTitle), 29);
        });
     }

    @Test
    @DisplayName("Tests if a project is active (true) when remaining days is more than 0")
    public void isProjectActiveTest()  {
        assertDoesNotThrow(() -> {
            ProjectServiceInterface projectService = new ProjectService(mockedProjectRepository);
            assertEquals(projectService.isProjectActive(projectTitle), true);
        });
    }
}
