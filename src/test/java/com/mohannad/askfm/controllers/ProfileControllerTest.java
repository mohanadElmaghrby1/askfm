package com.mohannad.askfm.controllers;

import com.mohannad.askfm.convertors.UserCommandToUser;
import com.mohannad.askfm.convertors.UserToUserCommand;
import com.mohannad.askfm.exceptions.NotFoundException;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.services.FollowerService;
import com.mohannad.askfm.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ProfileControllerTest {

    @Mock
    UserService userService;

    @Mock
    UserCommandToUser userCommandToUser;

    @Mock
    UserToUserCommand userToUserCommand;

    @Mock
    FollowerService followerService;

    MockMvc mockMvc;

    ProfileController profileController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        profileController = new ProfileController(userService,userToUserCommand,userCommandToUser,followerService);
        mockMvc = MockMvcBuilders.standaloneSetup(profileController).build();
    }

    @Test
    void getProfile() throws Exception {
        User user=new User();
        user.setUsername("Mohannad_Elmaghrby");
        when(userService.findByUserName(anyString())).thenReturn(user);
        mockMvc.perform(get("/Mohannad_Elmaghrby"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("follow"))
                .andExpect(model().attributeExists("user"))
                .andExpect(view().name("profile"));
    }

    @Test
    public void testGetProfileNotFound() throws Exception {

        when(userService.findByUserName(anyString())).thenThrow(NotFoundException.class);

        mockMvc.perform(get("/sadffas"))
                .andExpect(status().isNotFound()) ;

    }

}