package com.learn.list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {

    private List<Tarefa> tarefas;

    public ListaTarefa() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefas.add(new Tarefa(descricao));
    }

    // Pode haver tarefas repetidas
    public void removerTarefa(String descricao) {
        List<Tarefa> tarefasParaRemover = new ArrayList<>();

        for (Tarefa tarefa : tarefas)
            if (tarefa.getDescricao().equalsIgnoreCase(descricao))
                tarefasParaRemover.add(tarefa);

        tarefas.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalTarefas() {
        return tarefas.size();
    }

    public void obterDescricoesTarefas() {
        System.out.println(tarefas);
    }

}
