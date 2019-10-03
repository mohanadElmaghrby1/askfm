package com.mohannad.askfm.repositories;

import com.mohannad.askfm.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * created by mohannad on 15/09/2019
 */
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Query(value = "SELECT * from Answer INNER JOIN Follower ON  ANSWER.USER_ID=FOLLOWER.USER_ID", nativeQuery = true)
    List<Answer> gitFollowedAnswers();
}
