package org.example.controller;

import org.example.model.AlunoModel;

import java.util.List;
import java.util.ArrayList;

public class AlunoController {
    private List<AlunoModel> alunos = new ArrayList<>();

    public boolean adicionarAluno(String nome, long matricula) {
        for (AlunoModel a : alunos) {
            if (a.getMatricula() == matricula) return false;
        }
        alunos.add(new AlunoModel(nome, matricula));
        return true;
}

    public List<AlunoModel> listarAlunos() {
        return new ArrayList<>(alunos);
    }
}
