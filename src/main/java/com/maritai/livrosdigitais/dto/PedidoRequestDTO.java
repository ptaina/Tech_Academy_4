package com.maritai.livrosdigitais.dto;


import java.math.BigDecimal;
import java.util.List;


public record PedidoRequestDTO(Integer usuario_id, String dt_pedido, BigDecimal total, List<ItemPedidoRequestDTO> itens) {
}
