package org.example.tp1.e5;

import java.math.BigDecimal;

public class Conta {
    private final String titular;
    private BigDecimal saldo;

    Conta(String titular, BigDecimal saldoInicial) {
        if (titular == null || titular.isBlank()) throw new IllegalArgumentException("Titular obrigatório");
        if (saldoInicial == null || saldoInicial.signum() < 0) throw new IllegalArgumentException("Saldo inicial inválido");
        this.titular = titular;
        this.saldo = saldoInicial;
    }
    String getTitular() { return titular; }
    BigDecimal getSaldo() { return saldo; }
    void debitar(BigDecimal v) {
        if (v.signum() <= 0) throw new IllegalArgumentException("Valor deve ser > 0");
        if (saldo.compareTo(v) < 0) throw new IllegalStateException("Saldo insuficiente");
        saldo = saldo.subtract(v);
    }
    void creditar(BigDecimal v) {
        if (v.signum() <= 0) throw new IllegalArgumentException("Valor deve ser > 0");
        saldo = saldo.add(v);
    }
}
