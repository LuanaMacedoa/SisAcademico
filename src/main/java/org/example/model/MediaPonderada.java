package org.example.model;

import java.util.List;

public class MediaPonderada implements EstrategiaAvaliacao {
    private static final double MEDIA_MINIMA = 60.0;
    private static final int MINIMO_NOTAS = 3;

    @Override
    public double calcularMedia(List<Double> notas) {
        if (notas.isEmpty()) {
            return 0.0;
        }
        
        double somaNotas = 0.0;
        double somaPesos = 0.0;
        
        for (int i = 0; i < notas.size(); i++) {
            double peso = 1.0;
            if (i == notas.size() - 1) {
                peso = 3.0;
            } else if (i == notas.size() - 2) {
                peso = 2.0;
            }
            somaNotas += notas.get(i) * peso;
            somaPesos += peso;
        }
        
        return somaNotas / somaPesos;
    }

    @Override
    public boolean aprovar(double media) {
        return media >= MEDIA_MINIMA;
    }

    @Override
    public String getDescricao() {
        return "Média Ponderada (mín. " + MEDIA_MINIMA + ", últimas notas têm maior peso)";
    }

    @Override
    public int getNumeroMinimoNotas() {
        return MINIMO_NOTAS;
    }
}
