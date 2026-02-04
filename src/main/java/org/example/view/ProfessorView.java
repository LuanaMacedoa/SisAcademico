package org.example.view;

import org.example.model.ProfessorModel;
import org.example.ui.Cores;
import java.util.List;

public class ProfessorView implements Cores {
    private MenuView menuView;

    public ProfessorView() {}

    public ProfessorView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void exibirListaProfessores(List<ProfessorModel> professores) {
        System.out.println(VERDE_BG + BRANCO + "\n╔════════════════════════════════════════╗" + RESET);
        System.out.println(VERDE_BG + BRANCO + "║       LISTA DE PROFESSORES           ║" + RESET);
        System.out.println(VERDE_BG + BRANCO + "╚════════════════════════════════════════╝" + RESET);
        if (professores.isEmpty()) {
            System.out.println(VERMELHO + "Nenhum professor cadastrado." + RESET);
        } else {
            for (int i = 0; i <professores.size(); i++) {
                System.out.println(VERDE + "  " + (i + 1) + "." + RESET + " " + professores.get(i));
            }
        }
        System.out.println();
    }

    public ProfessorModel obterDadosCadastro() {
        String nome = menuView.obterEntrada("Nome do Professor: ");
        long matricula = menuView.obterLong("Matrícula do Professor: ");
        return new ProfessorModel(nome, matricula);
    }
}
