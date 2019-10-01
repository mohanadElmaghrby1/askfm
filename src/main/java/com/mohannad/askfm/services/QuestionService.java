package com.mohannad.askfm.services;

import com.mohannad.askfm.model.Answer;
import com.mohannad.askfm.model.Question;
import com.mohannad.askfm.model.User;

import java.util.List;

/**
 * created by mohannad  on 27/09/19
 */
public interface QuestionService {
    Question save(Question question);
    Question delete(Question question);
    Question findById(long id);
    List<Question> findAllAskedQuestion(User user);
    List<Question> findAllNotAnsweredQuestion(User user , Answer answer);
}
