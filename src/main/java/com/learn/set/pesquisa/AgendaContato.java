package com.learn.set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContato {

    Set<Contato> contatos;

    public AgendaContato() {
        contatos = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatos.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        System.out.println(contatos);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();

        for (Contato contato : contatos)
            if (contato.getNome().startsWith(nome))
                contatosPorNome.add(contato);

        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;

        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contato.setNumero(novoNumero);
                contatoAtualizado = contato;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContato AgendaContato = new AgendaContato();

        AgendaContato.exibirContatos();

        AgendaContato.adicionarContato("João", 123456789);
        AgendaContato.adicionarContato("Maria", 987654321);
        AgendaContato.adicionarContato("Maria Fernandes", 55555555);
        AgendaContato.adicionarContato("Ana", 88889999);
        AgendaContato.adicionarContato("Fernando", 77778888);
        AgendaContato.adicionarContato("Carolina", 55555555);

        AgendaContato.exibirContatos();

        System.out.println(AgendaContato.pesquisarPorNome("Maria"));

        Contato contatoAtualizado = AgendaContato.atualizarNumeroContato("Carolina", 44443333);
        System.out.println("Contato atualizado: " + contatoAtualizado);

        System.out.println("Contatos na agenda após atualização:");
        AgendaContato.exibirContatos();
    }

}
