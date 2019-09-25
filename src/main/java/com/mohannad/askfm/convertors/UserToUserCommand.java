package com.mohannad.askfm.convertors;

import com.mohannad.askfm.commands.UserCommand;
import com.mohannad.askfm.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

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
        return userCommand;
    }
}
