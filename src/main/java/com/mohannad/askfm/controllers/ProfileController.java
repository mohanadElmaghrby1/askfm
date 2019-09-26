package com.mohannad.askfm.controllers;

import com.mohannad.askfm.commands.UserCommand;
import com.mohannad.askfm.convertors.UserCommandToUser;
import com.mohannad.askfm.convertors.UserToUserCommand;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {

    private UserService userService;
    private UserToUserCommand userToUserCommand;
    private UserCommandToUser userCommandToUser;

    public ProfileController(UserService userService, UserToUserCommand userToUserCommand, UserCommandToUser userCommandToUser) {
        this.userService = userService;
        this.userToUserCommand = userToUserCommand;
        this.userCommandToUser = userCommandToUser;
    }

    @RequestMapping({"/{username}"})
    public String deleteRecipe(@PathVariable String username , Model model){
        //check if user is correct
        User user =  userService.findByUserName(username);
        UserCommand userCommand = userToUserCommand.convert(user);
        model.addAttribute("user" , userCommand);
        return "profile";
    }

    @GetMapping("follow/{id}")
    public String follow(@PathVariable String id, Model model){
        //make logged in user follow this user
        System.out.println(id);
        return "profile";
    }

}
