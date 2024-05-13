package com.learn.map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProduto {

    private Map<Long, Produto> estoqueProdutoMap;

    public EstoqueProduto() {
        estoqueProdutoMap = new HashMap<>();
    }

    public void adicionarProduto(long codigo, String nome, int quantidade, double preco) {
        estoqueProdutoMap.put(codigo, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos() {
        System.out.println(estoqueProdutoMap);
    }

    public Double calcularValorTotalEstoque() {
        double valorTotal = 0;

        if (!estoqueProdutoMap.isEmpty()) {
            for (Produto produto : estoqueProdutoMap.values()) {
                valorTotal += produto.getPreco() * produto.getQuantidade();
            }
        }

        return valorTotal;
    }

    public Produto obterProdutoMaisCaro() {
        if (estoqueProdutoMap.isEmpty()) {
            return null;
        }

        Produto produtoMaisCaro = null;
        double precoMaisCaro = Double.MIN_VALUE;

        for (Produto produto : estoqueProdutoMap.values()) {
            if (precoMaisCaro < produto.getPreco()) {
                produtoMaisCaro = produto;
            }
        }

        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        if (estoqueProdutoMap.isEmpty()) {
            return null;
        }

        Produto produtoMaisBarato = null;
        double precoMaisBarato = Double.MAX_VALUE;

        for (Produto produto : estoqueProdutoMap.values()) {
            if (precoMaisBarato > produto.getPreco()) {
                produtoMaisBarato = produto;
            }
        }

        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        if (estoqueProdutoMap.isEmpty()) {
            return null;
        }

        Produto resultado = null;
        double precoTotalMaior = Double.MIN_VALUE;

        for (Produto produto : estoqueProdutoMap.values()) {
            double precoTotal = produto.getPreco() * produto.getQuantidade();

            if (precoTotal > precoTotalMaior) {
                resultado = produto;
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        EstoqueProduto estoque = new EstoqueProduto();

        estoque.exibirProdutos();

        estoque.adicionarProduto(1L, "Notebook", 1, 1500.0);
        estoque.adicionarProduto(2L, "Mouse", 5, 25.0);
        estoque.adicionarProduto(3L, "Monitor", 10, 400.0);
        estoque.adicionarProduto(4L, "Teclado", 2, 40.0);

        estoque.exibirProdutos();

        System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());

        Produto produtoMaisCaro = estoque.obterProdutoMaisCaro();
        System.out.println("Produto mais caro: " + produtoMaisCaro);

        Produto produtoMaisBarato = estoque.obterProdutoMaisBarato();
        System.out.println("Produto mais barato: " + produtoMaisBarato);

        Produto produtoMaiorQuantidadeValorTotal = estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
        System.out.println("Produto com maior quantidade em valor no estoque: " + produtoMaiorQuantidadeValorTotal);
    }

}
