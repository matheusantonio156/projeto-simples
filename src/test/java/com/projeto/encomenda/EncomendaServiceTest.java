package com.projeto.encomenda;

import org.junit.jupiter.api.Test;

import com.projeto.encomenda.EncomendaService;

import static org.junit.jupiter.api.Assertions.*;

public class EncomendaServiceTest {

    EncomendaService service = new EncomendaService();

    @Test
    void deveGerarCodigoRastreioCorretamente() {
        String codigo = service.gerarCodigoRastreio("abc", 123);
        assertEquals("ABC-123", codigo);
    }

    @Test
    void deveManterStatusDeEntrega() {
        assertTrue(service.encomendaEntregue(true));
        assertFalse(service.encomendaEntregue(false));
    }
}
