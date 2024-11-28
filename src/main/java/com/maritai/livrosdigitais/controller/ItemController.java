package com.maritai.livrosdigitais.controller;

import com.maritai.livrosdigitais.model.Item;
import com.maritai.livrosdigitais.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/livros")
public class ItemController {

    @Autowired
    private ItemRepository repository;

    @GetMapping
    public ResponseEntity<List<Item>> findAll(){
        List<Item> livros = this.repository.findAll();
        return ResponseEntity.ok(livros);

    }

    @GetMapping("/{id}")
    public Item findById(@PathVariable("id") Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));
    }


}
