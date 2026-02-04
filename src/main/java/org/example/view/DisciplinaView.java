package org.example.view;

import org.example.model.DisciplinaModel;
import org.example.ui.Cores;
import java.util.List;

public class DisciplinaView implements Cores {
    private MenuView menuView;

    public DisciplinaView() {}

    public DisciplinaView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void exibirListaDisciplinas(List<DisciplinaModel> disciplinas) {
        System.out.println(VERDE_BG + BRANCO + "\n╔════════════════════════════════════════╗" + RESET);
        System.out.println(VERDE_BG + BRANCO + "║      LISTA DE DISCIPLINAS            ║" + RESET);
        System.out.println(VERDE_BG + BRANCO + "╚════════════════════════════════════════╝" + RESET);
        if (disciplinas.isEmpty()) {
            System.out.println(VERMELHO + "Nenhuma disciplina cadastrada." + RESET);
        } else {
            for (int i = 0; i <disciplinas.size(); i++) {
                System.out.println(VERDE + "  " + (i + 1) + "." + RESET + " " + disciplinas.get(i));
            }
        }
        System.out.println();
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

    public long obterCodigoDisciplina(List<DisciplinaModel> disciplinas) {
        exibirListaDisciplinas(disciplinas);
        return menuView.obterLong("Digite o código da disciplina: ");
    }
}
