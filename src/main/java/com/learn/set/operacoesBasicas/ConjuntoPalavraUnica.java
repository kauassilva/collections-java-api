package com.learn.set.operacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavraUnica {

    Set<String> palavrasUnicas;

    public ConjuntoPalavraUnica() {
        palavrasUnicas = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        palavrasUnicas.add(palavra);
    }

    public void removerPalavra(String palavra) {
        if (palavrasUnicas.isEmpty()) {
            System.out.println("O conjunto está vazio");
        } else {
            if (palavrasUnicas.contains(palavra))
                palavrasUnicas.remove(palavra);
            else
                System.out.println("Palavra não encontrada no conjunto!");
        }
    }

    public boolean verificarPalavra(String palavra) {
        return palavrasUnicas.contains(palavra);
    }

    public void exibirPalavrasUnicas() {
        if (palavrasUnicas.isEmpty())
            System.out.println("O conjunto está vazio!");
        else
            System.out.println(palavrasUnicas);
    }

    public static void main(String[] args) {
        ConjuntoPalavraUnica conjuntoLinguagens = new ConjuntoPalavraUnica();

        conjuntoLinguagens.adicionarPalavra("Java");
        conjuntoLinguagens.adicionarPalavra("Python");
        conjuntoLinguagens.adicionarPalavra("JavaScript");
        conjuntoLinguagens.adicionarPalavra("Python");
        conjuntoLinguagens.adicionarPalavra("C++");
        conjuntoLinguagens.adicionarPalavra("Ruby");

        conjuntoLinguagens.exibirPalavrasUnicas();

        conjuntoLinguagens.removerPalavra("Python");
        conjuntoLinguagens.exibirPalavrasUnicas();

        conjuntoLinguagens.removerPalavra("Swift");

        System.out.println("A linguagem 'Java' está no conjunto? " + conjuntoLinguagens.verificarPalavra("Java"));
        System.out.println("A linguagem 'Python' está no conjunto? " + conjuntoLinguagens.verificarPalavra("Python"));

        conjuntoLinguagens.exibirPalavrasUnicas();
    }

}
