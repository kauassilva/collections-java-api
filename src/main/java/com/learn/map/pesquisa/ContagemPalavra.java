package com.learn.map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavra {

    private Map<String, Integer> contagemPalavraMap;

    public ContagemPalavra() {
        contagemPalavraMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        contagemPalavraMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if (contagemPalavraMap.isEmpty()) {
            System.out.println("O mapa está vazio!");
        } else {
            contagemPalavraMap.remove(palavra);
        }
    }

    public int exibirContagemPalavras() {
        int contatemTotal = 0;

        for (Integer contagem : contagemPalavraMap.values()) {
            contatemTotal += contagem;
        }
        return contatemTotal;
    }

    public String encontrarPalavraMaisFrequente() {
        String palavraMaisFrequente = null;
        int contagemMaior = 0;

        for (Map.Entry<String, Integer> palavra : contagemPalavraMap.entrySet()) {
            if (palavra.getValue() > contagemMaior) {
                palavraMaisFrequente = palavra.getKey();
                contagemMaior = palavra.getValue();
            }
        }

        return palavraMaisFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavra contagemLinguagens = new ContagemPalavra();

        contagemLinguagens.adicionarPalavra("Java", 2);
        contagemLinguagens.adicionarPalavra("Python", 8);
        contagemLinguagens.adicionarPalavra("JavaScript", 1);
        contagemLinguagens.adicionarPalavra("C#", 6);

        System.out.println("Existem " + contagemLinguagens.exibirContagemPalavras() + " palavras.");

        String linguagemMaisFrequente = contagemLinguagens.encontrarPalavraMaisFrequente();
        System.out.println("A linguagem mais frequente é: " + linguagemMaisFrequente);
    }

}
