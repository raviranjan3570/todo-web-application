package com.example.springboot.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/*
By adding an error keyword here, we're saying that this is an error controller.
@ExceptionHandler handles a particular type pf exception.
*/
@Controller("error")
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception exception){
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", exception.getStackTrace());
        mv.addObject("url", request.getRequestURL());
        mv.setViewName("error");
        return mv;
    }
}
