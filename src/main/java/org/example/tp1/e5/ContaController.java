package org.example.tp1.e5;

import java.math.BigDecimal;

public class ContaController {
    private final ContaService service;
    ContaController(ContaService service) { this.service = service; }

    void criar(String t, BigDecimal s) {
        try { service.criarConta(t, s); System.out.println("Conta criada."); }
        catch (RuntimeException e) { System.out.println("Erro: " + e.getMessage()); }
    }
    void transferir(String origem, String destino, BigDecimal v) {
        try { service.transferir(origem, destino, v); System.out.println("Transferência OK."); }
        catch (RuntimeException e) { System.out.println("Erro: " + e.getMessage()); }
    }
}