package com.mohannad.askfm.controllers;

import com.mohannad.askfm.commands.UserCommand;
import com.mohannad.askfm.commands.UserDetailsCommand;
import com.mohannad.askfm.convertors.UserCommandToUser;
import com.mohannad.askfm.convertors.UserToUserCommand;
import com.mohannad.askfm.exceptions.NotFoundException;
import com.mohannad.askfm.model.Follower;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.services.FollowerService;
import com.mohannad.askfm.services.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    private UserService userService;
    private FollowerService followerService;
    private UserToUserCommand userToUserCommand;
    private UserCommandToUser userCommandToUser;

    public ProfileController(UserService userService, UserToUserCommand userToUserCommand,
                             UserCommandToUser userCommandToUser , FollowerService followerService) {
        this.userService = userService;
        this.userToUserCommand = userToUserCommand;
        this.userCommandToUser = userCommandToUser;
        this.followerService=followerService;
    }

    @RequestMapping({"/{username}"})
    public String getProfile(@PathVariable String username , Model model){
        User user =  userService.findByUserName(username);
        String isLoggedUserFollowTheRequested= followerService.isLoggedInUserIsAFollower(user)?"yes":"no";
        model.addAttribute("follow" , isLoggedUserFollowTheRequested);
        model.addAttribute("user" , user);
        return "profile";
    }
}
