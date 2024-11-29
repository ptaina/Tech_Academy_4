package com.maritai.livrosdigitais.dto;

import java.math.BigDecimal;

public record ItemRequestDTO(String titulo, BigDecimal valor,Integer qtd_estoque, Integer categoria_id, String escritor) {
}
