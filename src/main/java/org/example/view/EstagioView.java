package org.example.view;

import org.example.model.EstagioModel;
import java.util.List;

public class EstagioView {
    private MenuView menuView;

    public EstagioView() {}

    public EstagioView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void exibirListaEstagios(List<EstagioModel> estagios) {
        System.out.println("\n");
        if (estagios.isEmpty()) {
            System.out.println("Nenhum estágio cadastrado.");
        } else {
            for (int i = 0; i < estagios.size(); i++) {
                System.out.println((i + 1) + ". " + estagios.get(i));
            }
        }
    }

    public EstagioModel obterDadosCadastro() {
        String nome = menuView.obterEntrada("Nome do Estágio: ");
        String descricao = menuView.obterEntrada("Descrição do Estágio: ");
        return new EstagioModel(nome, descricao);
    }
}
