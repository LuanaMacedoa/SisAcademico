package org.example.view;

import org.example.model.ProfessorModel;
import java.util.List;

public class EstagioView {
        public void exibirListaEstagio(List<ProfessorModel> estagios) {
        System.out.println("\n");
        if (estagios.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            for (int i=0; i<estagios.size(); i++) {
                System.out.println((i+1) + ". " + estagios.get(i));
            }
        }
    }
}