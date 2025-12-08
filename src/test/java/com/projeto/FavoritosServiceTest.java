package com.projeto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.projeto.favoritos.FavoritosService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FavoritosServiceTest {

    private FavoritosService service;

    @BeforeEach
    void setup() {
        service = Mockito.spy(new FavoritosService());
    }

    @Test
    void deveAdicionarItemAosFavoritos() {
        service.adicionarFavorito("Item1");

        verify(service, times(1)).adicionarFavorito("Item1");
        assertTrue(service.estaNosFavoritos("Item1"));
    }

    @Test
    void naoDeveAdicionarItemNuloOuVazio() {
        service.adicionarFavorito(null);
        service.adicionarFavorito("");
        service.adicionarFavorito("   ");

        verify(service, times(1)).adicionarFavorito(null);
        verify(service, times(1)).adicionarFavorito("");
        verify(service, times(1)).adicionarFavorito("   ");

        assertEquals(0, service.quantidadeFavoritos());
    }

    @Test
    void naoDeveAdicionarItemDuplicado() {
        service.adicionarFavorito("Livro");
        service.adicionarFavorito("Livro");

        verify(service, times(2)).adicionarFavorito("Livro");
        assertEquals(1, service.quantidadeFavoritos());
    }

    @Test
    void deveVerificarSeItemEstaNosFavoritos() {
        service.adicionarFavorito("Musica");

        verify(service).adicionarFavorito("Musica");
        assertTrue(service.estaNosFavoritos("Musica"));
    }
}
