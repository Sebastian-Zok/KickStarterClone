package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidPasswordException;
import com.sebastianZok.Exceptions.InvalidUsernameException;

import java.util.Arrays;
import java.util.List;

public class Password {


    private final String password;

    Password(String password) throws InvalidPasswordException {
        if(password.length()<4) throw new InvalidPasswordException("Password requires at least four characters");
        for(Character illegalCharacter:illegalCharacter){
            if(password.contains(illegalCharacter.toString())) throw new InvalidPasswordException("password contains illegal symbol");
        }
         this.password = password;
    }

    private final List<Character> illegalCharacter = Arrays.asList(
            '\\',
            ';'
    );

    public String getPassword() {
        return password;
    }

}
