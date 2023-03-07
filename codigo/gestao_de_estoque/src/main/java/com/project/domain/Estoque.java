package com.project.domain;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

public class Estoque {
    private int tamanhoMaximo;
    private List<Produto> produtos;

    public Estoque(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.produtos = new ArrayList<>();
    }

    public int getQuantidadeProdutos() {
        return produtos.size();
    }

    public double getValorTotalEstoque() {
        double valorTotal = 0.0;
        for (Produto produto : produtos) {
            valorTotal += produto.getPrecoCusto() * produto.getEstoque();
        }
        return valorTotal;
    }

}