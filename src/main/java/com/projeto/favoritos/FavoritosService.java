package com.projeto.favoritos;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FavoritosService {

    private final List<String> favoritos = new ArrayList<>();

    public void adicionarFavorito(String item) {
        if (item != null && !item.isBlank() && !favoritos.contains(item)) {
            favoritos.add(item);
        }
    }

    public boolean estaNosFavoritos(String item) {
        return favoritos.contains(item);
    }

    public int quantidadeFavoritos() {
        return favoritos.size();
    }
}
