package com.project.domain;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

import lombok.Data;

@Data
public class Estoque {
    private int tamanhoMaximo;
    private List<Produto> produtos;

    public Estoque(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.produtos = new ArrayList<>();
    }

    /**
     * Adiciona produto no estoque
     * @param produto
     */
    public void adicionarProduto(Produto produto) {
        if (produtos.size() < tamanhoMaximo) {
            produtos.add(produto);
        } else {
            throw new RuntimeException("Estoque cheio. Impossível adicionar produto.");
        }
    }

    /**
     * @param produto removido do estoque
     */
    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    private void setTamanhoMaximo(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
    }

    /**
     * @return Quantos produtos cadastrados no estoque
     */
    public int getQuantidadeProdutos() {
        return produtos.size();
    }

    /**
     * @return todos os produtos que estão abaixo do estoque mínimo
     */
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

    /**
     * @return valor do estoque de todos os produtos
     */
    public double getValorTotalEstoque() {
    	double valorTotal = 0;
    	for (int i = 0; i < this.produtos.size(); i++) {
            Produto produto = this.produtos.get(i);
            valorTotal += produto.getPrecoVenda() * produto.getEstoque();
        }
    	return valorTotal;
    }

    /**
     * Checa a lista de produtos buscando pelo produto com o id inserido
     * @param id
     * @return
     */
    public Produto getProdutoPeloId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }


    /**
     * Consulta um produto pelo seu id
     * @param id
     */
    public String consultaProduto(int id) {
    	Produto produto = getProdutoPeloId(id);
    	return (produto.getDescricaoCompleta());
    }

    /**
     * Repõe o estoque do produto
     */
    public void reporEstoque(int id, int quantidadeComprada, double precoCusto){
        Produto produto = getProdutoPeloId(id);
        produto.entradaDeProduto(quantidadeComprada, precoCusto);
    }

    /**
     * Retira produto do estoque
     */
    public void retirarDoEstoque(int id){
        Produto produto = getProdutoPeloId(id);
        if (produto != null)
            this.removerProduto(produto);
    }

    /**
     * Exibe balnço total do estoque
     */
    public void exibirBalanco() {
        double valorEstoque = produtos.stream()
                .map(produto -> produto.getPrecoVenda() * produto.getEstoque())
                .reduce(Double::sum)
                .orElse(0D);

        double valorVendido = produtos.stream()
                .map(Produto::getValorArrecadado)
                .reduce(Double::sum)
                .orElse(0D);


        double valorPedidos = produtos.stream()
                .map(Produto::getValorGastoCompra)
                .reduce(Double::sum)
                .orElse(0D);

        StringBuilder res = new StringBuilder()
                .append("Valor estoque: " + valorEstoque)
                .append("\n")
                .append("Valor vendido: " + valorVendido)
                .append("\n")
                .append("Valor de pedidos: " + valorPedidos);

        System.out.println(res);
    }

    //teste
}
    




