package com.sistemafinanceiropessoal.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemafinanceiropessoal.backend.repository.CategoriaRepository;
import com.sistemafinanceiropessoal.backend.model.Categoria;

@Service

public class CategoriaService {
    CategoriaRepository categoriaRepository;

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
        if(c.getTransacoes() != null && !c.getTransacoes().isEmpty()){
            throw new RuntimeException("Não é possível deletar categoria. Transações associadas."); 
        }

        categoriaRepository.delete(c);
    }
}
