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
     * Testa se a quantidade de produtos está correta
     */
    @Test
    public void getQuantidadeProdutosTest(Estoque estoque) {

        double quantidadeTotal = getQuantidadeProdutos(estoque);
        assertEquals(22, 20);
    }


}
