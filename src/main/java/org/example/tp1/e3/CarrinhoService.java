package org.example.tp1.e3;

import java.math.BigDecimal;

final class CarrinhoService {
    private final Carrinho carrinho;
    private final TotalPresenter presenter;
    CarrinhoService(Carrinho carrinho, TotalPresenter presenter) {
        this.carrinho = carrinho; this.presenter = presenter;
    }
    void cadastrarItem(String nome, BigDecimal preco, int quantidade) {
        carrinho.adicionar(new Item(nome, preco, quantidade));
    }
    void exibirTotal() {
        presenter.apresentar(carrinho.recuperarTotal(), carrinho.getItens());
    }
}