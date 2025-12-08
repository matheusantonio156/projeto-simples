package com.projeto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.projeto.historico.HistoricoService;

class HistoricoServiceTest {

    private HistoricoService service;

    @BeforeEach
    void setup() {
        service = Mockito.spy(new HistoricoService());
    }

    @Test
    void deveRegistrarAcao() {
        service.registrarAcao("Login");

        verify(service, times(1)).registrarAcao("Login");
        assertTrue(service.contemAcao("Login"));
    }

    @Test
    void naoDeveRegistrarAcaoInvalida() {
        service.registrarAcao(null);
        service.registrarAcao("");
        service.registrarAcao("   ");

        verify(service, times(1)).registrarAcao(null);
        verify(service, times(1)).registrarAcao("");
        verify(service, times(1)).registrarAcao("   ");

        assertEquals(0, service.totalAcoes());
    }

    @Test
    void deveVerificarSeAcaoExiste() {
        service.registrarAcao("Buscar");

        verify(service).registrarAcao("Buscar");
        assertTrue(service.contemAcao("Buscar"));
        assertFalse(service.contemAcao("Excluir"));
    }
}
