package com.mohannad.askfm.controllers;

import com.mohannad.askfm.services.AnswerService;
import com.mohannad.askfm.services.IndexService;
import com.mohannad.askfm.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class IndexControllerTest {

    MockMvc mockMvc;
    IndexController indexController;

    @Mock
    AnswerService answerService;

    @Mock
    UserService userService;

    @BeforeEach
    void setUp() {
        indexController = new IndexController(answerService,userService);
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    void getHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

    }
}