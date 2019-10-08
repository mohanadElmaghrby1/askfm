package com.mohannad.askfm.repositories;

import com.mohannad.askfm.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * created by mohannad on 15/09/2019
 */
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Query(value = "SELECT * from Answer INNER JOIN Follower ON Follower.FOLLOWER_ID=:logged_user_id and ANSWER.USER_ID=FOLLOWER.USER_ID ", nativeQuery = true)
    List<Answer> gitFollowedAnswers(@Param("logged_user_id") String logged_user_id);
}
