package org.example.tp2;

public class Monitoramento {
    private int contadorAcessos = 0;

    public void registrarAcesso() {
        contadorAcessos++;
    }

    public int getContadorAcessos() {
        return contadorAcessos;
    }
}