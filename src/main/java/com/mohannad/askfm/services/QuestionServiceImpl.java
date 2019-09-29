package com.mohannad.askfm.services;

import com.mohannad.askfm.model.Question;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by mohannad  on 27/09/19
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> findAllAskedQuestion(User user) {
        return questionRepository.findByReceiverUser(user);
    }


}
