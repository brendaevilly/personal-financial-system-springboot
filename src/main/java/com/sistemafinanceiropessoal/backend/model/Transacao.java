package com.sistemafinanceiropessoal.backend.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*; 

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

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
}
