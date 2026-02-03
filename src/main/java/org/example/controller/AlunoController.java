package org.example.controller;

import org.example.model.AlunoModel;
import org.example.model.DisciplinaModel;
import org.example.model.EstagioModel;

import java.util.List;
import java.util.ArrayList;
import lombok.Data;

@Data
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

    public boolean matricularAlunoEmEstagio(long matricula, EstagioModel estagio) {
        AlunoModel aluno = buscarAlunoPorMatricula(matricula);
        if (aluno == null) {
            return false;
        }
        return aluno.adicionarEstagio(estagio);
    }

    public boolean registrarAvaliacaoEstagio(long matriculaAluno, EstagioModel estagio, double media) {
        AlunoModel aluno = buscarAlunoPorMatricula(matriculaAluno);
        if (aluno == null) {
            return false;
        }

        return estagio.informarMedia(matriculaAluno, media);
    }


}
