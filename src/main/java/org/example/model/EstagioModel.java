package org.example.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class EstagioModel {
    private static final double MEDIA_MINIMA = 70.0;
    
    private String nome;
    private String descricao;
    private Map<Long, Double> media = new HashMap<>();

    public EstagioModel(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public boolean informarMedia(long matriculaAluno, double valor) {
        if (valor < 0 || valor > 100) {
            return false;
        }
        media.put(matriculaAluno, valor);
        return true;
    }

    public Double obterMedia(long matriculaAluno) {
        return media.get(matriculaAluno);
    }


    public boolean aprovado(long matriculaAluno) {
        Double valor = media.get(matriculaAluno);
        if (valor == null) return false;
        return valor >= MEDIA_MINIMA;
    }

    public double getMediaMinima() {
        return MEDIA_MINIMA;
    }

    @Override
    public String toString() {
        return "Estágio:" + nome + " (Descrição: " + descricao + ")";
    }
}
