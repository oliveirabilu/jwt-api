package com.carlos.jwtapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @GetMapping("/admin/teste")
    public String testeAdmin(){
        return "Acesso Administrador autorizado pelo Security!";
    }
}
