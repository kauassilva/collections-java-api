package com.learn.map.ordenacao;

import java.util.*;

public class LivrariaOnline {

    private Map<String, Livro> livrariaMap;

    public LivrariaOnline() {
        livrariaMap = new HashMap<>();
    }

    public void adicionarLivro(String link, Livro livro) {
        livrariaMap.put(link, livro);
    }

    public void removerLivro(String titulo) {
        List<String> chavesRemover = new ArrayList<>();

        for (Map.Entry<String, Livro> entry : livrariaMap.entrySet()) {
            if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                chavesRemover.add(entry.getKey());
            }
        }

        for (String chave : chavesRemover) {
            livrariaMap.remove(chave);
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        List<Map.Entry<String, Livro>> livrosParaOrdenar = new ArrayList<>(livrariaMap.entrySet());
        Collections.sort(livrosParaOrdenar, new ComparatorPorPreco());
        Map<String, Livro> livrosOrdenados = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaOrdenar) {
            livrosOrdenados.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenados;
    }


    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        Map<String, Livro> livrosOrdenados = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrariaMap.entrySet()) {
            Livro livro = entry.getValue();

            if (livro.getAutor().equalsIgnoreCase(autor)) {
                livrosOrdenados.put(entry.getKey(), livro);
            }
        }

        return livrosOrdenados;
    }

    public List<Livro> obterLivroMaisCaro() {
        if (livrariaMap.isEmpty()) {
            throw new NoSuchElementException("A livraria está vazia!");
        }

        List<Livro> livrosMaisCaros = new ArrayList<>();
        double precoMaisCaro = Double.MIN_VALUE;

        for (Livro livro : livrariaMap.values()) {
            if (livro.getPreco() > precoMaisCaro) {
                precoMaisCaro = livro.getPreco();
            }
        }

        for (Livro livro : livrariaMap.values()) {
            if (livro.getPreco() == precoMaisCaro) {
                livrosMaisCaros.add(livro);
            }
        }

        return livrosMaisCaros;
    }

    public List<Livro> exibirLivroMaisBarato() {
        if (livrariaMap.isEmpty()) {
            throw new NoSuchElementException("A livraria está vazia!");
        }

        List<Livro> livrosMaisBaratos = new ArrayList<>();
        double precoMaisBarato = Double.MAX_VALUE;

        for (Livro livro : livrariaMap.values()) {
            if (livro.getPreco() < precoMaisBarato) {
                precoMaisBarato = livro.getPreco();
            }
        }

        for (Livro livro : livrariaMap.values()) {
            if (livro.getPreco() == precoMaisBarato) {
                livrosMaisBaratos.add(livro);
            }
        }

        return livrosMaisBaratos;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();
        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", new Livro("1984", "George Orwell", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", new Livro("A Revolução dos Bichos", "George Orwell", 7.05d));
        livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", new Livro("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
        livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", new Livro("Malorie", "Josh Malerman", 5d));
        livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", new Livro("E Não Sobrou Nenhum", "Agatha Christie", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", new Livro("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));

        System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        String autorPesquisa = "Josh Malerman";
        livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa);

        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        System.out.println("Livro mais barato: " + livrariaOnline.exibirLivroMaisBarato());

        livrariaOnline.removerLivro("1984");
        System.out.println(livrariaOnline.livrariaMap);
    }

}
