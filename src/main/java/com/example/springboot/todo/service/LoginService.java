package com.example.springboot.todo.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validateUser(String userId, String password){
        return userId.equals("Ravi") && password.equals("abc");
    }
}
