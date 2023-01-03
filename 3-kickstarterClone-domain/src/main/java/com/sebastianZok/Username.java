package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidUsernameException;
import java.util.List;
import java.util.Arrays;
public class Username {

    private final String username;

    Username(String username) throws InvalidUsernameException {
        if(username.length()<4) throw new InvalidUsernameException("Username requires more than 4 characters");
        if(username.length()>20) throw new InvalidUsernameException("Username requires less than 20 characters");
        if(username == "admin") throw new InvalidUsernameException("Username forbidden");
        for(Character illegalCharacter:illegalCharacter){
            if(username.contains(illegalCharacter.toString())) throw new InvalidUsernameException("username: "+username+" contains illegal symbol");
        }

        // TODO check for already in use
        this.username = username;
    }


    private final List<Character> illegalCharacter = Arrays.asList(
            '\\',
            ';'
    );


    public String getUsername() {
        return username;
    }


}
