package com.mohannad.askfm.services;

import com.mohannad.askfm.commands.UserCommand;
import com.mohannad.askfm.convertors.UserCommandToUser;
import com.mohannad.askfm.convertors.UserToUserCommand;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceImplIT {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserToUserCommand userToUserCommand;

    @Autowired
    UserCommandToUser userCommandToUser;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Transactional
    @Test
    void saveUserCommand() {
        //given
        Iterable<User> userIterable = userRepository.findAll();
        User user = userIterable.iterator().next();

        //when
        user.setUsername("ali");
        UserCommand userCommand = userService.saveUserCommand(userToUserCommand.convert(user));

        //then
        assertEquals(userCommand.getUsername() , "ali");
        assertEquals(userCommand.getId() , user.getId());
        assertEquals(userCommand.getEmail() , user.getEmail());

    }
}