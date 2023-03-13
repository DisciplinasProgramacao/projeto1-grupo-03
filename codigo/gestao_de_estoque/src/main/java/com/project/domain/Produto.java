package com.project.domain;

import lombok.Data;

@Data
public class Produto {
    private static final double IMPOSTOS_PORCENTAGEM = 0.18;

    int id = 0;
    private String descricao;
    private double precoCusto;
    private double lucroPorcentagem;
    private int estoque = 0;
    private int estoqueMinimo;
    private double valorArrecadadoVenda = 0;
    private int quantidadeVendida = 0;
    private double valorGastoCompra = 0;
    private int quantidadeComprada = 0;

    public Produto(int id, String descricao, double precoCusto, double lucroPorcentagem, int estoqueMinimo, int estoque) {
        this(id, descricao, precoCusto, lucroPorcentagem, estoqueMinimo);
        this.estoque = estoque;

    }

    public Produto(int id, String descricao, double precoCusto, double lucroPorcentagem, int estoqueMinimo) {
        this.setId(id);
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

    /**
     * Garante que a descrição tenha 3 ou mais caracteres
     * @param descricao
     */
    
    public void setDescricao(String descricao) {
        if(descricao.length() >= 3) {
            this.descricao = descricao;
        }
        else{
           throw new RuntimeException("A descrição deve ter 3 ou mais caracteres.");
        }
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

    public void entradaDeProduto (int quantidadeComprada, double precoCusto) {
        this.quantidadeComprada += quantidadeComprada;
        this.valorGastoCompra += (precoCusto * quantidadeComprada);
    }

    public void saidaDeProduto (int quantidadeVendida) {
        this.quantidadeVendida += quantidadeVendida;
        this.valorArrecadadoVenda += (getPrecoVenda() * quantidadeVendida);
    }

    
    public String getDescricaoCompleta() {
    	return ("Produto: " + this.getDescricao() + "\nPreço de Custo: " + this.getPrecoCusto() + "\nPreço de Venda: " + this.getPrecoVenda() + "\nPorcentagem de Lucro: " + this.getLucroPorcentagem() + "Estoque: " + this.getEstoque() + "\nEstoque Minimo: " + this.getEstoqueMinimo() + "\nValor Arrecadado: " + this.getValorArrecadado() + "\nQuantidade Vendida: " + this.getQuantidadeVendida() + "\nValor Gasto Aquisição: " + this.getValorGastoCompra() + "\nQuantidade Comprada: " + this.getQuantidadeComprada());
    }

	private int getQuantidadeComprada() {
		return this.quantidadeComprada;
	}

	private double getValorGastoCompra() {
		return this.valorGastoCompra;
	}

	private int getQuantidadeVendida() {
		return this.quantidadeVendida;
	}

	private double getValorArrecadado() {
		return this.valorArrecadadoVenda;
	}

	private int getEstoqueMinimo() {
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

}
