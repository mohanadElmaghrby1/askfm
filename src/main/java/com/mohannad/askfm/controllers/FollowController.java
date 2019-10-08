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
import java.util.List;

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

    @GetMapping("follow/{username}")
    public String followAndUnFollow(@PathVariable String username){
        //get user to follow
        User followed = userService.findByUserName(username);
        followerService.follow(followed);
        //redirect to the same user profile
        return "redirect:/"+followed.getUsername();
    }

    @GetMapping({"/friends.html", "/friends"})
    public String getFriends(Model model, Principal principal) {
        //get logged in user
        String loggedUsername = principal.getName();
        User loggedInUser = userService.findByUserName(loggedUsername);

        List<Follower> following = followerService.getFollowing(loggedInUser);
        model.addAttribute("friends" , following);
        return "friends";
    }
}
