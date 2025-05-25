package com.sistemafinanceiropessoal.backend.model;

import java.util.List;

import jakarta.persistence.*; 
import lombok.*; 

@Entity
@Data
@AllArgsConstructor 
@NoArgsConstructor

public class Categoria {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCategoria;
    @Enumerated(EnumType.STRING)
    private TipoCategoria tipo;

    @OneToMany(mappedBy = "categoria")
    private List<Transacao> transacoes;
}
