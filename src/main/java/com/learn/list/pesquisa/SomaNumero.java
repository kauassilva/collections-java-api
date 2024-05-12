package com.learn.list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumero {

    private List<Integer> numerosInteiros;

    public SomaNumero() {
        numerosInteiros = new ArrayList<>();
    }

    public void adicionarNumeros(int numero) {
        numerosInteiros.add(numero);
    }

    public Integer calcularSoma() {
        int soma = 0;

        for (Integer numero : numerosInteiros)
            soma += numero;

        return soma;
    }

    public Integer encontrarMaiorNumero() {
        int maior = numerosInteiros.getFirst();

        for (int i=1; i<numerosInteiros.size(); i++)
            maior = Math.max(maior, numerosInteiros.get(i));

        return maior;
    }

    public Integer encontrarMenorNumero() {
        int menor = numerosInteiros.getFirst();

        for (int i=1; i<numerosInteiros.size(); i++)
            menor = Math.min(menor, numerosInteiros.get(i));

        return menor;
    }

    public void exibirNumeros() {
        for (Integer numero : numerosInteiros)
            System.out.println(numero);
    }

    public static void main(String[] args) {
        SomaNumero somaNumero = new SomaNumero();

        somaNumero.adicionarNumeros(-5);
        somaNumero.adicionarNumeros(0);
        somaNumero.adicionarNumeros(0);
        somaNumero.adicionarNumeros(-2);



        System.out.println("Números adicionados: ");
        somaNumero.exibirNumeros();

        System.out.println("Soma dos números = " + somaNumero.calcularSoma());

        System.out.println("Maior número = " + somaNumero.encontrarMaiorNumero());

        System.out.println("Menor número = " + somaNumero.encontrarMenorNumero());

    }

}
