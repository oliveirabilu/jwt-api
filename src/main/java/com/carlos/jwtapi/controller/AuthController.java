package com.carlos.jwtapi.controller;

import com.carlos.jwtapi.dto.LoginRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @PostMapping("/login")
    public void login(@RequestBody LoginRequest request){

    }
}
