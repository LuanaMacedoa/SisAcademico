package org.example.controller;

import org.example.model.AlunoModel;
import org.example.model.DisciplinaModel;
import org.example.model.EstagioModel;
import org.example.exception.AlunoNaoMatriculadoEmEstagioException;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import lombok.Data;

@Data
public class AlunoController {
    private List<AlunoModel> alunos = new ArrayList<>();

    public boolean cadastrar(AlunoModel aluno) {
        boolean existe = alunos.stream()
                .anyMatch(a -> a.getMatricula() == aluno.getMatricula());
        if (existe) return false;
        alunos.add(aluno);
        return true;
    }

    public AlunoModel buscarAlunoPorMatricula(long matricula) {
        return alunos.stream()
                .filter(a -> a.getMatricula() == matricula)
                .findFirst()
                .orElse(null);
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

    public void verificarMatriculaEmEstagio(long matricula) throws AlunoNaoMatriculadoEmEstagioException {
        AlunoModel aluno = buscarAlunoPorMatricula(matricula);
        if (aluno.getEstagios().isEmpty()) {
            throw new AlunoNaoMatriculadoEmEstagioException("Aluno não está matriculado em estágio.");
        }
    }


}
