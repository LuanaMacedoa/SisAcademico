package org.example.controller;

import org.example.model.ProfessorModel;
import java.util.ArrayList;
import java.util.List;

public class ProfessorController {
    private List<ProfessorModel> professores = new ArrayList<>();
    
    public boolean cadastrar(ProfessorModel professor) {
        boolean existe = professores.stream()
                .anyMatch(p -> p.getMatricula() == professor.getMatricula());
        if (existe) return false;
        professores.add(professor);
        return true;
    }
    
    public List<ProfessorModel> listarProfessores() {
        return new ArrayList<>(professores);
    }

    public ProfessorModel buscarProfessorPorMatricula(long matricula) {
        return professores.stream()
                .filter(p -> p.getMatricula() == matricula)
                .findFirst()
                .orElse(null);
    }
}