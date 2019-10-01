package com.mohannad.askfm.controllers;

import com.mohannad.askfm.model.Answer;
import com.mohannad.askfm.model.Question;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.services.AnswerService;
import com.mohannad.askfm.services.QuestionService;
import com.mohannad.askfm.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

/**
 * create by mohannad on 9/30/2019
 */
@Controller
public class AnswerController {

    private QuestionService questionService;
    private AnswerService answerService;
    private UserService userService;

    public AnswerController(QuestionService questionService, AnswerService answerService, UserService userService) {
        this.questionService = questionService;
        this.answerService = answerService;
        this.userService = userService;
    }

    @GetMapping("/answer/{questionid}")
    public String getAnswerPage(@PathVariable String questionid , Model model){
        //get the question
        Question question = questionService.findById(new Long(questionid));
        model.addAttribute("question" , question);
        model.addAttribute("answer" , new Answer());
        return "answerform";
    }

    @PostMapping("/answer/{questionid}")
    public String answer(@ModelAttribute("answer") Answer answer , @PathVariable String questionid , Principal principal){
        //get the question
        Question question = questionService.findById(new Long(questionid));
        if (answer ==null || answer.getContent().trim().length()<=0)
            return "redirect:/answer/"+questionid;

        //get logged in user (who answer the question )
        User user = userService.findByUserName(principal.getName());
        question.setAnswer(answer);
        answer.setQuestion(question);
        answer.setUser(user);
        answerService.save(answer);
        return "redirect:/";
    }
}
