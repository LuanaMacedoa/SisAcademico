package org.example.controller;

import org.example.model.DisciplinaModel;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaController {
    private List<DisciplinaModel> disciplinas = new ArrayList<>();


    public boolean cadastrar(DisciplinaModel disciplina) {
        for (DisciplinaModel d : disciplinas) {
            if (d.getNome().equals(disciplina.getNome())) {
                return false; 
            }
        }
        disciplinas.add(disciplina);
        return true;
    }

    public List<DisciplinaModel> listarDisciplinas() {
        return new ArrayList<>(disciplinas);
    }
}
