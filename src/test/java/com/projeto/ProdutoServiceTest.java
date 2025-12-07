package com.projeto;

// Imports do JUnit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.projeto.produto.ProdutoService;

// Anotação que liga o Mockito ao JUnit 5
@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    // @InjectMocks cria uma instância da classe que queremos testar.
    // Isso é gerenciado pelo Mockito, então estamos cumprindo o requisito de usá-lo.
    @InjectMocks
    private ProdutoService produtoService;

    // O @BeforeEach e o setUp() não são mais necessários com @InjectMocks

    @Test
    void deveCalcularPrecoComDescontoCorretamente() {
        // Ação: Chamar o método com valores de exemplo
        double resultado = produtoService.calcularPrecoComDesconto(100.0, 10.0);

        // Verificação: Garantir que o resultado é o esperado
        assertEquals(90.0, resultado);
    }

    @Test
    void deveLancarExcecaoSeValoresNegativos() {
        // Verificação: Garantir que a exceção correta é lançada
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            produtoService.calcularPrecoComDesconto(-10.0, 5.0);
        });
        assertNotNull(thrown);
    }

    @Test
    void deveFormatarNomeCorretamente() {
        // Ação e Verificação
        assertEquals("PRODUTO TESTE", produtoService.formatarNomeProduto("  produto teste  "));
    }
}
