package com.maritai.livrosdigitais.controller;

import com.maritai.livrosdigitais.dto.UsuariosRequestDTO;
import com.maritai.livrosdigitais.model.Usuarios;
import com.maritai.livrosdigitais.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosRepository repository;

    // aqui acha todos os usuários
    @GetMapping
    public ResponseEntity<List<Usuarios>> findAll() {
        List<Usuarios> usuarios = this.repository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    // acha um usuário pelo ID
    @GetMapping("/{id}")
    public Usuarios findById(@PathVariable("id") Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    // cria um novo usuário
    @PostMapping
    public ResponseEntity<Usuarios> save(@RequestBody UsuariosRequestDTO dto) {
        if (dto.nome().isEmpty() || dto.email().isEmpty() || dto.senha().isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        Usuarios usuario = new Usuarios();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());

        this.repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    // Deleta um usuário pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Usuarios usuario = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        this.repository.delete(usuario);
        return ResponseEntity.noContent().build();
    }

    //  atualiza um usuário
    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> update(@PathVariable Integer id, @RequestBody UsuariosRequestDTO dto) {
        if (dto.nome().isEmpty() || dto.email().isEmpty() || dto.senha().isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        Usuarios usuario = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());

        this.repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }
}
