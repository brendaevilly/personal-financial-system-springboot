package com.sistemafinanceiropessoal.backend.controller;

import com.sistemafinanceiropessoal.backend.model.Categoria;
import com.sistemafinanceiropessoal.backend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/categorias")
    public String cadastrarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.salvar(categoria);
        return "redirect:/categorias";
    }

}
