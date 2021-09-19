package com.example.springboot.todo.controller;

import com.example.springboot.todo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showWelcomePage(@RequestParam String name, @RequestParam String password,
                                  ModelMap model){

        boolean isValidUser = service.validateUser(name, password);
        if(!isValidUser){
            model.put("errorMessage", "Invalid credential");
            return "login";
        }
        model.put("password", password);
        model.put("name", name);
        return "welcome";
    }

}
