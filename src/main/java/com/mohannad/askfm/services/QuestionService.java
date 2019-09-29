package com.mohannad.askfm.services;

import com.mohannad.askfm.model.Question;
import com.mohannad.askfm.model.User;

import java.util.List;

/**
 * created by mohannad  on 27/09/19
 */
public interface QuestionService {
    Question save(Question question);
    List<Question> findAllAskedQuestion(User user);
}
