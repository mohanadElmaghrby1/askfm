package com.mohannad.askfm.controllers;

import com.mohannad.askfm.commands.UserCommand;
import com.mohannad.askfm.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RegistrationControllerTest {

    RegistrationController registrationController;

    @Mock
    UserService userService;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        //setup mocks , telling mockito that we want RecipeService mock
        MockitoAnnotations.initMocks(this);
        registrationController=new RegistrationController(userService);
        mockMvc = MockMvcBuilders.standaloneSetup(registrationController)
                .build();

    }

    @Test
    void signUp() throws Exception {
        //test mock mvc
        mockMvc.perform(get("/register")).
                andExpect(status().isOk()).
                andExpect(view().name("sign-up"));
    }

    @Test
    void createNewUser() throws Exception {
        //create user command
        UserCommand userCommand = new UserCommand();
        userCommand.setId(1l);

        //when calling save it will return the above userCommand
        when(userService.saveUserCommand(any())).thenReturn(userCommand);

        mockMvc.perform(post("/sign-up")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("user", "Mohannad_Elmaghrby"))
                .andExpect(model().attributeExists("user"))
                .andExpect(view().name("redirect:/login"));
    }
}