package org.example.view;

import org.example.model.*;
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
        System.out.println(VERDE + "\n╔════════════════════════════════════════╗" + RESET);
        System.out.println(VERDE + "║      LISTA DE DISCIPLINAS              ║" + RESET);
        System.out.println(VERDE + "╚════════════════════════════════════════╝" + RESET);
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
        
        System.out.println(CIANO + "\nEscolha a modalidade:" + RESET);
        System.out.println("1. Presencial");
        System.out.println("2. Online");
        int opcaoModalidade = menuView.obterInt("Opção: ");
        
        Modalidade modalidade = (opcaoModalidade == 2) ? Modalidade.ONLINE : Modalidade.PRESENCIAL;
        
        System.out.println(CIANO + "\nEscolha a estratégia de avaliação:" + RESET);
        System.out.println("1. Média Simples (mín. 70.0, média aritmética)");
        System.out.println("2. Média Ponderada (mín. 60.0, últimas notas têm maior peso)");
        System.out.println("3. Maior Nota (mín. 80.0, considera apenas a maior nota)");
        System.out.println("4. Média Rigorosa (mín. 85.0, critério mais exigente)");
        int opcaoEstrategia = menuView.obterInt("Opção: ");
        
        EstrategiaAvaliacao estrategia;
        switch (opcaoEstrategia) {
            case 2:
                estrategia = new MediaPonderada();
                break;
            case 3:
                estrategia = new MaiorNota();
                break;
            case 4:
                estrategia = new MediaRigorosa();
                break;
            default:
                estrategia = new MediaSimples();
                break;
        }
        
        return new DisciplinaModel(nome, carga, codigo, modalidade, estrategia);
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
