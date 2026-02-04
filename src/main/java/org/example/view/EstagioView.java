package org.example.view;

import org.example.model.EstagioModel;
import org.example.ui.Cores;
import java.util.List;

public class EstagioView implements Cores {
    private MenuView menuView;

    public EstagioView() {}

    public EstagioView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void exibirListaEstagios(List<EstagioModel> estagios) {
        System.out.println(VERDE_BG + BRANCO + "\n╔════════════════════════════════════════╗" + RESET);
        System.out.println(VERDE_BG + BRANCO + "║        LISTA DE ESTÁGIOS             ║" + RESET);
        System.out.println(VERDE_BG + BRANCO + "╚════════════════════════════════════════╝" + RESET);
        if (estagios.isEmpty()) {
            System.out.println(VERMELHO + "Nenhum estágio cadastrado." + RESET);
        } else {
            for (int i = 0; i < estagios.size(); i++) {
                System.out.println(VERDE + "  " + (i + 1) + "." + RESET + " " + estagios.get(i));
            }
        }
        System.out.println();
    }

    public EstagioModel obterDadosCadastro() {
        String nome = menuView.obterEntrada("Nome do Estágio: ");
        String descricao = menuView.obterEntrada("Descrição do Estágio: ");
        return new EstagioModel(nome, descricao);
    }
}
