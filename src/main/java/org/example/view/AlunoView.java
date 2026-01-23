package org.example.view;

import org.example.model.AlunoModel;
import java.util.List;

public class AlunoView {
    public void exibirListaAlunos(List<AlunoModel> alunos) {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (AlunoModel aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }
}