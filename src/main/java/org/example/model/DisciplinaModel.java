package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DisciplinaModel {
    private String nome;
    private int cargaHoraria;
    private long codigo;

    @Override
    public String toString() {
        return "Disciplina: " + nome + "/" + cargaHoraria + "h (Cód - " + codigo + ")";
    }
}
