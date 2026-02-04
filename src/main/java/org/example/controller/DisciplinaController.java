package org.example.controller;

import org.example.model.DisciplinaModel;
import org.example.model.ProfessorModel;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaController {
    private List<DisciplinaModel> disciplinas = new ArrayList<>();


    public boolean cadastrar(DisciplinaModel disciplina) {
        boolean existe = disciplinas.stream()
                .anyMatch(d -> d.getNome().equals(disciplina.getNome()));
        if (existe) return false;
        disciplinas.add(disciplina);
        return true;
    }

    public List<DisciplinaModel> listarDisciplinas() {
        return new ArrayList<>(disciplinas);
    }

    public DisciplinaModel buscarDisciplinaPorCodigo(long codigo) {
        return disciplinas.stream()
                .filter(d -> d.getCodigo() == codigo)
                .findFirst()
                .orElse(null);
    }

    public boolean vincularProfessorADisciplina(long codigoDisciplina, ProfessorModel professor) {
        return disciplinas.stream()
                .filter(d -> d.getCodigo() == codigoDisciplina)
                .peek(d -> d.setProfessor(professor))
                .findFirst()
                .isPresent();
    }
}
