package com.mohannad.askfm.services;

import com.mohannad.askfm.commands.UserCommand;
import com.mohannad.askfm.convertors.UserCommandToUser;
import com.mohannad.askfm.convertors.UserToUserCommand;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@SpringBootTest
class UserServiceImplTest {

    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Mock
    UserToUserCommand userToUserCommand;

    @Mock
    UserCommandToUser userCommandToUser;

    @Mock
    PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setUp() {
        //setup mocks , telling mockito that we want to use it here
        MockitoAnnotations.initMocks(this);

        //create a RecipeServiceImpl obj using mock
        userService = new UserServiceImpl(userRepository , userToUserCommand , userCommandToUser , passwordEncoder);
    }

    @Test
    void findByID() {
        //create user with initial  data
        User user = new User();
        user.setId(1l);
        //create optional object from user
        Optional<User> userOptional = Optional.of(user);
        //when calling userRepository.findById with any long then return userOptional ( it's used byuserService )
        when(userRepository.findById(anyLong())).thenReturn(userOptional);

        //it should return the saved user
        User savedUser = userService.findByID(1L);

        //assert that the returned value not equal null
        assertNotNull(savedUser,"Null user returned");
        //verify that findbyid is called once
        verify(userRepository, times(1)).findById(anyLong());

        //verify that findall never called
        verify(userRepository, never()).findAll();

    }

    @Test
    void findByEmail() {
        //create user with initial  data
        User user = new User();
        user.setEmail("mohanad20201996a@gmail.com");
        //when calling userRepository.findById with any long then return userOptional ( it's used byuserService )
        when(userRepository.findByEmail(anyString())).thenReturn(user);

        //it should return the saved user
        User savedUser = userService.findByEmail("mohanad20201996a@gmail.com");

        //assert that the returned value not equal null
        assertNotNull(savedUser,"Null user returned");
        //verify that findByEmail is called once
        verify(userRepository, times(1)).findByEmail(anyString());

        //verify that findAll never called
        verify(userRepository, never()).findAll();
    }


    @Test
    void findByUserName() {
        //create user with initial  data
        User user = new User();
        user.setEmail("mohanad2021996");
        //when calling userRepository.findById with any long then return userOptional ( it's used byuserService )
        when(userRepository.findByUsername(anyString())).thenReturn(user);

        //it should return the saved user
        User savedUser = userService.findByUserName("mohanad20201996a@gmail.com");

        //assert that the returned value not equal null
        assertNotNull(savedUser,"Null user returned");
        //verify that findByUsername is called once
        verify(userRepository, times(1)).findByUsername(anyString());

        //verify that findAll never called
        verify(userRepository, never()).findAll();
    }
}