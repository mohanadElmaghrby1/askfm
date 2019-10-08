package com.mohannad.askfm.services;

import com.mohannad.askfm.model.Follower;
import com.mohannad.askfm.model.User;

/**
 * create by mohannad on 9/26/2019
 */
public interface FollowerService  {
    Follower follow(User user ) ;
    Follower findByUserAndFollower(User user , User follower);
    Follower findByFollower(User follower);
    boolean isLoggedInUserIsAFollower(User user);
    Follower delete(Follower follower);
}
