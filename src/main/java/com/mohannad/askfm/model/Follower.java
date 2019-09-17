package com.mohannad.askfm.model;

import javax.persistence.*;

/**
 * created by mohannad  on 13/09/19
 */
@Entity
public class Follower extends BaseEntity {

    //every follower follow one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private User follower;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }
}
