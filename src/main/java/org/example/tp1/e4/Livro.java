package org.example.tp1.e4;

final class Livro {
    private final String titulo;
    private boolean disponivel = true;

    Livro(String titulo) {
        if (titulo == null || titulo.isBlank()) throw new IllegalArgumentException("Título obrigatório");
        this.titulo = titulo;
    }
    String getTitulo() { return titulo; }
    boolean isDisponivel() { return disponivel; }
    void emprestar() {
        if (!isDisponivel()) throw new IllegalStateException("Livro indisponível");
        disponivel = false;
    }
    void devolver() { disponivel = true; }
}
