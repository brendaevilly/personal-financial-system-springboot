package com.sistemafinanceiropessoal.backend.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sistemafinanceiropessoal.backend.model.Categoria;
import com.sistemafinanceiropessoal.backend.model.Transacao;
import com.sistemafinanceiropessoal.backend.service.CategoriaService;
import com.sistemafinanceiropessoal.backend.service.TransacaoService;

@Controller
public class PaginaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private TransacaoService transacaoService;

    // Página inicial
    @GetMapping({"/", "/index"})
    public String paginaInicial() {
        return "index";
    }

    // Página de cadastro de categoria
    @GetMapping("/categorias")
    public String paginaCategorias(Model model) {
        List<Categoria> categorias = categoriaService.listarTodas();
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("categorias", categorias);
        return "categoria";
    }

    // Página de cadastro de transação
    @GetMapping("/cadastrartrans")
    public String paginaCadastrarTransacao(Model model) {
        List<Categoria> categorias = categoriaService.listarTodas();
        model.addAttribute("transacao", new Transacao());
        model.addAttribute("categorias", categorias);
        return "cadastrartrans";
    }

    // Página de lista de transações
    @GetMapping("/listartrans")
    public String paginaListarTransacoes(Model model) {
        List<Transacao> transacoes = transacaoService.listarTodas();
        model.addAttribute("transacoes", transacoes);
        return "listartrans";
    }

    // Página de saldo / resumo financeiro
    @GetMapping("/saldo")
    public String paginaSaldo(Model model) {
        double saldo = transacaoService.calcularSaldo();
        double receita = transacaoService.calcularReceitaTotal();
        double despesa = transacaoService.calcularDespesaTotal();

        DecimalFormat df = new DecimalFormat("#,##0.00");

        model.addAttribute("saldoFormatado", df.format(saldo));
        model.addAttribute("receitaFormatada", df.format(receita));
        model.addAttribute("despesaFormatada", df.format(despesa));

        double total = receita + despesa;
        double barraReceita = total > 0 ? (receita / total) * 100 : 0;
        double barraDespesa = total > 0 ? (despesa / total) * 100 : 0;
        double barraSaldo = 100;

        model.addAttribute("barraReceita", barraReceita);
        model.addAttribute("barraDespesa", barraDespesa);
        model.addAttribute("barraSaldo", barraSaldo);

        return "saldo";
    }

}
