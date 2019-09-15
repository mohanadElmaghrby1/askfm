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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
