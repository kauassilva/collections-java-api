package com.learn.map.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

    private Map<String, String> dicionarioMap;

    public Dicionario() {
        dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if (dicionarioMap.isEmpty()) {
            System.out.println("O dicionário está vazio!");
        } else {
            dicionarioMap.remove(palavra);
        }
    }

    public void exibirPalavras() {
        if (dicionarioMap.isEmpty()) {
            System.out.println("O dicionário está vazio!");
        } else {
            System.out.println(dicionarioMap);
        }
    }

    public String pesquisarPorPalavra(String palavra) {
        String resultado = dicionarioMap.get(palavra);

        if (resultado == null) {
            return "Linguagem não encontrada no dicionário!";
        }

        return resultado;
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("java", "Linguagem de programação orientada a objetos.");
        dicionario.adicionarPalavra("typescript", "Superset da linguagem JavaScript que adiciona tipagem estática.");
        dicionario.adicionarPalavra("kotlin", "Linguagem moderna de programação para a JVM.");

        dicionario.exibirPalavras();

        String definicaoJava = dicionario.pesquisarPorPalavra("java");
        System.out.println("Definição da linguagem 'java': " + definicaoJava);

        String definicaoCSharp = dicionario.pesquisarPorPalavra("csharp");
        System.out.println(definicaoCSharp);

        dicionario.removerPalavra("typescript");
        dicionario.exibirPalavras();
    }

}
