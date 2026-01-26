package org.example.controller;

import org.example.model.DisciplinaModel;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaController {
    private List<DisciplinaModel> disciplinas = new ArrayList<>();


    public boolean adicionarDisciplina(String nome, int cargaHoraria, long codigo) {
        for (DisciplinaModel d : disciplinas) {
            if (d.getNome().equals(nome) && d.getCodigo() == codigo) {
                return false; 
            }
        }

        disciplinas.add(new DisciplinaModel(nome, cargaHoraria, codigo));
        return true;
    }

    public List<DisciplinaModel> listarDisciplinas() {
        return new ArrayList<>(disciplinas);
    }
}
