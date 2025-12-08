package com.projeto.encomenda;

import org.springframework.stereotype.Service;

@Service
public class EncomendaService {

    public String gerarCodigoRastreio(String prefixo, int numero) {
        return prefixo.toUpperCase() + "-" + numero;
    }

    public boolean encomendaEntregue(boolean status) {
        return status;
    }
}
