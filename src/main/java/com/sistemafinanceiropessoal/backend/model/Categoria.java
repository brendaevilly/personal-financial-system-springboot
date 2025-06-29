package com.sistemafinanceiropessoal.backend.model;

import jakarta.persistence.*;

@Entity
public class Categoria {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCategoria;

    @Enumerated(EnumType.STRING)
    private TipoCategoria tipo;

    // Construtores
    public Categoria() {}

    public Categoria(Long id, String nomeCategoria, TipoCategoria tipo) {
        this.id = id;
        this.nomeCategoria = nomeCategoria;
        this.tipo = tipo;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public TipoCategoria getTipo() {
        return tipo;
    }

    public void setTipo(TipoCategoria tipo) {
        this.tipo = tipo;
    }
}
