package com.sistemafinanceiropessoal.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistemafinanceiropessoal.backend.model.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria, Long>{
}
