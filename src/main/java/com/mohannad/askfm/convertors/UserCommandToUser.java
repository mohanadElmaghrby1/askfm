package com.mohannad.askfm.convertors;

import com.mohannad.askfm.commands.UserCommand;
import com.mohannad.askfm.model.Role;
import com.mohannad.askfm.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;

@Component
public class UserCommandToUser implements Converter<UserCommand , User> {
    @Override
    public User convert(UserCommand userCommand) {
        User user = new User();
        user.setPassword(userCommand.getPassword());
        user.setUsername(userCommand.getUsername());
        user.setName(userCommand.getName());
        user.setId(userCommand.getId());
        user.setActive(1);
        user.setEmail(userCommand.getEmail());
        user.setGender(userCommand.getGender());
        Role userRole = new Role();
        userRole.setRole("USER");
        user.setRoles(new HashSet<Role>(Collections.singleton(userRole)));
        return user;
    }
}
