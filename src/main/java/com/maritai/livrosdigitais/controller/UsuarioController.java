package com.maritai.livrosdigitais.controller;

import com.maritai.livrosdigitais.dto.UsuarioRequestDTO;
import com.maritai.livrosdigitais.model.Usuario;
import com.maritai.livrosdigitais.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    // aqui acha todos os usuários
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> usuarios = this.repository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    // acha um usuário pelo ID
    @GetMapping("/{id}")
    public Usuario findById(@PathVariable("id") Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    // cria um novo usuário
    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody UsuarioRequestDTO dto) {
        if (dto.nome().isEmpty() || dto.email().isEmpty() || dto.senha().isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());

        this.repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    // Deleta um usuário pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Usuario usuario = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        this.repository.delete(usuario);
        return ResponseEntity.noContent().build();
    }

    //  atualiza um usuário
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody UsuarioRequestDTO dto) {
        if (dto.nome().isEmpty() || dto.email().isEmpty() || dto.senha().isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        Usuario usuario = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());

        this.repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }
}
