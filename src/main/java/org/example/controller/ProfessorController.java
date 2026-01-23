package org.example.controller;

import org.example.model.ProfessorModel;

import java.util.ArrayList;
import java.util.List;

// nome + matricula
public class ProfessorController {
    private List<ProfessorModel> professores = new ArrayList<>();
    
    public boolean adicionarProfessor(String nome, long id) {
        if (existeProfessor(nome, id)) {
            return false;
        }
    professores.add(new ProfessorModel(nome, id));
    return true;
    }
    
    private boolean existeProfessor(String nome, long id) {
        for (ProfessorModel p : professores) {
            if (p.getId() == id) {
                return true;
            }
        }
    return false; 
    }
    
    public List<ProfessorModel> listarProfessores() {
        return new ArrayList<>(professores);
    }
}