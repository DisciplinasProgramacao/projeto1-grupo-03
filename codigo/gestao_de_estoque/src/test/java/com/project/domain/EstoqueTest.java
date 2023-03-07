package com.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EstoqueTest {
    
    private Estoque estoque;

    /**
    * Configura a instância de estoque para cada novo teste a ser rodado
    */
    @BeforeEach
    public void setUp() {
        estoque = new Estoque(20);
    }

    /***
     * Testa se conseguimos adicionar um produto no estoque
     */
    @Test
    public void adicionarProdutoTest() {
        int quantidadeTotal = estoque.getQuantidadeProdutos();
        assertEquals(22, quantidadeTotal);
    }

    /***
     * Testa se a quantidade de produtos está correta
     */
    @Test
    public void getQuantidadeProdutosTest() {
        int quantidadeTotal = estoque.getQuantidadeProdutos();
        assertEquals(22, quantidadeTotal);
    }


}
