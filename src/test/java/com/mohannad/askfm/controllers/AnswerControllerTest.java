package com.mohannad.askfm.controllers;

import com.mohannad.askfm.model.Answer;
import com.mohannad.askfm.model.Question;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.services.AnswerService;
import com.mohannad.askfm.services.QuestionService;
import com.mohannad.askfm.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ModelAttribute;
import sun.nio.cs.US_ASCII;

import java.security.Principal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AnswerControllerTest {
    @Mock
    QuestionService questionService;
    @Mock
    AnswerService answerService;
    @Mock
    UserService userService;

    @Mock
    private Principal principal;

    AnswerController answerController;

    MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        //use mock here
        MockitoAnnotations.initMocks(this);
        answerController = new AnswerController(questionService,answerService,userService);
        mockMvc = MockMvcBuilders.standaloneSetup(answerController).build();
    }

    @Test
    void getAnswerPage() throws Exception {
        Question question = new Question();
        question.setId(1l);
        question.setContent("how are you?");

        when(questionService.findById(1)).thenReturn(question);

        mockMvc.perform(get("/answer/1"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("question"))
                .andExpect(model().attributeExists("answer"))
                .andExpect(view().name("answerform"));

        //verify that userService findByID is called one time
        verify(questionService, times(1)).findById(1);

    }

    @Test
    void answer() throws Exception {
        Question question = new Question();
        question.setId(1l);
        question.setContent("how are you?");
        when(questionService.findById(1)).thenReturn(question);
        User user=new User();
        when(userService.findByUserName("nono")).thenReturn(user);


        Answer answer= new Answer();
        answer.setContent("good");

        mockMvc.perform(post("/answer/1").param("answer", "answer")
                .param("content" , "content"))
                .andExpect(status().isOk())
                .andExpect(view().name("redirect:/"));

    }
}