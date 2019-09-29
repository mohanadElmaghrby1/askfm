package com.mohannad.askfm.services;

import com.mohannad.askfm.model.Follower;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.repositories.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create by mohannad on 9/26/2019
 */
@Service
public class FollowerServiceImpl implements FollowerService {

    @Autowired
    private FollowerRepository followerRepository;

    @Override
    public Follower follow(User user , User follower) {
        Follower followerRelation = new Follower();
        followerRelation.setFollower(follower);
        followerRelation.setUser(user);
        return followerRepository.save(followerRelation);

    }

    @Override
    public Follower findByUserAndFollower(User user, User follower) {
        Follower followerR1= followerRepository.findByUserAndFollower(user , follower);
//        Follower byUser_idAndFollower_id = followerRepository.findByUser_idAndFollower_id(user.getId(), follower.getId());
        return followerR1;
    }

    @Override
    public Follower delete(Follower follower) {
        followerRepository.delete(follower);
        return follower;
    }

}
