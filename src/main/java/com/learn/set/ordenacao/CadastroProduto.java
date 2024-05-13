package com.learn.set.ordenacao;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProduto {

    private Set<Produto> produtos;

    public CadastroProduto() {
        produtos = new HashSet<>();
    }

    public void adicionarProduto(long codigo, String nome, double preco, int quantidade) {
        produtos.add(new Produto(codigo, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        // Para retornar ordenado, não pode usar o HashSet, pois ele não mantém a ordem
        return new TreeSet<>(produtos);
    }

    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        produtosPorPreco.addAll(produtos);
        return produtosPorPreco;
    }

    public static void main(String[] args) {
        CadastroProduto CadastroProduto = new CadastroProduto();

        CadastroProduto.adicionarProduto(1L, "Smartphone", 1000d, 10);
        CadastroProduto.adicionarProduto(2L, "Notebook", 1500d, 5);
        CadastroProduto.adicionarProduto(1L, "Mouse", 30d, 20); // Este não irá ser adicionado
        CadastroProduto.adicionarProduto(4L, "Teclado", 50d, 15);

        System.out.println(CadastroProduto.produtos);

        System.out.println(CadastroProduto.exibirProdutosPorNome());

        System.out.println(CadastroProduto.exibirProdutosPorPreco());
    }

}
