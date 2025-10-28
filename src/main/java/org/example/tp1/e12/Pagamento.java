package org.example.tp1.e12;

final class Pagamento {
    public void processarPagamento(double valor, String metodo) throws MetodoPagamentoInvalidoException {
        if (valor <= 0) throw new IllegalArgumentException("Valor deve ser > 0");
        switch (String.valueOf(metodo).toLowerCase()) {
            case "cartao" -> System.out.println("Pagamento de R$" + valor + " via cartão.");
            case "boleto" -> System.out.println("Pagamento de R$" + valor + " via boleto.");
            default -> throw new MetodoPagamentoInvalidoException(metodo);
        }
    }
}


