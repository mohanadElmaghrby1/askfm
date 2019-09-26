package com.mohannad.askfm.services;

import com.mohannad.askfm.model.Follower;
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
    public Follower follow(Long id) {
        return null;
    }
}
