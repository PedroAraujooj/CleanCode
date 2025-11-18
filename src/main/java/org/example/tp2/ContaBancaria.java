package org.example.tp2;

public class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public boolean podeComprar(double valor) {
        return saldo >= valor;
    }
    public void debitar(double valor) {
        if (!podeComprar(valor)) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        saldo -= valor;
    }
}
