package com.project.domain;

import org.junit.Before;
import org.junit.Test;

public class ProdutoTest {

    private Produto produto;

    /**
     * Configura a instância de produto para cada novo teste a ser rodado
     */
    @Before
    public void setUp() {
        produto = new Produto();
    }

    /**
     * Verifica as bordas se não está menor os 30% pedidos como requisito
     */
    @Test(expected = RuntimeException.class)
    public void lucroPorcentagemMenorTest() {
        produto.setLucroPorcentagem(0.29);
    }

    /**
     * Verifica as bordas se não está estrapolando os 80% pedidos como requisito
     */
    @Test(expected = RuntimeException.class)
    public void lucroPorcentagemMaiorTest() {
        produto.setLucroPorcentagem(0.81);
    }
}
