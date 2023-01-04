package com.sebastianZok;

import com.sebastianZok.Exceptions.InvalidUsernameException;


public interface SessionServiceInterface {


    void login(Username username, Password password) throws InvalidUsernameException;


}
