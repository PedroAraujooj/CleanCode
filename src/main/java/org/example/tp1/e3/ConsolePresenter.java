package org.example.tp1.e3;

import java.math.BigDecimal;
import java.util.List;

final class ConsolePresenter implements TotalPresenter {
    @Override public void apresentar(BigDecimal total, List<Item> itens) {
        System.out.println("=== Itens ===");
        for (Item i : itens) {
            System.out.printf("- %s x%d: R$ %s%n", i.getNome(), i.getQuantidade(), i.getPreco());
        }
        System.out.println("Total da compra: R$ " + total);
    }
}
