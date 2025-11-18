package org.example.tp2;

public class Desconto {

    private static final double VALOR_MINIMO_PARA_DESCONTO = 1000.0;
    private static final double PERCENTUAL_DESCONTO = 0.10;

    public double calcular(double preco) {
        if (preco >= VALOR_MINIMO_PARA_DESCONTO) {
            return preco * (1 - PERCENTUAL_DESCONTO);
        }
        return preco;
    }
}