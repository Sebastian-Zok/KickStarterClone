package com.sebastianZok.Exceptions;

import com.sebastianZok.Username;

public class UserNotFoundException extends Exception{

     public UserNotFoundException(Username username){
            super("User does not exist '"+username+"'");
        }

}
