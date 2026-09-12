package com.carlos.jwtapi.service;

import com.carlos.jwtapi.dto.LoginRequest;
import com.carlos.jwtapi.entity.Usuario;
import com.carlos.jwtapi.repository.UsuarioRepository;
import com.carlos.jwtapi.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private  final JwtService jwtService;

    public AuthService(UsuarioRepository usuarioRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }
    public String login(LoginRequest request){
        Optional<Usuario> usuario = usuarioRepository.findByLogin(request.login());
        Usuario usuarioEncontrado = usuario.orElseThrow();
        boolean senhaValida = passwordEncoder.matches(request.senha(), usuarioEncontrado.getSenha());
        if(!senhaValida){
            throw new RuntimeException("Senha inválida");
        }
        return jwtService.gerarToken(usuarioEncontrado.getLogin(),
                usuarioEncontrado.getRole());
    }
}
