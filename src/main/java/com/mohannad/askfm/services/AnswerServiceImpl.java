package com.mohannad.askfm.services;

import com.mohannad.askfm.exceptions.NotFoundException;
import com.mohannad.askfm.model.Answer;
import com.mohannad.askfm.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * create by mohannad on 9/30/2019
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    private AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer findById(Long id) {
        Optional<Answer> answerOptional = answerRepository.findById(id);
        if (!answerOptional.isPresent()) {
            throw new NotFoundException("Answer Not Found For answer id "+id);
        }
        return answerOptional.get();
    }
}
