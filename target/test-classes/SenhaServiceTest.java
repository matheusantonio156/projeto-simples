package com.projeto.senha;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({ MockitoExtension.class })
class SenhaServiceTest {

    @InjectMocks
    private SenhaService senhaService;

    SenhaServiceTest() {
    }

    @Test
    void deveValidarSenhaForte() {
        boolean resultado = this.senhaService.senhaForte("Senha@123");
        Assertions.assertEquals(true, resultado);
    }

    @Test
    void deveRejeitarSenhaFraca() {
        boolean resultado = this.senhaService.senhaForte("123");
        Assertions.assertEquals(false, resultado);
    }

    @Test
    void deveCriptografarSenhaCorretamente() {
        String resultado = this.senhaService.criptografarSenha("minhasenha");
        Assertions.assertNotNull(resultado);
    }
}
