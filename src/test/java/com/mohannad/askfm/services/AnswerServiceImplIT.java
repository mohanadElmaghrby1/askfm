package com.mohannad.askfm.services;

import com.mohannad.askfm.model.Answer;
import com.mohannad.askfm.repositories.AnswerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AnswerServiceImplIT {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    AnswerService answerService;

    @Test
    void setUp() {
    }

    @Test
    void save() {
        //save new answer
        Answer answer=new Answer();
        answer.setContent("ans1");
        answer.setId(1l);
        answerService.save(answer);
        //get the answer then check
        Answer savedAnswer = answerService.findById(1l);
        assertEquals(new Long(1l), savedAnswer.getId());
    }

    @Test
    void findById() {
        //save new answer
        Answer answer=new Answer();
        answer.setContent("ans1");
        answer.setId(1l);
        answerService.save(answer);
        //get the answer then check
        Answer savedAnswer = answerService.findById(1l);
        assertEquals(new Long(1l), savedAnswer.getId());
    }
}