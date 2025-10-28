package org.example.tp1.e3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

final class Carrinho {
    private final List<Item> itens = new ArrayList<>();
    void adicionar(Item item) { itens.add(Objects.requireNonNull(item)); }
    BigDecimal recuperarTotal() {
        return itens.stream().map(Item::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    List<Item> getItens() { return Collections.unmodifiableList(itens); }
}