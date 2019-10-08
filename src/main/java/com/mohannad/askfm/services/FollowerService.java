package com.mohannad.askfm.services;

import com.mohannad.askfm.model.Follower;
import com.mohannad.askfm.model.User;

import java.util.List;

/**
 * create by mohannad on 9/26/2019
 */
public interface FollowerService  {
    Follower follow(User user ) ;
    Follower findByUserAndFollower(User user , User follower);
    List<Follower> getFollowing(User follower);
    boolean isLoggedInUserIsAFollower(User user);
    Follower delete(Follower follower);
}
