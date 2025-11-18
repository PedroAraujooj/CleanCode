package org.example.tp2;

enum TipoNotificacao {
    EMAIL,
    SMS,
    PUSH
}

public class NotificacaoService {
    public void enviarNotificacao(TipoNotificacao tipo) {
        switch (tipo) {
            case EMAIL:
                System.out.println("Enviando e-mail...");
                break;
            case SMS:
                System.out.println("Enviando SMS...");
                break;
            case PUSH:
                System.out.println("Enviando notificação push...");
                break;
        }
    }
}