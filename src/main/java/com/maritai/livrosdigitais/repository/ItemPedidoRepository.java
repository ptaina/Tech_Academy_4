package com.maritai.livrosdigitais.repository;

import com.maritai.livrosdigitais.model.ItemPedido;
import com.maritai.livrosdigitais.model.ItemPedidoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {
}
