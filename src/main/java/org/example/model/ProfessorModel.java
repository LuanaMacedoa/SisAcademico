package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfessorModel {
    private String nome;
    private long matricula;

    @Override
    public String toString() {
        return "Professor: " + nome + " (M - " + matricula + ")";
    }
}
