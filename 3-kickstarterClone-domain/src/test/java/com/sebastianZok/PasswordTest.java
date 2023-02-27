package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidUsernameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {

    @Test
    @DisplayName("Invalid values for Password")
    public void invalidPasswordValues() throws InvalidUsernameException {
        assertThrows(Exception.class, () -> new Password("a"));
        assertThrows(Exception.class, () -> new Password("WithForbiddenSymbol\\"));
        assertThrows(Exception.class, () -> new Password("\\WithForbiddenSymbol"));
        assertThrows(Exception.class, () -> new Password(";WithForbiddenSymbol\\"));
        assertThrows(Exception.class, () -> new Password("WithForbidden;Symbol"));
    }


    @Test
    @DisplayName("Valid values for Username")
    public void validPasswordValues() throws InvalidUsernameException {
        assertDoesNotThrow(() -> {
            new Password("ValidPassword");
        });
        assertDoesNotThrow(() -> {
            new Username("Name");
        });
        assertDoesNotThrow(() -> {
            new Username("admin2");
        });
    }

    @Test
    @DisplayName("test getPassword")
    public void testGetPassword(){
        assertDoesNotThrow(() -> {
            Password name = new Password("test");
            assertEquals(name.getPassword(), "test");
        });
    }

}
