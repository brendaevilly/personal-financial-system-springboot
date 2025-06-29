package com.sistemafinanceiropessoal.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sistemafinanceiropessoal.backend.model.Categoria;
import com.sistemafinanceiropessoal.backend.model.TipoCategoria;
import com.sistemafinanceiropessoal.backend.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{
    @Query("SELECT SUM(t.valor) FROM Transacao t WHERE t.categoria.tipo = :tipo")
    Double somaPorTipo(@Param("tipo") TipoCategoria tipo);

    List<Transacao>findByCategoria(Categoria categoria);

    List<Transacao> findTransacaoByCategoria_Id(Long categotiaId);
}
