package com.mohannad.askfm.repositories;

import com.mohannad.askfm.model.Follower;
import com.mohannad.askfm.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * created by mohannad on 15/09/2019
 */
public interface FollowerRepository extends CrudRepository<Follower , Long> {
    Follower findByUserAndFollower(User user , User follower);
}
