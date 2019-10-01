package com.mohannad.askfm.repositories;

import com.mohannad.askfm.model.Answer;
import com.mohannad.askfm.model.Question;
import com.mohannad.askfm.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * created by mohannad on 15/09/2019
 */
public interface QuestionRepository  extends CrudRepository<Question, Long> {
    List<Question> findByReceiverUser(User user);
    List<Question> findByReceiverUserAndAnswer(User user , Answer answer);
}
