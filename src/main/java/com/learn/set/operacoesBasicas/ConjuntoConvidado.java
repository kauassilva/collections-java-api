package com.learn.set.operacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidado {

    private Set<Convidado> convidados;

    public ConjuntoConvidado() {
        convidados = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        convidados.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoParaRemover = null;

        for (Convidado convidado : convidados) {
            if (convidado.getCodigoConvite() == codigoConvite) {
                convidados.remove(convidado);
                break;
            }
        }
    }

    public int contarConvidados() {
        return convidados.size();
    }

    public void exibirConvidados() {
        System.out.println(convidados);
    }

    public static void main(String[] args) {
        ConjuntoConvidado conjuntoConvidado = new ConjuntoConvidado();

        System.out.println("Existem " + conjuntoConvidado.contarConvidados() + " dentro do Set de Convidados");

        conjuntoConvidado.adicionarConvidado("Convidado 1", 1234);
        conjuntoConvidado.adicionarConvidado("Convidado 2", 1235);
        conjuntoConvidado.adicionarConvidado("Convidado 3", 1235); // Não é adicionado devido o código ser repetido
        conjuntoConvidado.adicionarConvidado("Convidado 4", 1236);

        System.out.println("Existem " + conjuntoConvidado.contarConvidados() + " dentro do Set de Convidados");

        conjuntoConvidado.removerConvidadoPorCodigoConvite(1234);

        System.out.println("Existem " + conjuntoConvidado.contarConvidados() + " dentro do Set de Convidados");

        conjuntoConvidado.exibirConvidados();

    }

}
