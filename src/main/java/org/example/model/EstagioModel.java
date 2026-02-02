package org.example.model;

import lombok.Data;

@Data
public class EstagioModel {
    private static final double MEDIA_MINIMA = 70.0;
    
    private String nome;
    private String descricao;
    private double media = 0.0;

    public EstagioModel(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public boolean informarMedia(double media) {
        if (media < 0 || media > 100) {
            return false;
        }
        this.media = media;
        return true;
    }

    public boolean aprovado() {
        return media >= MEDIA_MINIMA;
    }

    public double getMediaMinima() {
        return MEDIA_MINIMA;
    }

    @Override
    public String toString() {
        return "Estágio:" + nome + " (Descrição: " + descricao + ")";
    }
}
