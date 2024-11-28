package com.maritai.livrosdigitais.repository;

import com.maritai.livrosdigitais.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer >{
}
