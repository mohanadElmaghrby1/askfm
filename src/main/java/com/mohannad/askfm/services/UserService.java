package com.mohannad.askfm.services;

import com.mohannad.askfm.commands.UserCommand;
import com.mohannad.askfm.model.User;

public interface UserService {

    UserCommand saveUserCommand(UserCommand userCommand);
    User findByID( Long id);
    User findByEmail( String email);
    UserCommand findCommandById(Long id);
    User findByUserName(String username);

}