package com.mohannad.askfm.services;

import com.mohannad.askfm.model.Answer;

import java.util.List;

/**
 * create by mohannad on 9/30/2019
 */
public interface AnswerService {
    Answer save(Answer answer);
    Answer findById(Long id);
    List<Answer> findAll();
    List<Answer> findAllFollowedUsersAnswers(String logged_user_id);
}
