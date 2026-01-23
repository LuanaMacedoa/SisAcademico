package org.example.controller;

import org.example.model.ProfessorModel;
import java.util.ArrayList;
import java.util.List;

public class ProfessorController {
    private List<ProfessorModel> professores = new ArrayList<>();
    
    public boolean adicionarProfessor(String nome, long id) {
        for (ProfessorModel p : professores) {
            if (p.getId() == id) {
                return false; 
            }
        }
        
        professores.add(new ProfessorModel(nome, id));
        return true;
    }
    
    public List<ProfessorModel> listarProfessores() {
        return new ArrayList<>(professores);
    }
}