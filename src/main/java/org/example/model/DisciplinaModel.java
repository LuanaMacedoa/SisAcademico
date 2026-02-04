package org.example.model;

import lombok.Data;

@Data
public class DisciplinaModel {
    private String nome;
    private int cargaHoraria;
    private long codigo;
    private ProfessorModel professor;
    private Modalidade modalidade;
    private EstrategiaAvaliacao estrategiaAvaliacao;

    public DisciplinaModel(String nome, int cargaHoraria, long codigo, Modalidade modalidade, EstrategiaAvaliacao estrategiaAvaliacao) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
        this.professor = null;
        this.modalidade = modalidade;
        this.estrategiaAvaliacao = estrategiaAvaliacao;
    }

    @Override
    public String toString() {
        String professorInfo = (professor != null) ? " | Professor: " + professor.getNome() : " | Professor: Não atribuído";
        String modalidadeInfo = " | Modalidade: " + modalidade.getDescricao();
        String avaliacaoInfo = " | Avaliação: " + estrategiaAvaliacao.getDescricao();
        return "Disciplina: " + nome + "/" + cargaHoraria + "h (Cód - " + codigo + ")" + professorInfo + modalidadeInfo + avaliacaoInfo;
    }
}
