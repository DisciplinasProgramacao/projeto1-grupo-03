package com.project.domain;

import lombok.Data;

@Data
public class Produto {
    static double IMPOSTOS_PORCENTAGEM = 0.18;

    String nome;
    String descricao;
    double precoCusto;
    double precoVenda;
    double lucroPorcentagem;
    int estoque;
}
