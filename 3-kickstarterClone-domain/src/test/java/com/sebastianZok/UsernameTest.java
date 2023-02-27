package com.sebastianZok;
import com.sebastianZok.Exceptions.InvalidUsernameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsernameTest {

    @Test
    @DisplayName("Invalid values for Username")
    public void invalidUsernameValues() throws InvalidUsernameException {
        assertThrows(Exception.class, () -> new Username("a"));
        assertThrows(Exception.class, () -> new Username("VeryLongNameWithMoreThan20Characters"));
        assertThrows(Exception.class, () -> new Username("admin"));
        assertThrows(Exception.class, () -> new Username("WithForbiddenSymbol\\"));
        assertThrows(Exception.class, () -> new Username("\\WithForbiddenSymbol"));
        assertThrows(Exception.class, () -> new Username(";WithForbiddenSymbol\\"));
        assertThrows(Exception.class, () -> new Username("WithForbidden;Symbol"));
    }


    @Test
    @DisplayName("Valid values for Username")
    public void validUsernameValues() throws InvalidUsernameException {
        assertDoesNotThrow(() -> {
            new Username("ValidUsername");
        });
        assertDoesNotThrow(() -> {
            new Username("Name");
        });
        assertDoesNotThrow(() -> {
            new Username("admin2");
        });
    }

    @Test
    @DisplayName("test getUsername")
    public void testGetUsername(){
        assertDoesNotThrow(() -> {
            Username name = new Username("test");
            new Username("test");
            assertEquals(name.getUsername(), "test");
        });
    }

}
