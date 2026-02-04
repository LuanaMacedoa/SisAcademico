package org.example;

import java.util.Scanner;

import org.example.view.AlunoView;
import org.example.view.DisciplinaView;
import org.example.view.EstagioView;
import org.example.view.MenuView;
import org.example.controller.AlunoController;
import org.example.controller.DisciplinaController;
import org.example.controller.EstagioController;
import org.example.controller.MenuController;
import org.example.view.ProfessorView;
import org.example.controller.ProfessorController;

public class AppSisAcad {
    public static void main(String[] args) {

        AlunoController alunoCtrl = new AlunoController();
        AlunoView alunoView = new AlunoView();
        
        ProfessorController profCtrl = new ProfessorController();
        ProfessorView profView = new ProfessorView();

        DisciplinaController discipCtrl = new DisciplinaController();
        DisciplinaView discipView = new DisciplinaView();

        EstagioController estagCtrl = new EstagioController();
        EstagioView estagView = new EstagioView();

        Scanner keyboard = new Scanner(System.in);
        MenuView menuView = new MenuView(keyboard);
        MenuController menuCtrl = new MenuController(menuView, alunoCtrl, alunoView,
                                                      profCtrl, profView, discipCtrl, discipView,
                                                     estagCtrl, estagView);

        int opcao = -1;
        while (opcao != 0) {
            menuView.exibirMenu();
            opcao = menuView.obterOpcao();
            menuCtrl.executarFluxo(opcao);
        }
        keyboard.close();
    }
}