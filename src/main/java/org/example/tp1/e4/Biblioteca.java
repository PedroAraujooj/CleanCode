package org.example.tp1.e4;

import java.util.HashMap;
import java.util.Map;


final class Biblioteca {
    private final Map<String, Livro> acervo = new HashMap<>();

    void adicionar(Livro livro) {
        if (acervo.containsKey(livro.getTitulo())) throw new IllegalArgumentException("Livro já existe");
        acervo.put(livro.getTitulo(), livro);
    }
    boolean emprestar(String titulo) {
        Livro l = acervo.get(titulo);
        if (l == null) return false;
        try { l.emprestar(); return true; }
        catch (IllegalStateException e) { return false; }
    }
    boolean devolver(String titulo) {
        Livro l = acervo.get(titulo);
        if (l == null) return false;
        l.devolver(); return true;
    }
}

