package org.example.view;

import org.example.model.ProfessorModel;
import java.util.List;

public class ProfessorView {
    public void exibirListaProfessores(List<ProfessorModel> professores) {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            for (ProfessorModel p : professores) {
                System.out.println(p);
            }
        }
    }
}
