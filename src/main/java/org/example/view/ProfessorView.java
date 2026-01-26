package org.example.view;

import org.example.model.ProfessorModel;
import java.util.List;

public class ProfessorView {
    public void exibirListaProfessores(List<ProfessorModel> professores) {
        System.out.println("\n");
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            for (int i=0; i<professores.size(); i++) {
                System.out.println((i+1) + ". " + professores.get(i));
            }
        }
    }
}
