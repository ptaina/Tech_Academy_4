package com.maritai.livrosdigitais.dto;

import java.math.BigDecimal;


public record PedidoRequestDTO(Integer usuario_id, String dt_pedido, BigDecimal total) {
}
