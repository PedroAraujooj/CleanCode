package org.example.tp2;

public class ClienteClassificador {

    public String classificarCliente(int idade, double renda, int compras) {
        if (idade > 60) {
            return classificarSenior(renda, compras);
        } else {
            return classificarJovem(renda, compras);
        }
    }

    private String classificarSenior(double renda, int compras) {
        if (renda > 5000) {
            if (compras > 10) {
                return "Cliente Premium Sênior";
            }
            return "Cliente Regular Sênior";
        }
        return "Cliente Sênior Baixa Renda";
    }

    private String classificarJovem(double renda, int compras) {
        if (renda > 7000) {
            if (compras > 20) {
                return "Cliente Premium Jovem";
            }
            return "Cliente Regular Jovem";
        }
        return "Cliente Jovem Baixa Renda";
    }
}