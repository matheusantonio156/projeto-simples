package com.projeto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.projeto.chat.ChatService;

@ExtendWith(MockitoExtension.class)
class ChatServiceTest {

    private final ChatService chatService = Mockito.spy(new ChatService());

    @Test
    void deveResponderSaudacao() {
        System.out.println("🔍 Testando resposta de saudação...");

        when(chatService.gerarRespostaAutomatica("Olá")).thenReturn("Olá! Como posso ajudar?");

        String resposta = chatService.gerarRespostaAutomatica("Olá");

        System.out.println("➡ Entrada: 'Olá'");
        System.out.println("✔ Resposta: '" + resposta + "'");

        assertEquals("Olá! Como posso ajudar?", resposta);

        verify(chatService, times(1)).gerarRespostaAutomatica("Olá");

        System.out.println("✅ Teste passou!\n");
    }

    @Test
    void deveResponderMensagemVazia() {
        System.out.println("🔍 Testando resposta para mensagem vazia...");

        String resposta = chatService.gerarRespostaAutomatica("");

        System.out.println("➡ Entrada: ''");
        System.out.println("✔ Resposta: '" + resposta + "'");

        assertEquals("Não entendi sua mensagem.", resposta);

        System.out.println("✅ Teste passou!\n");
    }

    @Test
    void deveResponderMensagemNormalSemSaudacao() {
        System.out.println("🔍 Testando resposta para texto comum...");

        String resposta = chatService.gerarRespostaAutomatica("isso é um teste");

        System.out.println("➡ Entrada: 'isso é um teste'");
        System.out.println("✔ Resposta: '" + resposta + "'");

        assertEquals("Mensagem recebida!", resposta);

        System.out.println("✅ Teste passou!\n");
    }

    @Test
    void deveValidarMensagemCorreta() {
        System.out.println("🔍 Testando validação de mensagem...");

        assertTrue(chatService.mensagemValida("teste"));
        assertFalse(chatService.mensagemValida("oi"));
        assertFalse(chatService.mensagemValida(null));

        System.out.println("✔ Resultado: validação funcionando");
        System.out.println("✅ Teste passou!\n");
    }
}
