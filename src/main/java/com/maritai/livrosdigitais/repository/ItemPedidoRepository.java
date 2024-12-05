package com.maritai.livrosdigitais.repository;

import com.maritai.livrosdigitais.model.ItemPedido;
import com.maritai.livrosdigitais.model.ItemPedidoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {

    @Transactional
    @Modifying
    @Query("DELETE FROM ItemPedido i WHERE i.id.pedido_id = :pedidoId")
    void deleteByPedidoId(Integer pedidoId);
}
