package com.mohannad.askfm.controllers;

import com.mohannad.askfm.commands.UserCommand;
import com.mohannad.askfm.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/sign-up")
    public String signUp(Model model){
        model.addAttribute("user" , new UserCommand());
        return "sign-up";
    }

    @PostMapping("/user")
    public String createNewUser(@ModelAttribute UserCommand userCommand){
        System.out.println(userCommand);
        userService.saveUserCommand(userCommand);
        return "redirect:/login";
    }
}
