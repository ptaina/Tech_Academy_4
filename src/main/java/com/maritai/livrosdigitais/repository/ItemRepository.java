package com.maritai.livrosdigitais.repository;

import com.maritai.livrosdigitais.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
