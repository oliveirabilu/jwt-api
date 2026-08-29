package com.carlos.jwtapi.controller;

import com.carlos.jwtapi.entity.Usuario;
import com.carlos.jwtapi.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public Usuario cadastrar(@RequestBody @Valid Usuario usuario){

        return usuarioService.cadastrarUsuario(usuario);
    }
    @GetMapping
    public List listar(){
        return usuarioService.listarUsuarios();
    }
}
