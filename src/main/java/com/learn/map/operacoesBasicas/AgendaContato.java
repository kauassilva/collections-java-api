package com.learn.map.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContato {

    private Map<String, Integer> agendaMap;

    public AgendaContato() {
        agendaMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        agendaMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if (!agendaMap.isEmpty()) {
            agendaMap.remove(nome);
        }
    }

    public void exibirContatos() {
        System.out.println(agendaMap);
    }

    public Integer pesquisarPorNome(String nome) {
        Integer telefone = null;

        if (!agendaMap.isEmpty()) {
            telefone = agendaMap.get(nome);
        }

        return telefone;
    }

    public static void main(String[] args) {
        AgendaContato agendaContatos = new AgendaContato();

        agendaContatos.adicionarContato("Camila", 123456);
        agendaContatos.adicionarContato("João", 5665);
        agendaContatos.adicionarContato("Carlos", 1111111);
        agendaContatos.adicionarContato("Ana", 654987);
        agendaContatos.adicionarContato("Maria", 1111111);
        agendaContatos.adicionarContato("Camila", 44444);

        agendaContatos.exibirContatos();

        agendaContatos.removerContato("Maria");
        agendaContatos.exibirContatos();

        String nomePesquisa = "João";
        Integer numeroPesquisa = agendaContatos.pesquisarPorNome("João");
        System.out.println("Número de telefone de " + nomePesquisa + ": " + numeroPesquisa);

        String nomePesquisaNaoExistente = "Paula";
        Integer numeroPesquisaNaoExistente = agendaContatos.pesquisarPorNome(nomePesquisaNaoExistente);
        System.out.println("Número de telefone de " + nomePesquisaNaoExistente + ": " + numeroPesquisaNaoExistente);
    }

}
