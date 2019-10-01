package com.mohannad.askfm.services;

import com.mohannad.askfm.model.Answer;

/**
 * create by mohannad on 9/30/2019
 */
public interface AnswerService {
    Answer save(Answer answer);
    Answer findById(Long id);
}
