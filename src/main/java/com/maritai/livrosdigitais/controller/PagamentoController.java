package com.maritai.livrosdigitais.controller;

import com.maritai.livrosdigitais.dto.PagamentoRequestDTO;
import com.maritai.livrosdigitais.model.Item;
import com.maritai.livrosdigitais.model.Pagamento;
import com.maritai.livrosdigitais.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoRepository repository;

    @GetMapping
    public ResponseEntity<List<Pagamento>> findAll() {
        List<Pagamento> pagamentos = this.repository.findAll();
        return ResponseEntity.ok(pagamentos);
    }

    @GetMapping("/{id}")
    public Pagamento findById(@PathVariable("id") Integer id) throws IllegalAccessException {
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalAccessException("Pagamento não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Pagamento> save(@RequestBody PagamentoRequestDTO dto) {
        if (dto.pedido_id() == 0  || dto.formaPgto().isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        Pagamento pagamento = new Pagamento();
        pagamento.setPedido_id(dto.pedido_id());
        pagamento.setFormaPgto(dto.formaPgto());


        Pagamento pagamentos = repository.save(pagamento);
        return ResponseEntity.ok(pagamentos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Pagamento pagamento = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado"));
        this.repository.delete(pagamento);
        return ResponseEntity.noContent().build();
    }

}
