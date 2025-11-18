package org.example.tp2;

public class Pedido {
    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.cliente = (cliente != null) ? cliente : new ClienteNulo();
    }

    public String getNomeCliente() {
        return cliente.getNome();
    }
}

interface Cliente {
    String getNome();
}

class ClienteReal implements Cliente {
    private final String nome;

    public ClienteReal(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }
}

class ClienteNulo implements Cliente {
    @Override
    public String getNome() {
        return "Cliente não informado";
    }
}