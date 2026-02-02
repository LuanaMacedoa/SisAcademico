package org.example.controller;

import org.example.model.ProfessorModel;
import java.util.ArrayList;
import java.util.List;

public class ProfessorController {
    private List<ProfessorModel> professores = new ArrayList<>();
    
    public boolean cadastrar(ProfessorModel professor) {
        for (ProfessorModel p : professores) {
            if (p.getMatricula() == professor.getMatricula()) {
                return false; 
            }
        }
        professores.add(professor);
        return true;
    }
    
    public List<ProfessorModel> listarProfessores() {
        return new ArrayList<>(professores);
    }
}