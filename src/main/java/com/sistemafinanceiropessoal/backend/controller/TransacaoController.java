package com.sistemafinanceiropessoal.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemafinanceiropessoal.backend.model.Transacao;
import com.sistemafinanceiropessoal.backend.service.TransacaoService;


@RestController
@RequestMapping("api/transacoes")

public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;
    
    @PostMapping
    public ResponseEntity<Transacao> criarTransacao(@RequestBody Transacao transacao) {
        Transacao transacaoSalva = transacaoService.salvar(transacao);
        return ResponseEntity.ok(transacaoSalva);
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> listarTodas(){
        return ResponseEntity.ok(transacaoService.listarTodas());
    }

    @GetMapping("/por-categoria/{id}")
    public ResponseEntity<List<Transacao>> listarPorCategoria(@PathVariable Long id){
        return ResponseEntity.ok(transacaoService.listarPorCategoria(id));
    }

    @GetMapping("/saldo")
    public ResponseEntity<Double> calcularSaldo(){
        return ResponseEntity.ok(transacaoService.calcularSaldo());
    }

}