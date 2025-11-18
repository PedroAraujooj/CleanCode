package org.example.tp2;


public class Ajuste {
    private static final double DESCONTO_PADRAO = 10.0;

    public Produto aplicarDesconto(Produto produto) {
        return produto.getNovoProdutoComDesconto(DESCONTO_PADRAO);
    }
}
class Produto {
    private final double preco;

    public Produto(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public Produto getNovoProdutoComDesconto(double valorDesconto) {
        return new Produto(this.preco - valorDesconto);
    }
}