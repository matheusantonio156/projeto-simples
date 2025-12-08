package com.projeto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.projeto.avaliacao.AvaliacaoServiceTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AvaliacaoServiceTest {

    private AvaliacaoService avaliacaoService = Mockito.spy(new AvaliacaoService());

    // ----------------------------------------
    // Testes do método calcularMedia()
    // ----------------------------------------

    @Test
    void deveCalcularMediaCorretamente() {
        System.out.println("🔍 Testando cálculo da média com notas válidas...");

        double[] notas = {8.0, 6.0, 10.0};
        double media = avaliacaoService.calcularMedia(notas);

        System.out.println("➡ Entrada: notas = [8.0, 6.0, 10.0]");
        System.out.println("✔ Média: " + media);

        assertEquals((8.0 + 6.0 + 10.0) / 3.0, media);

        System.out.println("✅ Teste passou!\n");
    }

    @Test
    void deveRetornarZeroQuandoArrayNulo() {
        System.out.println("🔍 Testando média com array nulo...");

        double media = avaliacaoService.calcularMedia(null);

        System.out.println("➡ Entrada: notas = null");
        System.out.println("✔ Média: " + media);

        assertEquals(0.0, media);

        System.out.println("✅ Teste passou!\n");
    }

    @Test
    void deveRetornarZeroQuandoArrayVazio() {
        System.out.println("🔍 Testando média com array vazio...");

        double[] notas = new double[0];
        double media = avaliacaoService.calcularMedia(notas);

        System.out.println("➡ Entrada: notas = []");
        System.out.println("✔ Média: " + media);

        assertEquals(0.0, media);

        System.out.println("✅ Teste passou!\n");
    }

    @Test
    void podeUsarSpyParaStubMedia() {
        System.out.println("🔍 Testando cálculo de média com stub (spy)...");

        double[] dummy = {1.0, 2.0, 3.0};
        when(avaliacaoService.calcularMedia(dummy)).thenReturn(5.0);

        double media = avaliacaoService.calcularMedia(dummy);

        System.out.println("➡ Entrada: notas = [1.0, 2.0, 3.0]");
        System.out.println("✔ Média (stubbed): " + media);

        assertEquals(5.0, media);

        verify(avaliacaoService, times(1)).calcularMedia(dummy);

        System.out.println("✅ Teste passou!\n");
    }

    // ----------------------------------------
    // Testes do método avaliacaoValida()
    // ----------------------------------------

    @Test
    void deveRetornarTrueParaEstrelasValidas() {
        System.out.println("🔍 Testando avaliação válida (1 a 5)...");

        assertTrue(avaliacaoService.avaliacaoValida(1));
        assertTrue(avaliacaoService.avaliacaoValida(5));
        assertTrue(avaliacaoService.avaliacaoValida(3));

        System.out.println("✔ Estrelas: 1, 3, 5 → válidas");
        System.out.println("✅ Teste passou!\n");
    }

    @Test
    void deveRetornarFalseParaEstrelasInvalidas() {
        System.out.println("🔍 Testando avaliação inválida (fora de 1 a 5)...");

        assertFalse(avaliacaoService.avaliacaoValida(0));
        assertFalse(avaliacaoService.avaliacaoValida(6));
        assertFalse(avaliacaoService.avaliacaoValida(-1));

        System.out.println("✔ Estrelas: 0, 6, -1 → inválidas");
        System.out.println("✅ Teste passou!\n");
    }

    @Test
    void podeUsarSpyParaStubAvaliacaoValida() {
        System.out.println("🔍 Testando stub da validação de avaliação com spy...");

        when(avaliacaoService.avaliacaoValida(10)).thenReturn(false);

        boolean valido = avaliacaoService.avaliacaoValida(10);

        System.out.println("➡ Entrada: estrelas = 10");
        System.out.println("✔ Retorno (stubbed): " + valido);

        assertFalse(valido);

        verify(avaliacaoService, times(1)).avaliacaoValida(10);

        System.out.println("✅ Teste passou!\n");
    }
}
