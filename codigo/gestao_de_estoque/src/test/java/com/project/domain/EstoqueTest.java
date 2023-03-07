package com.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EstoqueTest {
    
    private Estoque estoque;

    /**
    * Configura a instância de estoque para cada novo teste a ser rodado
    */
    @BeforeEach
    public void setUp() {
        estoque = new Estoque(1);
    }

    /***
     * Testa se conseguimos adicionar um produto no estoque
     */
    @Test
    void adicionarProdutoTest() {
        Produto produto = new Produto("desc", 1.0, 0.5, 10, 5 );
        estoque.adicionarProduto(produto);  
        assertEquals(1, estoque.getQuantidadeProdutos());
    }

    /***
     * Testa se a lista de produtos do estoque não aceita produtos a mais do máximo
     */
    @Test
    void adicionarProdutoAMaisTest() {
        Produto produto = new Produto("desc", 1.0, 0.5, 10, 5 );
        Produto produto2 = new Produto("desc", 1.0, 0.5, 10, 5 );
        estoque.adicionarProduto(produto);  

        assertThrows(RuntimeException.class, () ->
            estoque.adicionarProduto(produto2)
        );
    }

    /***
     * Testa uma remoção de produto possível
     */
    @Test
    void removerProdutoTest() {
        Produto produto = new Produto("desc", 1.0, 0.5, 10, 5 );
        estoque.adicionarProduto(produto);
        estoque.removerProduto(produto);
        assertEquals(0, estoque.getQuantidadeProdutos());
    }

    /***
     * Testa se a quantidade de produtos está correta
     */
    @Test
    void getQuantidadeProdutosTest() {
        int tamanhoMax = 20;
        estoque = new Estoque(tamanhoMax);

        for (int i = 0; i < tamanhoMax; i++) {
            Produto produto = new Produto("desc", 1.0, 0.5, 10, 5 );
            estoque.adicionarProduto(produto);
        }

        int quantidadeTotal = estoque.getQuantidadeProdutos();
        assertEquals(tamanhoMax, quantidadeTotal);
    }


}
