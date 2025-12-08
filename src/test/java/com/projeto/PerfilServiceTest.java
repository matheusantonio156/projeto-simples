package com.projeto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import com.projeto.perfil.PerfilService;

@ExtendWith({ MockitoExtension.class })
class PerfilServiceTest {

    @InjectMocks
    private PerfilService perfilService;

    PerfilServiceTest() {
    }

    @Test
    void deveGerarNomeDeExibicaoCorretamente() {
        String resultado = this.perfilService.gerarNomeExibicao("Jorge", "Silva");
        Assertions.assertEquals("Jorge Silva", resultado);
    }

    @Test
    void deveRemoverEspacosExtras() {
        String resultado = this.perfilService.gerarNomeExibicao("Jorge", "   ");
        Assertions.assertEquals("Jorge", resultado);
    }

    @Test
    void deveValidarIdadeCorretamente() {
        boolean resultado = this.perfilService.idadeValida(18);
        Assertions.assertEquals(true, resultado);
    }

    @Test
    void deveRejeitarIdadeInvalida() {
        boolean resultado = this.perfilService.idadeValida(10);
        Assertions.assertEquals(false, resultado);
    }
}
