package com.gabriel.lista_usuario.controller;

import com.gabriel.lista_usuario.model.Usuario;
import com.gabriel.lista_usuario.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> postCadastrar (@RequestBody @Valid Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastrar(usuario));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> getListar(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listar());
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<String> deleteUsuario(@RequestBody @Valid Long id){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.excluir(id));
    }
}
