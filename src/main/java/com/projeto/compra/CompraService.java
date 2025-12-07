package com.projeto.compra;

import org.springframework.stereotype.Service;

@Service
public class CompraService {

    public double calcularTotal(double preco, int quantidade) {
        if (preco < 0 || quantidade < 0) {
            throw new IllegalArgumentException("Valores inválidos");
        }
        return preco * quantidade;
    }

    public boolean compraElegivelDesconto(double total) {
        return total >= 300;
    }
}
