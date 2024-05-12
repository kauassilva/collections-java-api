package com.learn.list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoa {

    private List<Pessoa> pessoas;

    public OrdenacaoPessoa() {
        pessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        pessoas.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> resultado = new ArrayList<>(pessoas);
        Collections.sort(resultado);
        return resultado;
    }

    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> resultado = new ArrayList<>(pessoas);
        Collections.sort(resultado, new ComparatorPorAltura());
        return resultado;
    }

    public static void main(String[] args) {
        OrdenacaoPessoa ordenacaoPessoa = new OrdenacaoPessoa();
        ordenacaoPessoa.adicionarPessoa("Nome 1", 20, 1.56);
        ordenacaoPessoa.adicionarPessoa("Nome 2", 30, 1.80);
        ordenacaoPessoa.adicionarPessoa("Nome 3", 25, 1.70);
        ordenacaoPessoa.adicionarPessoa("Nome 4", 17, 1.56);

        System.out.println(ordenacaoPessoa.pessoas);

        System.out.println(ordenacaoPessoa.ordenarPorIdade());
        System.out.println(ordenacaoPessoa.ordenarPorAltura());
    }

}
