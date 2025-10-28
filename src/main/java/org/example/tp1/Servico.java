package org.example.tp1;

class Servico {
    public void processar(String dado) {
        if (dado == null) {
            throw new IllegalArgumentException("dado não pode ser nulo");
        }
        System.out.println("Processando: " + dado.toUpperCase());
    }
}
