package com.mohannad.askfm.controllers;

import com.mohannad.askfm.commands.UserCommand;
import com.mohannad.askfm.convertors.UserCommandToUser;
import com.mohannad.askfm.convertors.UserToUserCommand;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class SettingControllerTest {

    SettingController settingController;
    @Mock
    UserService userService;
    @Mock
    UserToUserCommand userToUserCommand;
    @Mock
    UserCommandToUser userCommandToUser;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        settingController = new SettingController(userService,userToUserCommand , userCommandToUser);
        mockMvc = MockMvcBuilders.standaloneSetup(settingController).build();
    }

    @Test
    void loadSettings() throws Exception {
        User user = new User();
        UserCommand userCommand = new UserCommand();
        when(userService.findByUserName(any())).thenReturn(user);
        when(userToUserCommand.convert(any())).thenReturn(userCommand);
        mockMvc.perform(get("/setting"))
                .andExpect(status().isOk())
                .andExpect(view().name("setting-profile"))
                .andExpect(model().attributeExists("user"));

    }
}