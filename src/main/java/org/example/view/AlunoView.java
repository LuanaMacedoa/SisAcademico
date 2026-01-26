package org.example.view;

import org.example.model.AlunoModel;
import java.util.List;

public class AlunoView {
    public void exibirListaAlunos(List<AlunoModel> alunos) {
        System.out.println("\n");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (int i=0; i<alunos.size(); i++) {
                System.out.println((i+1) + ". " + alunos.get(i));
            }
        }
    }
}