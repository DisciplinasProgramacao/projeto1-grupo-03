package com.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    private Produto produto;

    /**
     * Configura a instância de produto para cada novo teste a ser rodado
     */
    @BeforeEach
    public void setUp() {
        produto = new Produto(1, "desc", 1.0, 0.5, 10, 5 );
    }

    /**
     * Verifica as bordas se não está menor os 30% pedidos como requisito
     */
    @Test
    void lucroPorcentagemMenorTest() {
        assertThrows(RuntimeException.class, () -> {
            produto.setLucroPorcentagem(0.29);
        });
    }

    /**
     * Verifica as bordas se não está estrapolando os 80% pedidos como requisito
     */
    @Test
    void lucroPorcentagemMaiorTest() {
        assertThrows(RuntimeException.class, () -> {
            produto.setLucroPorcentagem(0.81);
        });
    }

    /**
     * Verifica se o cálculo de imposto está como esperado
     */
    @Test
    void getImpostosTest() {
        produto.setLucroPorcentagem(0.5);
        produto.setPrecoCusto(50);
        double impostos = produto.getImpostos();
        assertEquals(13.5, impostos, 0.01);
    }

    /*
     * Verifica se a descrição tem no mínimo 3 caracteres
     */

     @Test
     void setDescricaoTest() {
        assertThrows(RuntimeException.class, () -> {produto.setDescricao("aa");});
    }
     
    
    @Test
    public void getPrecoVendaTest() {
        produto.setLucroPorcentagem(0.5);
        produto.setPrecoCusto(50);
    	double venda = produto.getPrecoVenda();
    	assertEquals(88.5, venda, 0.01);
    }


    /*
     * Verifica se o estoqueMinimo não é ativado ao chegar no minimo
     */
    @Test
    void checaEstoqueNoMinimoTest() {
        produto.setEstoqueMinimo(5);
        produto.setEstoque(5);
        assertFalse(produto.checaEstoqueMinimo());
    }

    /*
     * Verifica se o estoqueMinimo é ativado ao estar abaixo do mínimo
     */
    @Test
    void checaEstoqueAbaixoDoMinimoTest() {
        produto.setEstoqueMinimo(5);
        produto.setEstoque(4);
        assertTrue(produto.checaEstoqueMinimo());
    }
}
