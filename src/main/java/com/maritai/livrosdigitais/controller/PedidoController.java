package com.maritai.livrosdigitais.controller;

import com.maritai.livrosdigitais.dto.PedidoRequestDTO;
import com.maritai.livrosdigitais.model.Pedido;
import com.maritai.livrosdigitais.model.Usuario;
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
    private UsuarioRepository usuarioRepository;

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
                .orElseThrow(() ->
                        new IllegalArgumentException("Usuario não foi encontrado"));

        LocalDate dt_pedido;
        try {
            dt_pedido = LocalDate.parse(dto.dt_pedido()); // faz com que a data seja no formato string
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }

        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setDt_pedido(LocalDate.parse(dto.dt_pedido()));
        pedido.setTotal(dto.total());

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
