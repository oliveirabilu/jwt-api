package com.carlos.jwtapi.controller;

import com.carlos.jwtapi.dto.LoginRequest;
import com.carlos.jwtapi.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {

        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){

        return authService.login(request);
    }
}


