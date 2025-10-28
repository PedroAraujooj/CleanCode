package org.example.tp1.e3;


import java.math.BigDecimal;

final class Item {
    private final String nome;
    private final BigDecimal preco;
    private final int quantidade;

    Item(String nome, BigDecimal preco, int quantidade) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome obrigatório");
        if (preco == null || preco.signum() < 0) throw new IllegalArgumentException("Preço inválido");
        if (quantidade <= 0) throw new IllegalArgumentException("Quantidade deve ser > 0");
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    BigDecimal getSubtotal() { return preco.multiply(BigDecimal.valueOf(quantidade)); }
    String getNome() { return nome; }
    BigDecimal getPreco() { return preco; }
    int getQuantidade() { return quantidade; }
}
