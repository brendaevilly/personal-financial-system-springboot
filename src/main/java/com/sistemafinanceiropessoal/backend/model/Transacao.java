package com.sistemafinanceiropessoal.backend.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;
    private LocalDate data;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    // Construtores
    public Transacao() {}

    public Transacao(Long id, Double valor, LocalDate data, String descricao, Categoria categoria) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}

