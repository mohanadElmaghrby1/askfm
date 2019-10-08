package com.mohannad.askfm.controllers;

import com.mohannad.askfm.model.Question;
import com.mohannad.askfm.model.User;
import com.mohannad.askfm.services.QuestionService;
import com.mohannad.askfm.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

/**
 * created by mohannad  on 27/09/19
 */
@Controller
public class QuestionController {

    private QuestionService questionService;
    private UserService userService;

    public QuestionController(QuestionService questionService, UserService userService) {
        this.questionService = questionService;
        this.userService = userService;
    }

    @RequestMapping({"/questions" , "/question.html"})
    public String getQuestions(Principal  principal , Model model){
        //if not logged in
        if (principal==null)
            return "redirect:/login";
        //get user asked questions
        User loggedInUser = userService.findByUserName(principal.getName());
        //get the not answered question
        List<Question> allAskedQuestions = questionService.findAllNotAnsweredQuestion(loggedInUser , null);
        model.addAttribute("questions" , allAskedQuestions);
        return "question";
    }

    @GetMapping({"/askQuestion/{username}"})
    public String getAskQuestionPage(@PathVariable String username , @RequestParam (value = "question")String question,
                                  Principal  principal){
        System.out.println(username);
        System.out.println(question);
        User receivedUser = userService.findByUserName(username);
        //get the logged in user
        User senderUser = userService.findByUserName(principal.getName());
        //create new Question
        Question quest = new Question();
        quest.setContent(question.trim());
        quest.setReceiverUser(receivedUser);
        quest.setSenderUser(senderUser);
        questionService.save(quest);
        return "redirect:/"+username;
    }

    @GetMapping("/question/delete/{id}")
    public String delete(@PathVariable String id , Model model){
        //get the question
        Question question = questionService.findById(new Long(id));
        //delete
        questionService.delete(question);
        return "redirect:/questions";
    }
}
