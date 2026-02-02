package org.example.view;

import org.example.model.EstagioModel;
import java.util.List;

public class EstagioView {
    public void exibirListaEstagios(List<EstagioModel> estagios) {
        System.out.println("\n");
        if (estagios.isEmpty()) {
            System.out.println("Nenhum estágio cadastrado.");
        } else {
            for (int i=0; i<estagios.size(); i++) {
                System.out.println((i+1) + ". " + estagios.get(i));
            }
        }
    }
}