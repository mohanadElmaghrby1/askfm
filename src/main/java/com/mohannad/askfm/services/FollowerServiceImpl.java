package com.mohannad.askfm.services;

import com.mohannad.askfm.commands.UserDetailsCommand;
import com.mohannad.askfm.model.Follower;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.repositories.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by mohannad on 9/26/2019
 */
@Service
public class FollowerServiceImpl implements FollowerService {

    @Autowired
    private FollowerRepository followerRepository;

    @Override
    public Follower follow(User followed) {
        //make logged in user follow this user
        //get logged in user object
        UserDetailsCommand userDetailsCommand = (UserDetailsCommand)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // logged user(follower) want to follow the other user
        User follower = userDetailsCommand.getUser();
        Follower followerRelation = findByUserAndFollower(followed, follower);
        if(followerRelation!=null){
            //unFollow
            delete(followerRelation);
        }else {
           //follow
            followerRelation=new Follower();
            followerRelation.setFollower(follower);
            followerRelation.setUser(followed);
            followerRepository.save(followerRelation);
        }
        return followerRelation;
    }

    @Override
    public Follower findByUserAndFollower(User user, User follower) {
        Follower followerR1= followerRepository.findByUserAndFollower(user , follower);
        return followerR1;
    }

    @Override
    public List<Follower> getFollowing(User follower) {
        return followerRepository.findByFollower(follower);
    }

    @Override
    public boolean isLoggedInUserIsAFollower(User user) {
        //get logged in authenticated user
        UserDetailsCommand userDetailsCommand = (UserDetailsCommand)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //get requested user profile
        User loggedInUser = userDetailsCommand.getUser();
        Follower followerRelation = findByUserAndFollower(user, loggedInUser);
        return followerRelation==null?false:true;
    }


    @Override
    public Follower delete(Follower follower) {
        followerRepository.delete(follower);
        return follower;
    }

}
