package com.project.domain;


import lombok.Data;

@Data
public class Produto {
    private static double IMPOSTOS_PORCENTAGEM = 0.18;
    private int id;
    private String descricao;
    private double precoCusto;
    private double precoVenda;
    private double lucroPorcentagem;
    private int quantidadeComprada;
    private int quantidadeVendida;
    private double valorGastoCompra;
    private double valorArrecadadoVenda;
    private int estoque;
    private int estoqueMinimo;


    public Produto(int id, String descricao, double precoCusto, double lucroPorcentagem,int estoque, int estoqueMinimo) { //tive que corrigir
        this.id = id;
        this.setDescricao(descricao);
        this.precoCusto = precoCusto;
        this.setLucroPorcentagem(lucroPorcentagem);
        this.estoque = estoque;
        this.estoqueMinimo = estoqueMinimo;
        this.setPrecoVenda();
    }


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

    public boolean checaEstoqueMinimo(int estoque, int estoqueMinimo) {
        return (estoque < estoqueMinimo);
    }

    public void entradaDeProduto (int quantidadeComprada, double precoCusto) {
        this.quantidadeComprada += quantidadeComprada;
        this.valorGastoCompra += (precoCusto * quantidadeComprada);
        this.estoque += quantidadeComprada;
    }

    public void saidaDeProduto (int quantidadeVendida) {
        this.quantidadeVendida += quantidadeVendida;
        this.valorArrecadadoVenda += (getPrecoVenda() * quantidadeVendida);
        this.estoque -= quantidadeVendida;
    }

    public String getDescricaoCompleta() {
    	return ("Produto: " + this.getDescricao() + "\nPreço de Custo: " + this.getPrecoCusto() + "\nPreço de Venda: " + this.getPrecoVenda() + "\nPorcentagem de Lucro: " + this.getLucroPorcentagem() + "Estoque: " + this.getEstoque() + "\nEstoque Minimo: " + this.getEstoqueMinimo() + "\nValor Arrecadado: " + this.getValorArrecadado() + "\nQuantidade Vendida: " + this.getQuantidadeVendida() + "\nValor Gasto Aquisição: " + this.getValorGastoCompra() + "\nQuantidade Comprada: " + this.getQuantidadeComprada());
    }

    public void setPrecoVenda() {
		this.precoVenda = this.precoCusto + (this.precoCusto * this.lucroPorcentagem) + ((this.precoCusto + (this.precoCusto * this.lucroPorcentagem)) * this.IMPOSTOS_PORCENTAGEM);
	}

	private int getQuantidadeComprada() {
		return this.quantidadeComprada;
	}

	public double getValorGastoCompra() { //tive que corrigir
		return this.valorGastoCompra;
	}

	private int getQuantidadeVendida() {
		return this.quantidadeVendida;
	}

	public double getValorArrecadado() { //tive que corrigir
		return this.valorArrecadadoVenda;
	}

	public int getEstoqueMinimo() {
		return this.estoqueMinimo;
	}

	public int getEstoque() {
		return this.estoque;
	}

	private double getLucroPorcentagem() {
		return this.lucroPorcentagem;
	}

	private double getPrecoCusto() {
		return this.precoCusto;
	}

	private String getDescricao() {
		return this.descricao;
	}

    public int getId() {
        return this.id;
    }
}