package com.learn.map.ordenacao;

import java.util.Comparator;
import java.util.Map;

public class Livro {

    private String titulo;
    private String autor;
    private Double preco;

    public Livro(String titulo, String autor, Double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", preco=" + preco +
                '}';
    }

}

class ComparatorPorPreco implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> entry1, Map.Entry<String, Livro> entry2) {
        return Double.compare(entry1.getValue().getPreco(), entry2.getValue().getPreco());
    }

}

class ComparatorPorAutor implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> entry1, Map.Entry<String, Livro> entry2) {
        return entry1.getValue().getAutor().compareToIgnoreCase(entry2.getValue().getAutor());
    }

}
