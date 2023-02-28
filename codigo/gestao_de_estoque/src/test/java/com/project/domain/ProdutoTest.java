package com.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProdutoTest {

    private Produto produto;

    /**
     * Configura a instância de produto para cada novo teste a ser rodado
     */
    @BeforeEach
    public void setUp() {
        produto = new Produto();
    }

    /**
     * Verifica as bordas se não está menor os 30% pedidos como requisito
     */
    @Test
    public void lucroPorcentagemMenorTest() {
        assertThrows(RuntimeException.class, () -> {
            produto.setLucroPorcentagem(0.29);
        });
    }

    /**
     * Verifica as bordas se não está estrapolando os 80% pedidos como requisito
     */
    @Test
    public void lucroPorcentagemMaiorTest() {
        assertThrows(RuntimeException.class, () -> {
            produto.setLucroPorcentagem(0.81);
        });
    }

    /**
     * Verifica se o cálculo de imposto está como esperado
     */
    @Test
    public void getImpostosTest() {
        produto.setLucroPorcentagem(0.5);
        produto.setPrecoCusto(50);
        double impostos = produto.getImpostos();
        assertEquals(13.5, impostos, 0.01);
    }

    /*
     * Verifica se a descrição tem no mínimo 3 caracteres
     */

     @Test
     public void setDescricaoTest() {
        assertThrows(RuntimeException.class, () -> {produto.setDescricao("aa");});
    }

    /*
     * Verifica se o estoqueMinimo não é ativado ao chegar no minimo
     */
    @Test
    public void checaEstoqueNoMinimoTest() {
        assertEquals(false, produto.checaEstoqueMinimo(5, 5));
    }

    /*
     * Verifica se o estoqueMinimo é ativado ao estar abaixo do mínimo
     */
    @Test
    public void checaEstoqueAbaixoDoMinimoTest() {
        assertEquals(true, produto.checaEstoqueMinimo(4, 5));
    }
}
