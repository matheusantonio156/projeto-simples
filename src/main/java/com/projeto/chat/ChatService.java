package com.projeto.chat;

import org.springframework.stereotype.Service;

@Service
public class ChatService {

    public String gerarRespostaAutomatica(String mensagem) {
        if (mensagem == null || mensagem.isBlank()) {
            return "Não entendi sua mensagem.";
        }

        if (mensagem.toLowerCase().contains("ola") || mensagem.toLowerCase().contains("oi")) {
            return "Olá! Como posso ajudar?";
        }

        return "Mensagem recebida!";
    }

    public boolean mensagemValida(String mensagem) {
        return mensagem != null && mensagem.length() > 3;
    }
}
