package com.maritai.livrosdigitais.dto;

import java.math.BigDecimal;

public record ItemRequestDTO(String titulo, BigDecimal preco,Integer qtd_estoque, Integer categoria_id, String escritor) {
}
