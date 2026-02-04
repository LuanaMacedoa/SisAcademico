package org.example.model;

import lombok.Data;

@Data
public class DisciplinaModel {
    private String nome;
    private int cargaHoraria;
    private long codigo;
    private ProfessorModel professor;

    public DisciplinaModel(String nome, int cargaHoraria, long codigo) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
        this.professor = null;
    }

    @Override
    public String toString() {
        String professorInfo = (professor != null) ? " | Professor: " + professor.getNome() : " | Professor: Não atribuído";
        return "Disciplina: " + nome + "/" + cargaHoraria + "h (Cód - " + codigo + ")" + professorInfo;
    }
}
