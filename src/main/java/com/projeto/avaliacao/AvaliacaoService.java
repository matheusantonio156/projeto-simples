package com.projeto.avaliacao;

import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {

    public double calcularMedia(double[] notas) {
        if (notas == null || notas.length == 0) return 0;

        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    public boolean avaliacaoValida(int estrelas) {
        return estrelas >= 1 && estrelas <= 5;
    }
}
