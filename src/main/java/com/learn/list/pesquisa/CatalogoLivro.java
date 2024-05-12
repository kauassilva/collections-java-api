package com.learn.list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivro {

    private List<Livro> livros;

    public CatalogoLivro() {
        livros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        livros.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();

        if (!livros.isEmpty()) {
            for (Livro livro : livros) {
                if (livro.getAutor().equalsIgnoreCase(autor))
                    livrosPorAutor.add(livro);
            }
        }

        return livrosPorAutor;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> livrosPorIntervaloAnos = new ArrayList<>();

        if (!livros.isEmpty()) {
            for (Livro livro : livros) {
                if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal)
                    livrosPorIntervaloAnos.add(livro);
            }
        }

        return livrosPorIntervaloAnos;
    }

    public Livro pesquisarPorTitulo(String titulo) {
        if (!livros.isEmpty()) {
            for (Livro livro : livros) {
                if (livro.getTitulo().equalsIgnoreCase(titulo))
                    return livro;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CatalogoLivro catalogoLivro = new CatalogoLivro();
        catalogoLivro.adicionarLivro("Livro 1", "Autor 1", 2020);
        catalogoLivro.adicionarLivro("Livro 1", "Autor 2", 2021);
        catalogoLivro.adicionarLivro("Livro 2", "Autor 2", 2022);
        catalogoLivro.adicionarLivro("Livro 3", "Autor 3", 2023);
        catalogoLivro.adicionarLivro("Livro 4", "Autor 4", 1994);

        System.out.println(catalogoLivro.pesquisarPorAutor("Autor 4"));
        System.out.println(catalogoLivro.pesquisarPorIntervaloAnos(2020, 2022));
        System.out.println(catalogoLivro.pesquisarPorTitulo("Livro 1"));
    }

}
