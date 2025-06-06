package com.sistemafinanceiropessoal.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemafinanceiropessoal.backend.repository.CategoriaRepository;
import com.sistemafinanceiropessoal.backend.model.Categoria;

import com.sistemafinanceiropessoal.backend.model.Transacao;
import com.sistemafinanceiropessoal.backend.repository.TransacaoRepository;

@Service

public class CategoriaService {
    @Autowired
    private final CategoriaRepository categoriaRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria salvar(Categoria c){
        return categoriaRepository.save(c);
    }

    public List<Categoria> listarTodas(){
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id){
        return categoriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada com id: " + id));
    }

    public void deletar(Long id){
        Categoria c = buscarPorId(id);

        List<Transacao> transacoesDaCategoria = transacaoRepository.findTransacaoByCategoria_Id(id); 

        if(transacoesDaCategoria != null && !transacoesDaCategoria.isEmpty()){
            throw new RuntimeException("Não é possível deletar categoria. Transações associadas."); 
        }

        categoriaRepository.delete(c);
    }
}
