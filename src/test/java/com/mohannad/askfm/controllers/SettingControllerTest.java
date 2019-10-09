package com.mohannad.askfm.controllers;

import com.mohannad.askfm.convertors.UserToUserCommand;
import com.mohannad.askfm.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class SettingControllerTest {

    SettingController settingController;
    @Mock
    UserService userService;
    @Mock
    UserToUserCommand userToUserCommand;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        settingController = new SettingController(userService,userToUserCommand);
        mockMvc = MockMvcBuilders.standaloneSetup(settingController).build();
    }

    @Test
    void updateSettings() throws Exception {
        mockMvc.perform(post("/setting"))
                .andExpect(status().isOk())
                .andExpect(view().name("setting-profile"))
                .andExpect(model().attributeExists("usercommand"));

    }
}