package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfessorModel {
    private String nome;
    private long id;

    @Override
    public String toString() {
        return "Professor: " + nome + " (ID - " + id + ")";
    }
}
