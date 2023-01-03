package com.sebastianZok.Exceptions;

public class InvalidPasswordException extends Exception
{
    public InvalidPasswordException(String errorMessage){
        super(errorMessage);
    }

}
