package org.example.tp1.e5;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

public class ContaService {
    private final ContaRepository repo;
    ContaService(ContaRepository repo) { this.repo = repo; }

    void criarConta(String titular, BigDecimal saldoInicial) {
        if (repo.getByTitular(titular).isPresent()) throw new IllegalArgumentException("Conta já existe");
        repo.salvar(new Conta(titular, saldoInicial));
    }

    void transferir(String origem, String destino, BigDecimal valor) {
        Conta o = repo.getByTitular(origem).orElseThrow(() -> new NoSuchElementException("Origem inexistente"));
        Conta d = repo.getByTitular(destino).orElseThrow(() -> new NoSuchElementException("Destino inexistente"));
        o.debitar(valor);
        d.creditar(valor);
    }
}