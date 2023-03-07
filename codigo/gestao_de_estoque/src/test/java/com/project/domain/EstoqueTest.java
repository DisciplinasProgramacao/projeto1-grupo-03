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
        estoque = new Estoque(1);
    }

    /***
     * Testa se conseguimos adicionar um produto no estoque
     */
    @Test
    public void adicionarProdutoTest() {
        Produto produto = new Produto("desc", 1.0, 0.5, 10, 5 );
        estoque.adicionarProduto(produto);  
        assertEquals(1, estoque.getQuantidadeProdutos());
    }

    /***
     * Testa se a lista de produtos do estoque não aceita produtos a mais do máximo
     */
    @Test
    public void adicionarProdutoAMaisTest() {
        Produto produto = new Produto("desc", 1.0, 0.5, 10, 5 );
        Produto produto2 = new Produto("desc", 1.0, 0.5, 10, 5 );
        estoque.adicionarProduto(produto);  

        assertThrows(RuntimeException.class, () -> {estoque.adicionarProduto(produto2);});
    }

    /***
     * Testa uma remoção de produto possível
     */
    @Test
    public void removerProdutoTest() {
        Produto produto = new Produto("desc", 1.0, 0.5, 10, 5 );
        estoque.adicionarProduto(produto);
        estoque.removerProduto(produto);
        int quantidadeTotal = estoque.getQuantidadeProdutos();
        assertEquals(0, quantidadeTotal);
    }

    /***
     * Testa se a quantidade de produtos está correta
     */
    @Test
    public void getQuantidadeProdutosTest() {
        estoque = new Estoque(20);
        for(int i = 0; i<20; i++) {
        Produto produto = new Produto("desc", 1.0, 0.5, 10, 5 );
        estoque.adicionarProduto(produto);
        }
        int quantidadeTotal = estoque.getQuantidadeProdutos();
        assertEquals(20, quantidadeTotal);
    }


}
