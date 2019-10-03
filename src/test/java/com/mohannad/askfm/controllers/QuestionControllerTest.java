package com.mohannad.askfm.controllers;

import com.mohannad.askfm.model.User;
import com.mohannad.askfm.services.QuestionService;
import com.mohannad.askfm.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.security.Principal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class QuestionControllerTest {

    @Mock
    QuestionService questionService;
    @Mock
    UserService userService;

    @Mock
    Principal principal;

    QuestionController questionController;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        questionController=new QuestionController(questionService,userService);
        mockMvc = MockMvcBuilders.standaloneSetup(questionController).build();

    }

    @Test
    void getQuestions() throws Exception {
        User user = new User();
        user.setUsername("mohannad");
        user.setId(1l);
        when(userService.findByUserName(any())).thenReturn(user);
        when(questionService.findAllAskedQuestion(any())).thenReturn(null);
        mockMvc.perform(get("/questions"))
                .andExpect(status().is3xxRedirection())
                .andExpect(model().attributeExists("questions"))
                .andExpect(view().name("question"));
    }

    @Test
    void getAskQuestionPage() {
    }
}