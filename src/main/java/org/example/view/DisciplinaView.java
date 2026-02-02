package org.example.view;

import org.example.model.DisciplinaModel;
import java.util.List;

public class DisciplinaView {
    private MenuView menuView;

    public DisciplinaView() {}

    public DisciplinaView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void exibirListaDisciplinas(List<DisciplinaModel> disciplinas) {
        System.out.println("\n");
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
        } else {
            for (int i = 0; i <disciplinas.size(); i++) {
                System.out.println((i + 1) + ". " + disciplinas.get(i));
            }
        }
    }

    public DisciplinaModel obterDadosCadastro() {
        String nome = menuView.obterEntrada("Nome da Disciplina: ");
        long codigo = menuView.obterLong("Código da Disciplina: ");
        int carga = menuView.obterInt("Carga Horária de " + nome + ": ");
        return new DisciplinaModel(nome, carga, codigo);
    }

    public int obterDisciplinaEscolhida(List<DisciplinaModel> disciplinas) {
        exibirListaDisciplinas(disciplinas);
        return menuView.obterInt("Escolha a disciplina (número): ");
    }
}
