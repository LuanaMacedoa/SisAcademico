package org.example.model;

import java.util.List;

public class MediaSimples implements EstrategiaAvaliacao {
    private static final double MEDIA_MINIMA = 70.0;
    private static final int MINIMO_NOTAS = 2;

    @Override
    public double calcularMedia(List<Double> notas) {
        if (notas.isEmpty()) {
            return 0.0;
        }
        double soma = notas.stream().mapToDouble(Double::doubleValue).sum();
        return soma / notas.size();
    }

    @Override
    public boolean aprovar(double media) {
        return media >= MEDIA_MINIMA;
    }

    @Override
    public String getDescricao() {
        return "Média Simples (mín. " + MEDIA_MINIMA + ")";
    }

    @Override
    public int getNumeroMinimoNotas() {
        return MINIMO_NOTAS;
    }
}
