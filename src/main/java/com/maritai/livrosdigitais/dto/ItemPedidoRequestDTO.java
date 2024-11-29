package com.maritai.livrosdigitais.dto;

import java.math.BigDecimal;

public record ItemPedidoRequestDTO(Integer pedido_id, Integer item_id, Integer quantidade, BigDecimal valor) {
}
