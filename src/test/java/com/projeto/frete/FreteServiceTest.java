package com.projeto.frete;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FreteServiceTest {

    FreteService service = new FreteService();

    @Test
    void deveCalcularFreteCorretamente() {
        double resultado = service.calcularFrete(10);
        assertEquals(25.0, resultado);
    }

    @Test
    void deveLancarErroParaDistanciaNegativa() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.calcularFrete(-5);
        });
    }

    @Test
    void deveRetornarFreteGratisQuandoCompraMaiorOuIgual200() {
        assertTrue(service.freteGratis(200));
        assertTrue(service.freteGratis(250));
    }

    @Test
    void deveRetornarFreteNaoGratisQuandoCompraMenorQue200() {
        assertFalse(service.freteGratis(199.90));
    }
}
