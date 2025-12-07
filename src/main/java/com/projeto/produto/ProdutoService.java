package com.projeto.produto;

public class ProdutoService {

    public double calcularPrecoComDesconto(double preco, double descontoPercentual) {
        if (preco < 0 || descontoPercentual < 0) {
            throw new IllegalArgumentException("Valores inválidos");
        }
        return preco - (preco * (descontoPercentual / 100));
    }

    public boolean estoqueDisponivel(int quantidade) {
        return quantidade > 0;
    }

    public String formatarNomeProduto(String nome) {
        return nome == null ? "" : nome.trim().toUpperCase();
    }
}
