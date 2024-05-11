package com.learn.list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompra {

    private List<Item> itens;

    public CarrinhoCompra() {
        itens = new ArrayList<Item>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        itens.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();

        if (itens.isEmpty()) {
            System.out.println("A lista está vazia!");
        } else {
            for (Item item : itens)
                if (item.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(item);
                }

            itens.removeAll(itensParaRemover);
        }
    }

    public Double calcularValorTotal() {
        double valorTotal = 0;

        if (itens.isEmpty()) {
            throw new RuntimeException("A lista está vazia!");
        } else {
            for (Item item : itens)
                valorTotal += item.getPreco() * item.getQuantidade();

            return valorTotal;
        }
    }

    public void exibirItens() {
        if (itens.isEmpty())
            System.out.println("A lista está vazia!");
        else
            for (Item item : itens)
                System.out.println(item);
    }

    public static void main(String[] args) {
        CarrinhoCompra carrinhoCompra = new CarrinhoCompra();

        carrinhoCompra.exibirItens();

        carrinhoCompra.adicionarItem("Lápis", 1.5, 20);
        carrinhoCompra.adicionarItem("Caneta", 2, 30);

        carrinhoCompra.exibirItens();

        System.out.println("O valor total da compra é = " + carrinhoCompra.calcularValorTotal());

        carrinhoCompra.removerItem("Caneta");

        carrinhoCompra.exibirItens();
    }

}
