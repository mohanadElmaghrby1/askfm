package com.mohannad.askfm.controllers;

import com.mohannad.askfm.commands.UserDetailsCommand;
import com.mohannad.askfm.model.Follower;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.services.FollowerService;
import com.mohannad.askfm.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

/**
 * created by mohannad  on 28/09/19
 */
@Controller
public class FollowController {

    private UserService userService;
    private FollowerService followerService;

    public FollowController(UserService userService, FollowerService followerService) {
        this.userService = userService;
        this.followerService = followerService;
    }

    @GetMapping("follow/{id}")
    public String followAndUnFollow(@PathVariable String id, Principal principal){
        //get user to follow
        User followed = userService.findByID(new Long(id));
        followerService.follow(followed);
        //redirect to the same user profile
        return "redirect:/"+followed.getUsername();
    }
}
