package com.maritai.livrosdigitais.repository;

import com.maritai.livrosdigitais.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento,Integer> {
}
