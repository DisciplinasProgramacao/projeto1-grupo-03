package com.project;

import com.project.domain.Produto;

public class App {
    public static void main(String[] args) {
        Produto produto = new Produto();
        produto.setLucroPorcentagem(0.9);
        System.out.println("Hello World!");
    }
}
