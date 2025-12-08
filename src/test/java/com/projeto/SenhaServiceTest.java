package com.projeto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import com.projeto.senha.SenhaService;

@ExtendWith(MockitoExtension.class)
class SenhaServiceTest {

    @InjectMocks
    private SenhaService senhaService;

    @Test
    void deveValidarSenhaCorreta() {
        boolean resultado = senhaService.validarSenha("Senha123");
        Assertions.assertTrue(resultado);
    }

    @Test
    void deveRejeitarSenhaCurta() {
        boolean resultado = senhaService.validarSenha("Sen1");
        Assertions.assertFalse(resultado);
    }

    @Test
    void deveRejeitarSenhaSemNumero() {
        boolean resultado = senhaService.validarSenha("Senhaaaa");
        Assertions.assertFalse(resultado);
    }

    @Test
    void deveRejeitarSenhaSemMaiuscula() {
        boolean resultado = senhaService.validarSenha("senha123");
        Assertions.assertFalse(resultado);
    }

    @Test
    void deveRejeitarSenhaNula() {
        boolean resultado = senhaService.validarSenha(null);
        Assertions.assertFalse(resultado);
    }
}
