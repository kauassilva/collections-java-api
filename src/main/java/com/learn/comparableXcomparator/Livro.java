package com.learn.comparableXcomparator;

import java.util.Comparator;

// Uma classe 'Livro' que implementa Comparable
public class Livro implements Comparable<Livro> {

    private String titulo;
    private String autor;
    private Integer ano;

    public Livro(String titulo, String autor, Integer ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    // Usado para ordenar livros por título
    @Override
    public int compareTo(Livro livro) {
        return titulo.compareTo(livro.titulo);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getAno() {
        return ano;
    }

}

// Classe para comparar Livro por autor
class CompararAutor implements Comparator<Livro> {

    @Override
    public int compare(Livro livro1, Livro livro2) {
        return livro1.getAutor().compareTo(livro2.getAutor());
    }

}

class CompararAno implements Comparator<Livro> {

    @Override
    public int compare(Livro livro1, Livro livro2) {
        return Integer.compare(livro1.getAno(), livro2.getAno());
        /*
        if (livro1.getAno() < livro2.getAno())
            return -1;
        if (livro1.getAno() > livro2.getAno())
            return 1;
        else
            return 0;
         */
    }

}

class CompararAnoAutorTitulo implements Comparator<Livro> {

    @Override
    public int compare(Livro livro1, Livro livro2) {
        int ano = Integer.compare(livro1.getAno(), livro2.getAno());

        if (ano != 0)
            return ano;

        int autor = livro1.getAutor().compareTo(livro2.getAutor());

        if (autor != 0)
            return autor;

        return livro1.getTitulo().compareTo(livro2.getTitulo());
    }

}
