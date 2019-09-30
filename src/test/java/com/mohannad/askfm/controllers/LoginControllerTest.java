package com.mohannad.askfm.controllers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class LoginControllerTest {

    LoginController loginController;


    @BeforeEach
    public void setUp() throws Exception {
        loginController=new LoginController();
    }


    @Test
    public void mockMVC() throws Exception {
        //create mock mvc
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();

        //test mock mvc
        mockMvc.perform(get("/login")).
                andExpect(status().isOk()).
                andExpect(view().name("sign-in"));
    }

}