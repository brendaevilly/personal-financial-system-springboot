package com.sistemafinanceiropessoal.backend.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.sistemafinanceiropessoal.backend.model.Transacao;
import com.sistemafinanceiropessoal.backend.model.Categoria;
import com.sistemafinanceiropessoal.backend.model.TipoCategoria;
import com.sistemafinanceiropessoal.backend.repository.TransacaoRepository;

@Service

public class TransacaoService {
    @Autowired
    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository){
        this.transacaoRepository = transacaoRepository;
    }

    public Double calcularSaldo(){
        Double despesa = transacaoRepository.somaPorTipo(TipoCategoria.DESPESA);
        Double receita = transacaoRepository.somaPorTipo(TipoCategoria.RECEITA);
        despesa = (despesa == null)?0:despesa;
        receita = (receita == null)?0:receita;

        if(despesa > receita){
            return 0.0;
        }

        return receita - despesa;
    }

    public Double calcularReceitaTotal() {
        Double receita = transacaoRepository.somaPorTipo(TipoCategoria.RECEITA);
        return receita == null ? 0.0 : receita;
    }

    public Double calcularDespesaTotal() {
        Double despesa = transacaoRepository.somaPorTipo(TipoCategoria.DESPESA);
        return despesa == null ? 0.0 : despesa;
    }

    public Transacao salvar(Transacao t){
        return transacaoRepository.save(t);
    }

    public List<Transacao> listarPorCategoria(Long categoriaId){
        Categoria c = new Categoria();
        c.setId(categoriaId);
        return transacaoRepository.findByCategoria(c);
    }

    public List<Transacao> listarTodas(){
        return transacaoRepository.findAll();
    }
}
