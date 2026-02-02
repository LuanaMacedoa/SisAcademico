package org.example.controller;

import org.example.model.AlunoModel;
import org.example.model.DisciplinaModel;

import java.util.List;
import java.util.ArrayList;

public class AlunoController {
    private List<AlunoModel> alunos = new ArrayList<>();

    public boolean cadastrar(AlunoModel aluno) {
        for (AlunoModel a : alunos) {
            if (a.getMatricula() == aluno.getMatricula()) return false;
        }
        alunos.add(aluno);
        return true;
    }

    public AlunoModel buscarAlunoPorMatricula(long matricula) {
        for (AlunoModel a : alunos) {
            if (a.getMatricula() == matricula) {
                return a;
            }
        }
        return null;
    }

    public boolean matricularAlunoEmDisciplina(long matricula, DisciplinaModel disciplina) {
        AlunoModel aluno = buscarAlunoPorMatricula(matricula);
        if (aluno == null) {
            return false;
        }
        return aluno.adicionarDisciplina(disciplina);
    }

    public List<AlunoModel> listarAlunos() {
        return new ArrayList<>(alunos);
    }
}
