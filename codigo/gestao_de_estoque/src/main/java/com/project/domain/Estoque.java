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
            valorTotal += produto.getPrecoVenda() * produto.estoque;
        }
    	return valorTotal;
    }
    
}




