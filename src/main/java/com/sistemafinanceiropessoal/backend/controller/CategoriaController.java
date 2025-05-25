package com.sistemafinanceiropessoal.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemafinanceiropessoal.backend.model.Categoria;
import com.sistemafinanceiropessoal.backend.service.CategoriaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/categorias")

public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public Categoria criarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.salvar(categoria);
    }
    
    @GetMapping
    public List<Categoria> listarTodasAsCategorias() {
        return categoriaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Categoria buscarCategoria(@RequestParam Long id) {
        return categoriaService.buscarPorId(id);
    }

    @GetMapping("/{id}")
    public Categoria deletarCategoria(@RequestParam Long id) {
        return categoriaService.deletar(id);
    }
    
}
