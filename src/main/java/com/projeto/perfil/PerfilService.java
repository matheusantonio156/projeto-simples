package com.projeto.perfil;

import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    public String gerarNomeExibicao(String primeiroNome, String sobrenome) {
        return (primeiroNome + " " + sobrenome).trim();
    }

    public boolean idadeValida(int idade) {
        return idade >= 12;
    }
}
