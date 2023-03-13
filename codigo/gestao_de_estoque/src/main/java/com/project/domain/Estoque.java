package com.project.domain;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class Estoque {
    private int tamanhoMaximo;
    private List<Produto> produtos;

    public Estoque(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        if (produtos.size() < tamanhoMaximo) {
            produtos.add(produto);
        } else {
            throw new RuntimeException("Estoque cheio. Impossível adicionar produto.");
        }
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public void setTamanhoMaximo(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
    }

    public int getQuantidadeProdutos() {
        return produtos.size();
    }

    public List<Produto> getProdutosAbaixoDoMinimo() {
        List<Produto> produtoAbaixoDoMinimo = new ArrayList<>();
        for (int i = 0; i < this.produtos.size(); i++) {
            Produto produto = this.produtos.get(i);
            if (produto.checaEstoqueMinimo()) {
                produtoAbaixoDoMinimo.add(produto);
            }
        }
        return produtoAbaixoDoMinimo;

//        return this.produtos.stream()
//                .filter(Produto::checaEstoqueMinimo)
//                .collect(Collectors.toList());
    }

    public double getValorTotalEstoque() {
    	double valorTotal = 0;
    	for (int i = 0; i < this.produtos.size(); i++) {
            Produto produto = this.produtos.get(i);
            valorTotal += produto.getPrecoVenda() * produto.getEstoque();
        }
    	return valorTotal;
    }
    
    // Checa a  lista de produtos buscando pelo produto com o id inserido
    public Produto getProdutoPeloId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }
    
    
    public void consultaProduto(int id) {
    	Produto produto = getProdutoPeloId(id);
    	System.out.println(produto.getDescricaoCompleta());
    }

    public void reporEstoque(){
        Scanner lerId = new Scanner(System.in);
        Scanner lerQtndProduto = new Scanner(System.in);
        Scanner lerPrecoProduto = new Scanner(System.in);
        int id, qtndProduto;
        double precoProduto;
        System.out.println("qual o ID do produto você deseja repor?");
        id = id.nextInt();
        System.out.println("qual a quantidade desse produto?");
        qtndProduto = lerQtndProduto.nextInt();
        System.out.println("qual o preço desse produto?");
        precoProduto = lerPrecoProduto.nextDouble();
        Produto produto = getProdutoPeloId(id);
        produto.entradaDeProduto(produto, qtndProduto, precoProduto);
    }

    public void retirarDoEstoque(){
        Scanner lerId = new Scanner(System.in);
        int id;
        System.out.println("qual o ID do produto você deseja retirar do estoque?");
        id = id.nextInt();
        Produto produto = getProdutoPeloId(id);
        produto.removerProduto();
    }
    //asdfg
}
    




