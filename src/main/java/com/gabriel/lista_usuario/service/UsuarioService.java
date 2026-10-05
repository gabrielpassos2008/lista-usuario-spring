package com.gabriel.lista_usuario.service;

import com.gabriel.lista_usuario.model.Usuario;
import com.gabriel.lista_usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrar (Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public String excluir(Long id){
        usuarioRepository.deleteById(id);
        return "usuário deletado com sucesso";
    }

    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }
}
