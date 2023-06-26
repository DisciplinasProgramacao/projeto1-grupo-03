package com.project;
import java.util.Scanner;

import com.project.domain.Estoque;
import com.project.domain.Produto;


public class App {
    public static void main(String[] args) {
        

        Estoque estoque = new Estoque(100);

        //tive que corrigir todos os construtores
        Produto p1 = new Produto(1,"12 Ovos", 2.0, 0.5, 10, 15);
        Produto p2 = new Produto(2,"Manteiga 200g", 4.0, 0.5, 10, 15);
        Produto p3 = new Produto(3,"Pão de forma", 3.0, 0.5, 10, 15);
        Produto p4 = new Produto(4,"Biscoito de Polvinho 90g", 1.0, 0.5, 10, 15);
        Produto p5 = new Produto(5,"Coca-Cola 2Lt", 1.5, 0.5, 10, 15);
        Produto p6 = new Produto(6,"Frango 1Kg", 10.0, 0.5, 10, 15);
        Produto p7 = new Produto(7,"Penca de Banana", 5.0, 0.5, 5, 5);
        Produto p8 = new Produto(8,"Tomate", 1.0, 0.5, 10, 5);
        Produto p9 = new Produto(9,"Leite 1lt", 2.0, 0.5, 10, 10);
        estoque.adicionarProduto(p1);
        estoque.adicionarProduto(p2);
        estoque.adicionarProduto(p3);
        estoque.adicionarProduto(p4);
        estoque.adicionarProduto(p5);
        estoque.adicionarProduto(p6);
        estoque.adicionarProduto(p7);
        estoque.adicionarProduto(p8);
        estoque.adicionarProduto(p9);
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;

        do {
            escolha = 0;
            System.out.println("Selecione uma opção:");
            System.out.println("1. Registrar venda");
            System.out.println("2. Registrar pedido de produtos");
            System.out.println("3. Consultar estoque");
            System.out.println("4. Consultar produto");
            System.out.println("5. Exibir balanço");
            System.out.println("6. Sair");

            escolha = scanner.nextInt();
            
            switch (escolha) {
                case 1:
                    System.out.println("Você selecionou a opção 1 - Venda de produto.");
                    registrarVenda(estoque);
                    break;
                case 2:
                    System.out.println("Você selecionou a opção 2 - Registro de entrada de produtos.");
                    registrarPedido(estoque);
                    System.out.print(p2.getEstoque());
                    break;
                case 3:
                    System.out.println("Você selecionou a opção 3 - Consultar o estoque.");

                    break;
                case 4:
                    System.out.println("Você selecionou a opção 4 - Consultar um produto.");
                    System.out.println("Digite o Id do produto que deseja consultar:");
                    System.out.println(estoque.consultaProduto(scannerID()));
                    break;
                case 5:
                    System.out.println("Você selecionou a opção 5 - Exibir demonstrativo.");
                    estoque.exibirBalanco();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (escolha != 6);
        
    }

    public static void registrarVenda(Estoque estoque) {
        Scanner idScan = new Scanner(System.in);
        Scanner quantProdScan = new Scanner(System.in);
        int idProduto = 0;
        int quantidadeVendida = 0;
        System.out.println("Qual o id do produto vendido?");
        idProduto = idScan.nextInt();
        System.out.println("Qual a quantidade de produtos vendidos?");
        quantidadeVendida = quantProdScan.nextInt();
        Produto produto = estoque.getProdutoPeloId(idProduto);
        produto.saidaDeProduto(quantidadeVendida);
        System.out.println(quantidadeVendida + " itens foram debitados do estoque;");
    }

    public static void registrarPedido(Estoque estoque) {
        Scanner idScan = new Scanner(System.in);
        Scanner quantProdScan = new Scanner (System.in);
        Scanner precoCustoScan = new Scanner (System.in);
        int idProduto = 0;
        int quantidadeComprada = 0;
        double precoCusto = 0.0;
        System.out.println("Qual o id do produto comprado?");
        idProduto = idScan.nextInt();
        System.out.println("Qual a quantidade de produtos comprados?");
        quantidadeComprada = quantProdScan.nextInt();
        System.out.println("Qual a preço do produto comprados");
        precoCusto = precoCustoScan.nextDouble(); 
        estoque.reporEstoque(idProduto, quantidadeComprada, precoCusto);
        System.out.println(quantidadeComprada + " unidades foram adicionadas ao estoque;");
    }

    public static int scannerID() {
    	Scanner idScan = new Scanner(System.in);
        int idProduto = 0;
        idProduto = idScan.nextInt();
        return idProduto;
        
    }
 
}
