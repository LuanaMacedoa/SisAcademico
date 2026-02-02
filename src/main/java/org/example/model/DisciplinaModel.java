package org.example.model;

import lombok.Data;

@Data
public class DisciplinaModel {
    private String nome;
    private int cargaHoraria;
    private long codigo;

    public DisciplinaModel(String nome, int cargaHoraria, long codigo) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Disciplina: " + nome + "/" + cargaHoraria + "h (Cód - " + codigo + ")";
    }
}
