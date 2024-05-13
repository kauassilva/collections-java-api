package com.learn.set.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAluno {

    private Set<Aluno> alunos;

    public GerenciadorAluno() {
        alunos = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, double nota) {
        alunos.add(new Aluno(matricula, nome, nota));
    }

    public void removerAluno(long matricula) {
        Aluno alunoParaRemover = null;
        if (alunos.isEmpty()) {
            throw new RuntimeException("O conjunto está vazio!");
        } else {
            for (Aluno aluno : alunos) {
                if (aluno.getMatricula() == matricula) {
                    alunoParaRemover = aluno;
                    break;
                }
            }

            alunos.remove(alunoParaRemover);
        }

        if (alunoParaRemover == null) {
            System.out.println("Matricula não encontrada!");
        }
    }

    public void exibirAlunosPorNome() {
        if (alunos.isEmpty())
            System.out.println("O conjunto está vazio!");
        else
            System.out.println(new TreeSet<>(alunos));
    }

    public void exibirAlunosPorNota() {
        if (alunos.isEmpty()) {
            System.out.println("O conjunto está vazio!");
        } else {
            Set<Aluno> alunosPorNota =  new TreeSet<>(new ComparatorPorNota());
            alunosPorNota.addAll(alunos);
            System.out.println(alunosPorNota);
        }
    }

    public void exibirAlunos() {
        if (alunos.isEmpty())
            System.out.println("O conjunto está vazio!");
        else
            System.out.println(alunos);
    }

    public static void main(String[] args) {
        GerenciadorAluno gerenciadorAluno = new GerenciadorAluno();

        gerenciadorAluno.adicionarAluno("João", 123456L, 7.5);
        gerenciadorAluno.adicionarAluno("Maria", 123457L, 9.0);
        gerenciadorAluno.adicionarAluno("Carlos", 123458L, 5.0);
        gerenciadorAluno.adicionarAluno("Ana", 123459L, 6.8);

        System.out.println("Alunos no gerenciador:");
        gerenciadorAluno.exibirAlunos();

        gerenciadorAluno.removerAluno(000L);
        gerenciadorAluno.removerAluno(123457L);
        gerenciadorAluno.exibirAlunos();

        gerenciadorAluno.exibirAlunosPorNome();

        gerenciadorAluno.exibirAlunosPorNota();
    }

}
