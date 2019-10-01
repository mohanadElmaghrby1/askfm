package com.mohannad.askfm.services;

import com.mohannad.askfm.exceptions.NotFoundException;
import com.mohannad.askfm.model.Answer;
import com.mohannad.askfm.model.Question;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Question delete(Question question) {
        questionRepository.delete(question);
        return question;
    }

    @Override
    public Question findById(long id) {
        Optional<Question> questionOptional = questionRepository.findById(id);
        if (!questionOptional.isPresent()) {
            throw new NotFoundException("Question Not Found. for id value:"+id);
        }
        return questionOptional.get() ;
    }

    @Override
    public List<Question> findAllAskedQuestion(User user) {
        return questionRepository.findByReceiverUser(user);
    }

    @Override
    public List<Question> findAllNotAnsweredQuestion(User user, Answer answer) {
        return questionRepository.findByReceiverUserAndAnswer(user ,answer);
    }


}
