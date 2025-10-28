package org.example.tp1;

import java.util.List;

final class RelatorioFinanceiro {
    public void gerarRelatorio(List<String> clientes, List<Double> saldos) {
        validarEntradas(clientes, saldos);
        imprimirCabecalho();
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(formatarLinha(clientes.get(i), saldos.get(i)));
        }
        imprimirRodape();
    }

    private void validarEntradas(List<String> clientes, List<Double> saldos) {
        if (clientes == null || saldos == null || clientes.size() != saldos.size())
            throw new IllegalArgumentException("Listas inválidas ou de tamanhos diferentes");
    }
    private void imprimirCabecalho() {
        System.out.println("=== Relatório Financeiro ===");
    }
    private String formatarLinha(String cliente, Double saldo) {
        return String.format("Cliente: %s - Saldo: R$ %.2f", cliente, saldo);
    }
    private void imprimirRodape() {
        System.out.println("===========================");
        System.out.println("Fim do Relatório");
    }
}

