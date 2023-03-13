package com.project;
import java.util.Scanner;

import com.project.domain.Estoque;
import com.project.domain.Produto;

public class App {
    public static void main(String[] args) {
        

        Estoque estoque = new Estoque(50);
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
                    System.out.println("Você selecionou a opção 1.");
                    // registrarVenda();

                    break;
                case 2:
                    System.out.println("Você selecionou a opção 2.");
                    break;
                case 3:
                    System.out.println("Estoque:");
                    System.out.println(estoque.descricaoCompleta());
                    break;
                case 4:
                	System.out.println("Qual o id do produto que deseja consultar?");
                    //estoque.consultaProduto(scannerID());
                    break;
                case 5:
                    System.out.println("Você selecionou a opção 5.");
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (escolha != 6);
        scanner.close();
    
    
    }
/**
    public static void registrarVenda() {
        Scanner idScan = new Scanner(System.in);
        int idProduto = 0;
        System.out.println("Qual o id do produto vendido?");
        idProduto = idScan.nextInt();
        estoque.getProdutoPeloId(idProduto);

    }

 */
    
    public static int scannerID() {
    	Scanner idScan = new Scanner(System.in);
        int idProduto = 0;
        idProduto = idScan.nextInt();
        idScan.close();
        return idProduto;
        
    }
}
