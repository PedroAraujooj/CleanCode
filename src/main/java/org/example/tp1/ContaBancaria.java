package org.example.tp1;

final class ContaBancaria {
    private final String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldoInicial) {
        if (titular == null || titular.isBlank()) throw new IllegalArgumentException("Titular obrigatório");
        if (saldoInicial < 0) throw new IllegalArgumentException("Saldo inicial não pode ser negativo");
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Depósito deve ser > 0");
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Saque deve ser > 0");
        if (valor > saldo) throw new IllegalStateException("Saldo insuficiente");
        saldo -= valor;
    }

    public double getSaldo() { return saldo; }
    public String getTitular() { return titular; }
}
