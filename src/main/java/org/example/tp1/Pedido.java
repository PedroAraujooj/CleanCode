package org.example.tp1;

/**
 * Representa um pedido simples com identidade, descrição e valor total.
 */
final class Pedido {
    private final int id;
    private final String descricao;
    private final double valor;

    public Pedido(int id, String descricao, double valor) {
        if (id <= 0) throw new IllegalArgumentException("Id deve ser positivo");
        if (descricao == null || descricao.isBlank()) throw new IllegalArgumentException("Descrição obrigatória");
        if (valor < 0) throw new IllegalArgumentException("Valor não pode ser negativo");
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public double getValor() { return valor; }

    @Override public String toString() {
        return "Pedido{id=" + id + ", descricao='" + descricao + "', valor=" + valor + "}";
    }
}
