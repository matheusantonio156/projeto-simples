package com.projeto.historico;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistoricoService {

    private final List<String> historico = new ArrayList<>();

    public void registrarAcao(String acao) {
        if (acao != null && !acao.isBlank()) {
            historico.add(acao);
        }
    }

    public int totalAcoes() {
        return historico.size();
    }

    public boolean contemAcao(String acao) {
        return historico.contains(acao);
    }
}
