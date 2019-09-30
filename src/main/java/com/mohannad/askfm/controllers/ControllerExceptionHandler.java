package com.mohannad.askfm.controllers;

import com.mohannad.askfm.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerExceptionHandler {

    /**
     * ExceptionHandler method for NotFoundException class HttpStatus.NOT_FOUND 404
     * @return specific view for NOt_FOUND exception
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    public ModelAndView handleNotFound(Exception exception){
        System.out.println("handel not found exception");
        System.out.println(exception.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("404error");
        modelAndView.addObject("exception" , exception);
        return modelAndView;
    }

    /**
     * ExceptionHandler method for NotFoundException class HttpStatus.BadREquest 404
     * @return specific view for NumberFormat exception
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({NumberFormatException.class})
    public ModelAndView handleNumberFormat(Exception exception){
        System.out.println("handel NumberFormatException exception");
        System.out.println(exception.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("400error");
        modelAndView.addObject("exception" , exception);
        return modelAndView;
    }
}
