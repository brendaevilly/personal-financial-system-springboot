package com.sistemafinanceiropessoal.backend.controller;

import com.sistemafinanceiropessoal.backend.model.Transacao;
import com.sistemafinanceiropessoal.backend.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/cadastrartrans")
    public String cadastrarTransacao(@ModelAttribute Transacao transacao) {
        transacaoService.salvar(transacao);
        return "redirect:/listartrans";
    }

}
