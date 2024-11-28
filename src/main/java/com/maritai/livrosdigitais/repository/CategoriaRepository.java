package com.maritai.livrosdigitais.repository;

import com.maritai.livrosdigitais.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository <Categoria, Integer> {
}
