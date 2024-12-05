package com.maritai.livrosdigitais.controller;

import com.maritai.livrosdigitais.dto.ItemPedidoRequestDTO;
import com.maritai.livrosdigitais.dto.PedidoRequestDTO;
import com.maritai.livrosdigitais.model.*;
import com.maritai.livrosdigitais.repository.ItemPedidoRepository;
import com.maritai.livrosdigitais.repository.ItemRepository;
import com.maritai.livrosdigitais.repository.PedidoRepository;
import com.maritai.livrosdigitais.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import java.util.List;


@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @GetMapping
    public ResponseEntity<List<Pedido>> findALL(){
        List<Pedido> pedidos = this.repository.findAll();
         return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public Pedido findById(@PathVariable("id") Integer id) throws IllegalAccessException {
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalAccessException("Pedido não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody PedidoRequestDTO dto) {
        if (dto.usuario_id() == 0 || dto.dt_pedido() == null || dto.total() == null) {
            return ResponseEntity.status(400).build();
        }

        Usuario usuario = this.usuarioRepository.findById(dto.usuario_id())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));

        LocalDate dt_pedido;
        try {
            dt_pedido = LocalDate.parse(dto.dt_pedido());
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }


        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setDt_pedido(dt_pedido);
        pedido.setTotal(dto.total());


        this.repository.save(pedido);


        for (ItemPedidoRequestDTO itemDTO : dto.itens()) {
            Item item = this.itemRepository.findById(itemDTO.item_id())
                    .orElseThrow(() -> new IllegalArgumentException("Item não foi encontrado"));

            ItemPedidoPK pk = new ItemPedidoPK();
            pk.setPedido_id(pedido.getId());
            pk.setItem_id(itemDTO.item_id());

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setId(pk);
            itemPedido.setQuantidade(itemDTO.quantidade());
            itemPedido.setValor(itemDTO.valor());
            itemPedido.setPedido(pedido);
            itemPedido.setItem(item);


            itemPedidoRepository.save(itemPedido);
        }

        return ResponseEntity.status(201).body(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable Integer id, @RequestBody PedidoRequestDTO dto) {
        Pedido pedido = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));


        if (dto.usuario_id() != 0) {
            Usuario usuario = this.usuarioRepository.findById(dto.usuario_id())
                    .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
            pedido.setUsuario(usuario);
        }

        if (dto.dt_pedido() != null) {
            try {
                pedido.setDt_pedido(LocalDate.parse(dto.dt_pedido()));
            } catch (Exception e) {
                return ResponseEntity.status(400).body(null);
            }
        }

        if (dto.total() != null) {
            pedido.setTotal(dto.total());
        }


        if (dto.itens() != null) {

            itemPedidoRepository.deleteByPedidoId(pedido.getId());


            for (ItemPedidoRequestDTO itemDTO : dto.itens()) {
                ItemPedidoPK pk = new ItemPedidoPK();
                pk.setPedido_id(pedido.getId());
                pk.setItem_id(itemDTO.item_id());

                ItemPedido itemPedido = new ItemPedido();
                itemPedido.setId(pk);
                itemPedido.setQuantidade(itemDTO.quantidade());
                itemPedido.setValor(itemDTO.valor());

                itemPedidoRepository.save(itemPedido);
            }
        }


        this.repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws IllegalAccessException {
        Pedido pedido = this.repository.findById(id)
                .orElseThrow(() -> new IllegalAccessException("Pedido não encontrado"));
        this.repository.delete(pedido);
        return ResponseEntity.noContent().build();
    }

}
