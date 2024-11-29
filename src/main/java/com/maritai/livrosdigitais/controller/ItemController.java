package com.maritai.livrosdigitais.controller;

import com.maritai.livrosdigitais.dto.CategoriaRequestDTO;
import com.maritai.livrosdigitais.dto.ItemRequestDTO;
import com.maritai.livrosdigitais.model.Categoria;
import com.maritai.livrosdigitais.model.Item;
import com.maritai.livrosdigitais.repository.CategoriaRepository;
import com.maritai.livrosdigitais.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/livros")
public class ItemController {

    @Autowired
    private ItemRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

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

    @PostMapping
    public ResponseEntity<Item> save(@RequestBody ItemRequestDTO dto){
        if (dto.titulo().isEmpty() || dto.valor() == null || dto.qtd_estoque() == 0 || dto.categoria_id() == 0 ||dto.escritor().isEmpty()){
            return ResponseEntity.status(400).build();
        }

        Categoria categoria = this.categoriaRepository.findById(dto.categoria_id())
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria não foi encontrada"));

        Item item = new Item();
        item.setTitulo(dto.titulo());
        item.setValor(dto.valor());
        item.setQtd_estoque(dto.qtd_estoque());
        item.setCategoria(categoria);
        item.setEscritor(dto.escritor());

        this.repository.save(item);
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Item item = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item não encontrado"));
        this.repository.delete(item);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Integer id, @RequestBody ItemRequestDTO dto) {

        if (dto.titulo().isEmpty() || dto.valor() == null || dto.qtd_estoque() == 0 ||
                dto.categoria_id() == 0 || dto.escritor().isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        Item item = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item não encontrado"));

        Categoria categoria = this.categoriaRepository.findById(dto.categoria_id())
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

        item.setTitulo(dto.titulo());
        item.setValor(dto.valor());
        item.setQtd_estoque(dto.qtd_estoque());
        item.setCategoria(categoria);
        item.setEscritor(dto.escritor());

        this.repository.save(item);
        return ResponseEntity.ok(item);
    }

}
