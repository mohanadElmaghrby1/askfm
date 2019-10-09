package com.mohannad.askfm.convertors;

import com.mohannad.askfm.commands.UserCommand;
import com.mohannad.askfm.model.Role;
import com.mohannad.askfm.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashSet;

@Component
public class UserToUserCommand implements Converter<User , UserCommand> {

    @Override
    public UserCommand convert(User user) {
        UserCommand userCommand = new UserCommand();
        userCommand.setPassword(user.getPassword());
        userCommand.setUsername(user.getUsername());
        userCommand.setEmail(user.getEmail());
        userCommand.setBirthDay(20);
        userCommand.setId(user.getId());
        userCommand.setGender(user.getGender());
        userCommand.setLanguage("english");
        userCommand.setName(user.getName());
        userCommand.setBio(user.getBio());
        userCommand.setLocation(user.getLocation());
        userCommand.setWeb(user.getWeb());
        userCommand.setHashTags(user.getHashTags());
        Role userRole = new Role();
        userRole.setRole("USER");
        user.setRoles(new HashSet<Role>(Collections.singleton(userRole)));
        return userCommand;
    }
}
