package com.carlos.jwtapi.service;



import com.carlos.jwtapi.entity.Usuario;
import com.carlos.jwtapi.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService (UsuarioRepository usuarioRepository) {
                this.usuarioRepository = usuarioRepository;
    }
    @Transactional
    public Usuario cadastrarUsuario (Usuario usuario){

        return usuarioRepository.save(usuario);
    }

}
