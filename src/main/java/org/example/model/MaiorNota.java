package org.example.model;

import java.util.List;

public class MaiorNota implements EstrategiaAvaliacao {
    private static final double MEDIA_MINIMA = 80.0;
    private static final int MINIMO_NOTAS = 2;

    @Override
    public double calcularMedia(List<Double> notas) {
        return notas.stream()
                .mapToDouble(Double::doubleValue)
                .max()
                .orElse(0.0);
    }

    @Override
    public boolean aprovar(double media) {
        return media >= MEDIA_MINIMA;
    }

    @Override
    public String getDescricao() {
        return "Maior Nota (mín. " + MEDIA_MINIMA + ", considera apenas a maior nota)";
    }

    @Override
    public int getNumeroMinimoNotas() {
        return MINIMO_NOTAS;
    }
}
