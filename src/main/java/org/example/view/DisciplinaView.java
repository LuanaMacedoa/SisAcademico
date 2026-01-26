package org.example.view;

import org.example.model.DisciplinaModel;
import java.util.List;

public class DisciplinaView {
    public void exibirListaProfessores(List<DisciplinaModel> disciplinas) {
        System.out.println("\n");
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
        } else {
            for (int i=0; i<disciplinas.size(); i++) {
                System.out.println((i+1) + ". " + disciplinas.get(i));
            }
        }
    }
}
