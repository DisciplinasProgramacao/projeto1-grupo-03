package com.project.domain;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class Estoque {
    private int tamanhoMaximo;
    private List<Produto> produtos;

    public Estoque(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        if (produtos.size() < tamanhoMaximo) {
            produtos.add(produto);
        } else {
            throw new RuntimeException("Estoque cheio. Impossível adicionar produto.");
        }
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public void setTamanhoMaximo(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
    }

    public int getQuantidadeProdutos() {
        return produtos.size();
    }
    
    public int getQuantidadeProdutosTotal() {
    	int quantProdTot = 0;
        for (int i = 0; i < this.produtos.size(); i++) {
            Produto produto = this.produtos.get(i);
            quantProdTot += produto.getEstoque();
        }
		return quantProdTot;
    }

    public List<Produto> getProdutosAbaixoDoMinimo() {
        List<Produto> produtoAbaixoDoMinimo = new ArrayList<>();
        for (int i = 0; i < this.produtos.size(); i++) {
            Produto produto = this.produtos.get(i);
            if (produto.checaEstoqueMinimo()) {
                produtoAbaixoDoMinimo.add(produto);
            }
        }
        return produtoAbaixoDoMinimo;

//        return this.produtos.stream()
//                .filter(Produto::checaEstoqueMinimo)
//                .collect(Collectors.toList());
    }

    public double getValorTotalEstoque() {
    	double valorTotal = 0;
    	for (int i = 0; i < this.produtos.size(); i++) {
            Produto produto = this.produtos.get(i);
            valorTotal += produto.getPrecoVenda() * produto.getEstoque();
        }
    	return valorTotal;
    }
    
   
    // Checa a  lista de produtos buscando pelo produto com o id inserido
    public Produto getProdutoPeloId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }
    
    
    public void consultaProduto(int id) {
    	Produto produto = getProdutoPeloId(id);
    	System.out.println(produto.getDescricaoCompleta());
    }
	
    private String converteLista() {
    		List<Produto> conversor = this.getProdutosAbaixoDoMinimo();
    		String convertido;
    		for (int i = 0; i < conversor.size(); i++) {
                Produto produto = conversor.get(i);
                convertido += "" + produto.getDescricao() + " - " + produto.getId();
            }
    		
    		return convertido;
    }

	public void descricaoCompleta() {
		System.out.printf("Quantidade de Tipos de Produtos em Estoque: " + this.getQuantidadeProdutos() + "\nQuantidade de Produtos em Estoque: " + this.getQuantidadeProdutosTotal() + "\nValor Total do Estoque: R$%.2f\nProdutos com Estoque Abaixo do Mínimo: " + this.getProdutosAbaixoDoMinimo(), this.getValorTotalEstoque());
	}
}
    




