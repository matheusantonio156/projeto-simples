package com.projeto.senha;

import org.springframework.stereotype.Service;

@Service
public class SenhaService {

    public boolean validarSenha(String senha) {
        if (senha == null) return false;

        return senha.length() >= 8 &&
               senha.matches(".*[A-Z].*") &&
               senha.matches(".*[a-z].*") &&
               senha.matches(".*\\d.*");
    }
}
