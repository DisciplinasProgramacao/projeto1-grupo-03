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

    public void setTamanhoMaximo() {
        this.tamanhoMaximo = tamanhoMaximo;
    }

    public int getQuantidadeProdutos() {
        return produtos.size();
    }

}