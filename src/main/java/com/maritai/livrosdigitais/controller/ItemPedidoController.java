package com.maritai.livrosdigitais.controller;

import com.maritai.livrosdigitais.dto.ItemPedidoRequestDTO;
import com.maritai.livrosdigitais.model.ItemPedido;
import com.maritai.livrosdigitais.model.ItemPedidoPK;
import com.maritai.livrosdigitais.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoRepository repository;


    @GetMapping
    public ResponseEntity<List<ItemPedido>> findAll() {
        List<ItemPedido> itensPedido = this.repository.findAll();
        return ResponseEntity.ok(itensPedido);
    }


    @GetMapping("/{pedido_id}/{item_id}")
    public ResponseEntity<ItemPedido> findById(
            @PathVariable Integer pedido_id,
            @PathVariable Integer item_id) {
        ItemPedidoPK pk = new ItemPedidoPK();
        pk.setPedido_id(pedido_id);
        pk.setItem_id(item_id);

        return this.repository.findById(pk)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    @PutMapping("/{pedido_id}/{item_id}")
    public ResponseEntity<ItemPedido> update(
            @PathVariable Integer pedido_id,
            @PathVariable Integer item_id,
            @RequestBody ItemPedidoRequestDTO dto) {
        if (dto.quantidade() == 0 || dto.valor() == null) {
            return ResponseEntity.status(400).build();
        }

        ItemPedidoPK pk = new ItemPedidoPK();
        pk.setPedido_id(pedido_id);
        pk.setItem_id(item_id);

        ItemPedido itemPedido = this.repository.findById(pk)
                .orElseThrow(() -> new IllegalArgumentException("Item pedido não encontrado"));

        itemPedido.setQuantidade(dto.quantidade());
        itemPedido.setValor(dto.valor());

        this.repository.save(itemPedido);
        return ResponseEntity.ok(itemPedido);
    }


    @DeleteMapping("/{pedido_id}/{item_id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer pedido_id,
            @PathVariable Integer item_id) {
        ItemPedidoPK pk = new ItemPedidoPK();
        pk.setPedido_id(pedido_id);
        pk.setItem_id(item_id);

        ItemPedido itemPedido = this.repository.findById(pk)
                .orElseThrow(() -> new IllegalArgumentException("Item pedido não encontrado"));

        this.repository.delete(itemPedido);
        return ResponseEntity.noContent().build();
    }
}
