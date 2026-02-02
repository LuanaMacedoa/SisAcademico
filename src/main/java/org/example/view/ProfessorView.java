package org.example.view;

import org.example.model.ProfessorModel;
import java.util.List;

public class ProfessorView {
    private MenuView menuView;

    public ProfessorView() {}

    public ProfessorView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void exibirListaProfessores(List<ProfessorModel> professores) {
        System.out.println("\n");
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            for (int i = 0; i <professores.size(); i++) {
                System.out.println((i + 1) + ". " + professores.get(i));
            }
        }
    }

    public ProfessorModel obterDadosCadastro() {
        String nome = menuView.obterEntrada("Nome do Professor: ");
        long matricula = menuView.obterLong("Matrícula do Professor: ");
        return new ProfessorModel(nome, matricula);
    }
}
