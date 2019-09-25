package com.mohannad.askfm.controllers;

import com.mohannad.askfm.commands.UserCommand;
import com.mohannad.askfm.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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

    /**
     * object marked up with @Valid to gather the attributes filled out in the form you’re about to build.
     * @param userCommand
     * @param bindingResult
     * @return
     */
    @PostMapping("/sign-up")
    public String createNewUser(@Valid @ModelAttribute("user") UserCommand userCommand , BindingResult bindingResult){
        //check if there are  errors when user logged in
        if (bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(objectError -> {
                System.out.println(objectError.toString());
            });
            //return sign-up page again
            return "sign-up";
        }
        System.out.println(userCommand);
        userService.saveUserCommand(userCommand);
        return "redirect:/login";
    }
}
