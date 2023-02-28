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

    /**
     * @return Valor total a ser pago de imposto sendo, 18% sobre a soma do custo e da margem de lucro.
     */
    public double getImpostos() {
        return (precoCusto * (1 + lucroPorcentagem)) * IMPOSTOS_PORCENTAGEM;
    }

    
    public String setDescricao(String descricao) {
        if(descricao.length() >= 3) {
            return (this.descricao = descricao);
        }
        else{
           throw new RuntimeException("A descrição deve ter 3 ou mais caracteres.");
        }
    }
}
