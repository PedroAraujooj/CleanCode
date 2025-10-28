package org.example.tp1.e5;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ContaRepository {
    private final Map<String, Conta> contas = new HashMap<>();
    void salvar(Conta c) { contas.put(c.getTitular(), c); }
    Optional<Conta> getByTitular(String t) { return Optional.ofNullable(contas.get(t)); }
}