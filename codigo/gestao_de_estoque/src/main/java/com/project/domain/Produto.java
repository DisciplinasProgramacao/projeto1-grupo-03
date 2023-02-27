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

    /**
     * Lucro deve ser entre 30% e 80%
     * @param lucroPorcentagem exemplo 0.3
     * @exception RuntimeException
     */
    public void setLucroPorcentagem(double lucroPorcentagem) {
        if (lucroPorcentagem >= 0.3 && lucroPorcentagem <= 0.8) {
            this.lucroPorcentagem = lucroPorcentagem;
        } else {
            throw new RuntimeException("Porcentagem inválida.");
        }
    }
}
