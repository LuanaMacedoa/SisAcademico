package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlunoModel {
    private String nome;
    private long matricula; 

    @Override
    public String toString() {
        return "Aluno: " + nome + " (M - " + matricula + ")";
    }
}
