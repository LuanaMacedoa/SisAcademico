package org.example.controller;

import org.example.model.AlunoModel;

import java.util.List;
import java.util.ArrayList;

public class AlunoController {
    private List<AlunoModel> alunos = new ArrayList<>();


    // INFO: metodo privado pra caçar matricula e usado em adicionar aluno pra n
    // INFO: ter duplicidade
    private boolean existeMatricula(long matricula) {
        for (AlunoModel aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                return true;
            }
        }
        return false;
    }

    public boolean adicionarAluno(String nome, long matricula) {
        if (existeMatricula(matricula)) {
            return false; 
        }
        alunos.add(new AlunoModel(nome, matricula));
        return true; 
    }

    public List<AlunoModel> listarAlunos() {
        return new ArrayList<>(alunos);
    }
}
