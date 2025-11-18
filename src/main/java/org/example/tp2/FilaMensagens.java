package org.example.tp2;

import java.util.LinkedList;
import java.util.Queue;

public class FilaMensagens {
    private Queue<String> mensagens = new LinkedList<>();

    public String visualizarProximaMensagem() {
        return mensagens.peek();
    }

    public String removerProximaMensagem() {
        return mensagens.poll();
    }
}