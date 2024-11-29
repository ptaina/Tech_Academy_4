package com.maritai.livrosdigitais.controller;

import com.maritai.livrosdigitais.dto.CategoriaRequestDTO;
import com.maritai.livrosdigitais.model.Categoria;
import com.maritai.livrosdigitais.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> categorias = this.repository.findAll();
            return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
        Categoria categoria = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria não foi encontrada"));
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody CategoriaRequestDTO dto){
        if (dto.nome().isEmpty()){
            return ResponseEntity.status(400).build();
        }

        Categoria categoria = new Categoria();
        categoria.setNome(dto.nome());

        this.repository.save(categoria);
        return ResponseEntity.ok(categoria);
    }
}
