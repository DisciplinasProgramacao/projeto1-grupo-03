package com.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        Produto produto = new Produto(1, "desc", 1.0, 0.5, 10, 5 );
        estoque.adicionarProduto(produto);  
        assertEquals(1, estoque.getQuantidadeProdutos());
    }

    /***
     * Testa se a lista de produtos do estoque não aceita produtos a mais do máximo
     */
    @Test
    void adicionarProdutoAMaisTest() {
        Produto produto = new Produto(1, "desc", 1.0, 0.5, 10, 5 );
        Produto produto2 = new Produto(2, "desc", 1.0, 0.5, 10, 5 );
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
        Produto produto = new Produto(1, "desc", 1.0, 0.5, 10, 5 );
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
            Produto produto = new Produto(1, "desc", 1.0, 0.5, 10, 5 );
            estoque.adicionarProduto(produto);
        }

        int quantidadeTotal = estoque.getQuantidadeProdutos();
        assertEquals(tamanhoMax, quantidadeTotal);
    }
    
    @Test
    void testGetProdutosAbaixoDoMinimo() {
        estoque = new Estoque(5);
        Produto produto = new Produto(1, "desc1", 1.0, 0.5, 10, 10 );
        Produto produto2 = new Produto(2, "desc2", 1.0, 0.5, 3, 5 );

        estoque.adicionarProduto(produto);
        estoque.adicionarProduto(produto2);

        List<Produto> produtosAbaixoDoMinimo = estoque.getProdutosAbaixoDoMinimo();
        assertEquals(1, produtosAbaixoDoMinimo.size());
    }
    
    
    /**
     * Testa se o valor total do estoque está correto
     */
    @Test
    void testGetValorTotalEstoque() {
        estoque = new Estoque(5);
        Produto produto = new Produto(1, "desc1", 1.0, 0.5, 10, 10 ); //17,70
        Produto produto2 = new Produto(2, "desc2", 10.0, 0.5, 1, 1 ); //17,70

        estoque.adicionarProduto(produto);
        estoque.adicionarProduto(produto2);

        double valorTotal = estoque.getValorTotalEstoque();
        assertEquals(35.4, valorTotal, 0.01);
    }
    
}
