package com.sistemafinanceiropessoal.backend.model;

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
}
