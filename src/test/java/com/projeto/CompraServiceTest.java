package com.projeto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.projeto.compra.CompraServiceTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompraServiceTest {

    // Spy permite rodar método real, mas monitorando chamadas
    private CompraService compraService = Mockito.spy(new CompraService());

    // -------------------------------
    // Testes do método calcularTotal()
    // -------------------------------

    @Test
    void deveCalcularTotalCorretamente() {
        System.out.println("🔍 Testando cálculo do total...");

        when(compraService.calcularTotal(50.0, 4)).thenReturn(200.0);

        double resultado = compraService.calcularTotal(50.0, 4);

        System.out.println("➡ Entrada: preço = 50.0, quantidade = 4");
        System.out.println("✔ Resultado: " + resultado);

        assertEquals(200.0, resultado);

        verify(compraService, times(1)).calcularTotal(50.0, 4);

        System.out.println("✅ Teste passou!\n");
    }

    @Test
    void deveRetornarZeroQuandoQuantidadeZero() {
        System.out.println("🔍 Testando cálculo com quantidade zero...");

        double resultado = compraService.calcularTotal(100.0, 0);

        System.out.println("➡ Entrada: preço = 100.0, quantidade = 0");
        System.out.println("✔ Resultado: " + resultado);

        assertEquals(0.0, resultado);

        System.out.println("✅ Teste passou!\n");
    }

    @Test
    void deveLancarExcecaoQuandoPrecoNegativo() {
        System.out.println("🔍 Testando exceção com preço negativo...");

        assertThrows(IllegalArgumentException.class, () -> {
            compraService.calcularTotal(-10.0, 5);
        });

        System.out.println("✔ Exceção lançada corretamente");
        System.out.println("✅ Teste passou!\n");
    }

    @Test
    void deveLancarExcecaoQuandoQuantidadeNegativa() {
        System.out.println("🔍 Testando exceção com quantidade negativa...");

        assertThrows(IllegalArgumentException.class, () -> {
            compraService.calcularTotal(10.0, -5);
        });

        System.out.println("✔ Exceção lançada corretamente");
        System.out.println("✅ Teste passou!\n");
    }

    // ----------------------------------------
    // Testes do método compraElegivelDesconto()
    // ----------------------------------------

    @Test
    void deveRetornarTrueQuandoElegivelAoDesconto() {
        System.out.println("🔍 Testando elegibilidade ao desconto...");

        when(compraService.compraElegivelDesconto(350.0)).thenReturn(true);

        boolean elegivel = compraService.compraElegivelDesconto(350.0);

        System.out.println("➡ Total = 350.0");
        System.out.println("✔ Elegível: " + elegivel);

        assertTrue(elegivel);

        verify(compraService, times(1)).compraElegivelDesconto(350.0);

        System.out.println("✅ Teste passou!\n");
    }

    @Test
    void deveRetornarFalseQuandoNaoElegivel() {
        System.out.println("🔍 Testando não elegibilidade ao desconto...");

        boolean elegivel = compraService.compraElegivelDesconto(200.0);

        System.out.println("➡ Total = 200.0");
        System.out.println("✔ Elegível: " + elegivel);

        assertFalse(elegivel);

        System.out.println("✅ Teste passou!\n");
    }

    @Test
    void deveRetornarTrueQuandoIgual300() {
        System.out.println("🔍 Testando limite de desconto (300)...");

        boolean elegivel = compraService.compraElegivelDesconto(300.0);

        System.out.println("➡ Total = 300.0");
        System.out.println("✔ Elegível: " + elegivel);

        assertTrue(elegivel);

        System.out.println("✅ Teste passou!\n");
    }
}
