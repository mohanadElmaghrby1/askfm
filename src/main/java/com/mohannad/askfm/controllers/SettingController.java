package com.mohannad.askfm.controllers;

import com.mohannad.askfm.commands.UserCommand;
import com.mohannad.askfm.convertors.UserCommandToUser;
import com.mohannad.askfm.convertors.UserToUserCommand;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

/**
 * create by mohannad on 10/9/2019
 */
@Controller
public class SettingController {

    private UserService userService;
    private UserToUserCommand userToUserCommand;
    private UserCommandToUser userCommandToUser;

    public SettingController(UserService userService, UserToUserCommand userToUserCommand
            , UserCommandToUser userCommandToUser) {
        this.userService = userService;
        this.userToUserCommand = userToUserCommand;
        this.userCommandToUser = userCommandToUser;
    }

    @GetMapping({"/setting-profile.html", "/setting"})
    public String loadSettings(Model model, Principal principal) {
        //load logged in user data
        User loggedInUser = userService.findByUserName(principal.getName());
        UserCommand usrCommand = userToUserCommand.convert(loggedInUser);
        model.addAttribute("user", usrCommand);
        return "setting-profile";
    }


    @PostMapping("/settings/update")
    public String updateSettings(@Valid @ModelAttribute("user") UserCommand userCommand
            , BindingResult bindingResult) {
        userService.save(userCommandToUser.convert(userCommand));
        return "redirect:/setting";
    }
}
