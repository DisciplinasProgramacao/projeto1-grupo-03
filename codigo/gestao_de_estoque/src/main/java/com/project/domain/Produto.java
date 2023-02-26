package com.project.domain;

import lombok.Data;

@Data
public class Produto {
    String nome;
    String descricao;
    Double precoCusto;
    Double precoVenda;
    int lucroPorcentagem;
    int impostosPorcentagem;
    int estoque;
}
