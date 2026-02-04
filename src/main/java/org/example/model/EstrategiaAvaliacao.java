package org.example.model;

import java.util.List;

public interface EstrategiaAvaliacao {
    double calcularMedia(List<Double> notas);
    boolean aprovar(double media);
    String getDescricao();
    int getNumeroMinimoNotas();
}
