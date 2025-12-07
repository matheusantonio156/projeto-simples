package com.projeto.frete;

import org.springframework.stereotype.Service;

@Service
public class FreteService {

    public double calcularFrete(double distanciaKm) {
        if (distanciaKm < 0) throw new IllegalArgumentException("Distância inválida");
        return distanciaKm * 2.50;
    }

    public boolean freteGratis(double valorCompra) {
        return valorCompra >= 200;
    }
}
