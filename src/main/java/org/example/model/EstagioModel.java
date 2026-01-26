package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EstagioModel {
    private String nome;
    private String descricao;

    @Override
    public String toString() {
        return "Estágio:" + nome + " (Descrição: " + descricao + ")";
    }
}
