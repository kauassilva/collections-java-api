package com.learn.list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumero {

    private List<Integer> numeros;

    public OrdenacaoNumero() {
        numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numeros.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        if (numeros.isEmpty())
            throw new RuntimeException("A lista está vazia");

        List<Integer> resultado = new ArrayList<>(numeros);
        Collections.sort(resultado);
        return resultado;
    }

    public List<Integer> ordenarDescendente() {
        if (numeros.isEmpty())
            throw new RuntimeException("A lista está vazia");

        List<Integer> resultado = new ArrayList<>(numeros);
        Collections.sort(resultado, Collections.reverseOrder());
        return resultado;
    }

    public void exibirNumeros() {
        for (Integer numero : numeros)
            System.out.println(numero);
    }

    public static void main(String[] args) {
        OrdenacaoNumero ordenacaoNumero = new OrdenacaoNumero();

        ordenacaoNumero.adicionarNumero(2);
        ordenacaoNumero.adicionarNumero(5);
        ordenacaoNumero.adicionarNumero(4);
        ordenacaoNumero.adicionarNumero(1);
        ordenacaoNumero.adicionarNumero(99);

        ordenacaoNumero.exibirNumeros();

        System.out.println(ordenacaoNumero.ordenarAscendente());
        System.out.println(ordenacaoNumero.ordenarDescendente());
    }

}
