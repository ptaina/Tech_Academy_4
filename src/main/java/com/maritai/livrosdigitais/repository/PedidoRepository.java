package com.maritai.livrosdigitais.repository;

import com.maritai.livrosdigitais.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
