package com.project.domain;

import lombok.Data;

@Data
public class Produto {
    static final double IMPOSTOS_PORCENTAGEM = 0.18;

    String descricao;
    double precoCusto;
    double lucroPorcentagem;
    int estoque = 0;
    int estoqueMinimo;
    double valorArrecadadoVenda = 0;
    int quantidadeVendida = 0;
    double valorGastoCompra = 0;
    int quantidadeComprada = 0;

    public Produto(String descricao, double precoCusto, double lucroPorcentagem, int estoqueMinimo, int estoque) {
        this(descricao, precoCusto, lucroPorcentagem, estoqueMinimo);
        this.estoque = estoque;
    }

    public Produto(String descricao, double precoCusto, double lucroPorcentagem, int estoqueMinimo) {
        this.setDescricao(descricao);
        this.precoCusto = precoCusto;
        this.setLucroPorcentagem(lucroPorcentagem);
        this.estoqueMinimo = estoqueMinimo;
    }

    /**
     * Lucro deve ser entre 30% e 80%
     * @param lucroPorcentagem exemplo 0.3
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
    
    public void setDescricao(String descricao) {
        if(descricao.length() >= 3) {
            this.descricao = descricao;
        }
        else{
           throw new RuntimeException("A descrição deve ter 3 ou mais caracteres.");
        }
    }

    public void setQuantidadeVendida() {
        
    }

    private double getLucro() {
    	return this.precoCusto * lucroPorcentagem;
    }
    
    public double getPrecoVenda() {
    	return getImpostos() + getLucro() + precoCusto;
    }
    
    public boolean checaEstoqueMinimo() {
        return this.estoque < this.estoqueMinimo;
    }

	public void setPrecoCusto(int precoCusto) {
		this.precoCusto = precoCusto;
	}
}
