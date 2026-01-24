package org.example.controller;

import org.example.model.ProfessorModel;
import java.util.ArrayList;
import java.util.List;

public class ProfessorController {
    private List<ProfessorModel> professores = new ArrayList<>();
    
    public boolean adicionarProfessor(String nome, long matricula) {
        for (ProfessorModel p : professores) {
            if (p.getMatricula() == matricula) {
                return false; 
            }
        }
        
        professores.add(new ProfessorModel(nome, matricula));
        return true;
    }
    
    public List<ProfessorModel> listarProfessores() {
        return new ArrayList<>(professores);
    }
}