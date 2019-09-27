package com.mohannad.askfm.controllers;

import com.mohannad.askfm.commands.UserCommand;
import com.mohannad.askfm.commands.UserDetailsCommand;
import com.mohannad.askfm.convertors.UserCommandToUser;
import com.mohannad.askfm.convertors.UserToUserCommand;
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
    private UserToUserCommand userToUserCommand;
    private FollowerService followerService;
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
        //check if user is correct
        User user =  userService.findByUserName(username);
        UserCommand userCommand = userToUserCommand.convert(user);
        //add attribute for if the logged user follow the requested user profile
        //make logged in user follow this user
        UserDetailsCommand userDetailsCommand = (UserDetailsCommand)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //get logged in user object
        // logged user want to follow the other user
        User follower = userDetailsCommand.getUser();
        Follower followerRelation = followerService.findByUserAndFollower(user, follower);
        String isLoggedUserFollowtheRequested = "no";
        if (followerRelation!=null)
            isLoggedUserFollowtheRequested="yes";
        model.addAttribute("follow" , isLoggedUserFollowtheRequested);
        System.out.println("follow = "+isLoggedUserFollowtheRequested);
        model.addAttribute("user" , userCommand);
        return "profile";
    }

    @GetMapping("follow/{id}")
    public String followAndUnFollow(@PathVariable String id, Principal principal , Model model){
        //make logged in user follow this user
        UserDetailsCommand userDetailsCommand = (UserDetailsCommand)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //get logged in user object
        // logged user want to follow the other user
        User follower = userDetailsCommand.getUser();

        //get user to follow
        User followed = userService.findByID(new Long(id));

        //make currentUser follow the followedUser
        //check if followed the unfoloow
        Follower followerRelation = followerService.findByUserAndFollower(followed, follower);
        if(followerRelation!=null){
            //unFollow
            followerService.delete(followerRelation);
        }else {
            //follow
            followerService.follow(followed,follower);
        }
        System.out.println(id);
        System.out.println(principal.toString());

        //redirect to the same user profile
        return "redirect:/"+followed.getUsername();
    }

}
